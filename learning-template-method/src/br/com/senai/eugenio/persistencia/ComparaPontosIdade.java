
package br.com.senai.eugenio.persistencia;

import br.com.senai.eugenio.modelo.Dados;

public class ComparaPontosIdade extends TemplateMethodPersistencia {

	@Override
	boolean isPrimeiro(Dados dadosA, Dados dadosB) {
		if(dadosA.getPontos() > dadosB.getPontos()) {	
			return false;
		} else if (dadosA.getPontos() == dadosB.getPontos()) {
			if(dadosA.getIdade() > dadosB.getIdade()) {
				return false;
			}
		}
			return true;
	}

}
