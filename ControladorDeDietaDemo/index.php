<?php

require_once('JsonDataController.php');
session_start();

if (isset($_POST['username']) && isset($_POST['senha'])){
	$retorno = consultaUsuario($_POST['username'], $_POST['senha']);
	if ($retorno){
		$_SESSION['username'] = $retorno["username"];
		$_SESSION['nome'] = $retorno["nome"];
		header("Location: dashboard.php");
	}else{
		$_POST['message'] = "Infelizmente houve um erro... usuário ou senha estão errados";
	}
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
<body >
	<div class="header">
		<h1>Controlador de dieta</h1>
	</div>
	<?php if(isset($_POST['message'])){?>
		<div class="messages"><?=$_POST['message']?></div>
	<?php } ?> 
	<div class="container">
		<div class="center">
			<form action="index.php" method="POST">
				<div class="input">
					<input type="text" name="username" placeholder="Digite o seu username">
					<input type="text" name="senha" placeholder="Digite sua senha">
				</div>
				<input type="submit" value="Login!">
			</form>
		</div>
	</div>
</body>
</html>