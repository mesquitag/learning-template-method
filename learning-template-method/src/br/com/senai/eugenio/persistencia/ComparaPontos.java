package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaPontos extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		return dadosA.getPontos() < dadosB.getPontos();
	}

}
