package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;


public class ComparaCodigo extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		return dadosA.getCodigo() < dadosB.getCodigo();
	}

} 