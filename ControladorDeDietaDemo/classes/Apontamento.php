<?php

class Apontamento{
	public $dataDoApontamento;
	public $pesoAtual;
	public $atividadeDoDia;

	function __construct($dataDoApontamento, $pesoAtual, $atividadeDoDia) {
		$this->dataDoApontamento = $dataDoApontamento;
		$this->pesoAtual = $pesoAtual;
		$this->atividadeDoDia = $atividadeDoDia;

	}
}




?>