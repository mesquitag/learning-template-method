
package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaPais extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int numero = dadosA.getPais().compareTo(dadosB.getPais());

		if (numero <= 0) {
			return true;
		}

		return false;
	}

}
