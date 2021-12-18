<?php

require_once('JsonDataController.php');
require_once('classes/Apontamento.php');

session_start();

date_default_timezone_set('America/Sao_Paulo');

$hoje = date("d-m-Y");

if (isset($_POST['pesoAtual']) && isset($_POST['atividade'])) {
	$a = new Apontamento($_POST['dataApontamento'], $_POST['pesoAtual'], $_POST['atividade']);
	registrarNovoApontamento($a);
}

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
		<div style="padding: 0.7em; font-family:Arial, Helvetica, sans-serif">
			<form method="POST">
				<h2>Acompanhamento diário</h2>
				<div>Apontamento do dia: </div>
				<input type="date" name="dataApontamento" value="<?= date("Y-m-d"); ?>" />
				<br><br>
				<div>Registro de peso: (opcional)</div>
				<input type="number" name="pesoAtual" placeholder="Ex: 81">
				<br><br>
				<div>Hoje foi dia de:</div>
				<input type="radio" id="html" name="atividade" value="dose">
				<label for="html">Tomar uma dose!</label><br>
				<input type="radio" id="html" name="atividade" value="escapada">
				<label for="html">Dar uma escapada</label><br>
				<input type="radio" id="css" name="atividade" value="jejum">
				<label for="css">Foco no jejum</label><br>
				<br><br>
				<input type="submit" value="Registrar">
			</form>
		</div>
	</div>
	<div class="container">

	</div>
</body>

</html>