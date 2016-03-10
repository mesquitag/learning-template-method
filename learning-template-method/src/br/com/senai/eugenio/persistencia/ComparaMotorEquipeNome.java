
package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaMotorEquipeNome extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int x = dadosA.getMotor().compareTo(dadosB.getMotor());

		if (x < 0) {
			return true;
		} else if (x == 0) {
			int y = dadosA.getEquipe().compareTo(dadosB.getEquipe());

			if (y < 0) {
				return true;
			} else if (y == 0) {
				int z = dadosA.getNome().compareTo(dadosB.getNome());

				if (z < 0) {
					return true;
				}
			}
		}

		return false;
	}
}
