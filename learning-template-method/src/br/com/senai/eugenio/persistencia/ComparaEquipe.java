package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaEquipe extends TemplateMethodPersistencia{

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int numero1 = dadosA.getEquipe().compareTo(dadosB.getEquipe());

		if (numero1 < 0) {
			return true;
		} else if (numero1 == 0) {
			int numero2 = dadosA.getNome().compareTo(dadosB.getNome());
			
			if (numero2 <= 0) {
				return true;
			}
		}

		return false;
	}

}
