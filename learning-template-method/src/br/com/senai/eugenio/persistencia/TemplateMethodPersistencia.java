package br.com.senai.eugenio.persistencia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.senai.eugenio.modelo.Dados;

public abstract class TemplateMethodPersistencia {
	abstract boolean isPrimeiro(Dados dadosA, Dados dadosB);
	
	public Iterator<Dados> listaDados(String url) {
        
        	List<Dados> listaDePilotos = new ArrayList<>();

    		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

    			String s = br.readLine();

    			while (s != null) {
    				Dados dadosDePiloto = new Dados();

    				String registro[] = s.split(",");
    				dadosDePiloto.setCodigo(Integer.parseInt(registro[0]));
    				dadosDePiloto.setNome(registro[1]);
    				dadosDePiloto.setSobrenome(registro[2]);
    				dadosDePiloto.setPais(registro[3]);
    				dadosDePiloto.setIdade(Integer.parseInt(registro[4]));
    				dadosDePiloto.setEquipe(registro[5]);
    				dadosDePiloto.setMotor(registro[6]);
    				dadosDePiloto.setPontos(Integer.parseInt(registro[7]));

    				listaDePilotos.add(dadosDePiloto);
    				s = br.readLine();
    			}
    		} catch (FileNotFoundException e) {
    			System.err.print("O arquivo não foi encontrado.");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
            
            for (int i = 0; i < listaDePilotos.size(); i++) {
                for (int j = i + 1; j < listaDePilotos.size(); j++) {
                    
                    if (!isPrimeiro(listaDePilotos.get(i),listaDePilotos.get(j))) {    
                    	Dados temporario = listaDePilotos.get(j);
                        listaDePilotos.set(j, listaDePilotos.get(i));
                        listaDePilotos.set(i, temporario);
                    }
                }
            }
            
            return listaDePilotos.iterator();
        }
}
