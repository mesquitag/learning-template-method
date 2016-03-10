package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaMotor extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int numero = dadosA.getMotor().compareTo(dadosB.getMotor());

		if (numero <= 0) {
			return true;
		}

		return false;
	}

}
