package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaNumeroMatricula extends TemplateMethodPersistencia{

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int numero = dadosA.getNome().compareTo(dadosB.getNome());

		if (numero <= 0) {
			return true;
		}

		return false;
	}
	
	
	
}
