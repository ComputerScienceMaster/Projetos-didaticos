<?php

require_once "classes/Apontamento.php";

function consultaUsuario($username, $senha)
{
	$users = file_get_contents("data/usuarios.json");
	$usersDecoded = json_decode($users, True);
	if ($usersDecoded[0]["username"] == $username && $usersDecoded[0]["senha"] == $senha) {
		return $usersDecoded[0];
	} else {
		return false;
	}
}


function registrarNovoApontamento($apontamento)
{
	if (!file_exists("data/apontamentos.json")) {
		$newarray = [];
		file_put_contents("data/apontamentos.json", json_encode($newarray));
	}

	$apontamentos = file_get_contents("data/apontamentos.json");
	$apontamentosD = json_decode($apontamentos, True);
	array_push($apontamentosD, $apontamento);
	file_put_contents("data/apontamentos.json", json_encode($apontamentosD));
}



function carregarApontamentos($operacao)
{
	if (!file_exists("data/apontamentos.json")) {
		return false;
	}

	if ($operacao == "todas") {

		$apontamentos = file_get_contents("data/apontamentos.json");
		$apontamentosD = json_decode($apontamentos, True);
		return $apontamentosD;
	} else if ($operacao == "porMes") {

		$apontamentos = file_get_contents("data/apontamentos.json");
		$apontamentosD = json_decode($apontamentos, True);

		$meses = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
		$toReturn = [];
		foreach ($meses as $ms) {
			$resumo = [];
			//echo "<div> Rodando agora:". $ms . "</div>";
			//echo "<br><br>";
			foreach ($apontamentosD as $a) {
				$time = strtotime($a["dataDoApontamento"]);
				$month = date("F", $time);
				//echo "<div>". $month . " - " . $ms . "</div>";
				if ($month == $ms) {
					//echo "entrei!";

					array_push($resumo, $a);
				}
			}
			if (count($resumo) > 0) {
				$month = ["mes" =>  $ms, "resumo" => $resumo];
				array_push($toReturn, $month);
			}
		}
		//echo "<pre>";
		//print_r($toReturn);
		//echo "</pre>";
		return $toReturn;
	}
}


function calcularResumo($dadosMensais)
{
	$mediaPeso = 0;
	$quantidadeJejuns = 0;
	$quantidadeDoses = 0;
	$quantidadeEscapadas = 0;

	$somaPeso = 0;
	$qtdPesosRegistrados = 0;
	foreach ($dadosMensais as $dm) {
		if ($dm["pesoAtual"] != "") {
			$somaPeso += $dm["pesoAtual"];
			$qtdPesosRegistrados++;
		}
		if ($dm["atividadeDoDia"] == "jejum") {
			$quantidadeJejuns += 1;
		}

		if ($dm["atividadeDoDia"] == "dose") {
			$quantidadeDoses += 1;
		}

		if ($dm["atividadeDoDia"] == "escapada") {
			$quantidadeEscapadas += 1;
		}
	}

	$saldo =  $quantidadeJejuns - ($quantidadeDoses + $quantidadeEscapadas);

	return ["VariacaoDePeso" => $somaPeso / $qtdPesosRegistrados, "qtdJejum" => $quantidadeJejuns, "qtdDoses" => $quantidadeDoses, "qtdEscapadas" => $quantidadeEscapadas, "saldo" => $saldo];
}
