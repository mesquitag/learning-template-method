
package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaSobrenome extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int numero = dadosA.getSobrenome().compareTo(dadosB.getSobrenome());

		if (numero <= 0) {
			return true;
		}

		return false;
	}

}
