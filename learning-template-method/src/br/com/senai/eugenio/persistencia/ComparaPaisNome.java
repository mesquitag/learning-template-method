package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaPaisNome extends TemplateMethodPersistencia{

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		int x = dadosA.getPais().compareTo(dadosB.getPais());
		
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
