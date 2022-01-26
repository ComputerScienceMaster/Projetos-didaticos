<?php

require_once('JsonDataController.php');
require_once('classes/Apontamento.php');
session_start();

date_default_timezone_set('America/Sao_Paulo');

$ap = carregarApontamentos("porMes");


?>



<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="resources/css/styles.css">
	<title>Controlador de dieta</title>
</head>

<body>
	<div class="header">
		<h1>Bem vindo <?= $_SESSION['nome'] ?>!</h1>
	</div>


	<?php require_once 'elements/navbar.php'; ?>

	<div class="registro-diario center">
		<?php
		if (!$ap) {
			echo "<div> Não existem registros ainda!</div>";
		} else {
		?>
			<?php for ($i = 0; $i < count($ap); $i++) { ?>
				<div class="months">
					<hr>
					<h3 class="headers"><?= $ap[$i]["mes"] ?></h3>
					<table class="table">
						<thead>
							<th>Data do apontamento</th>
							<th>Peso</th>
							<th>Tipo da atividade</th>
						</thead>
						<?php foreach ($ap[$i]["resumo"] as $a) { ?>
							<tr>
								<td><?= $a["dataDoApontamento"] ?></td>
								<td><?= $a["pesoAtual"] ?></td>
								<td><?= $a["atividadeDoDia"] ?></td>
							</tr>
							<?php $resumoMensal = calcularResumo($ap[$i]["resumo"]); ?>
						<?php } ?>
					</table>

					<article class="resumoMensal">
						<h4>Resumo:</h4>
						<ul>
							<li>Peso médio: <strong><?= $resumoMensal['VariacaoDePeso'] ?></strong></li>
							<li>Quantidade de jejuns:<strong> <?= $resumoMensal['qtdJejum'] ?></strong></li>
							<li>Quantidade de doses:<strong><?= $resumoMensal['qtdDoses'] ?></strong></li>
							<li>Quantidade de escapadas:<strong> <?= $resumoMensal['qtdEscapadas'] ?></strong></li>
						</ul>


						<?php
						echo "<h5>Saldo do mês:" . $resumoMensal["saldo"] . "</h5>";

						if ($resumoMensal["saldo"] > 0) {
							echo "<div style='color:green'>Parabéns seu saldo foi positivo!</div>";
						} else if ($resumoMensal["saldo"] == 0) {
							echo "<div style='color:black'>Você bateu na trave, mas manteve o equilíbrio!</div>";
						} else {
							echo "<div style='color:red'>Cuidado, seu saldo foi negativo nesse mês!</div>";
						}

						?>
					</article>
				</div>
			<?php } ?>
	</div>
<?php } ?>
<div class="container">

</div>
</body>

</html>