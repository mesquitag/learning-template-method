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
        
        	List<Dados> listaDeAlunos = new ArrayList<>();

    		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

    			String s = br.readLine();

    			while (s != null) {
    				Dados dadosDePiloto = new Dados();

    				String registro[] = s.split(";");
    				dadosDePiloto.setNumeroMatricula(Integer.parseInt(registro[0]));
    				dadosDePiloto.setNome(registro[1]);

    				listaDeAlunos.add(dadosDePiloto);
    				s = br.readLine();
    			}
    		} catch (FileNotFoundException e) {
    			System.err.print("O arquivo não foi encontrado.");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
            
            for (int i = 0; i < listaDeAlunos.size(); i++) {
                for (int j = i + 1; j < listaDeAlunos.size(); j++) {
                    
                    if (!isPrimeiro(listaDeAlunos.get(i),listaDeAlunos.get(j))) {    
                    	Dados temporario = listaDeAlunos.get(j);
                        listaDeAlunos.set(j, listaDeAlunos.get(i));
                        listaDeAlunos.set(i, temporario);
                    }
                }
            }
            
            return listaDeAlunos.iterator();
        }
}
