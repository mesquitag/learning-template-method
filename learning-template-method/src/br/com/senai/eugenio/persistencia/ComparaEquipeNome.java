
package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaEquipeNome extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int x = dadosA.getEquipe().compareTo(dadosB.getEquipe());
		
		if(x > 0) {	
			return false;
		} else if (x == 0) {
			int y = dadosA.getNome().compareTo(dadosB.getNome());
			
			if(y > 0) {
				return false;
			}
		}
			return true;
	}

}
