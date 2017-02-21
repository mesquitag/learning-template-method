
package br.com.senai.eugenio.persistencia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import br.com.senai.eugenio.modelo.Dados;

public class PersistenciaDosDados {

	public static List<Dados> importaDadosParaList(String url) throws FileNotFoundException, IOException {
	
		List<Dados> listaDeAlunos = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {
				String s = br.readLine();

			while (s != null) {
				Dados dadosDeAluno= new Dados();
				String registro[] = s.split(";");
				dadosDeAluno.setNumeroMatricula(Integer.parseInt(registro[0]));
				dadosDeAluno.setNome(registro[1]);
				listaDeAlunos.add(dadosDeAluno);
				s = br.readLine();
			}
		}

		return listaDeAlunos;
	}

	public static List<Dados> importaDadosParaArrayList(String url) throws FileNotFoundException, IOException {
		List<Dados> listaDeAlunos = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDeAluno = new Dados();

				String registro[] = s.split(";");
				dadosDeAluno.setNumeroMatricula(Integer.parseInt(registro[0]));
				dadosDeAluno.setNome(registro[1]);

				listaDeAlunos.add(dadosDeAluno);
				s = br.readLine();
			}
		}

		return listaDeAlunos;
	}

	public static List<Dados> importaDadosParaStack(String url) throws FileNotFoundException, IOException {
		List<Dados> pilhaDePilotos = new Stack<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDeAluno = new Dados();

				String registro[] = s.split(";");
				dadosDeAluno.setNumeroMatricula(Integer.parseInt(registro[0]));
				dadosDeAluno.setNome(registro[1]);

				pilhaDePilotos.add(dadosDeAluno);
				s = br.readLine();
			}
		}
		return pilhaDePilotos;
	}

	public static Queue<Dados> importaDadosParaQueue(String url) throws FileNotFoundException, IOException {
		Queue<Dados> filaDeAlunos = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDeAluno = new Dados();

				String registro[] = s.split(";");
				dadosDeAluno.setNumeroMatricula(Integer.parseInt(registro[0]));
				dadosDeAluno.setNome(registro[1]);

				filaDeAlunos.add(dadosDeAluno);
				s = br.readLine();
			}
		}

		return filaDeAlunos;
	}

	public static Set<Dados> importaDadosParaSet(String url) throws FileNotFoundException, IOException {
		Set<Dados> conjuntoDeAlunos = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDeAluno = new Dados();

				String registro[] = s.split(";");
				dadosDeAluno.setNumeroMatricula(Integer.parseInt(registro[0]));
				dadosDeAluno.setNome(registro[1]);

				conjuntoDeAlunos.add(dadosDeAluno);
				s = br.readLine();
			}
		}

		return conjuntoDeAlunos;
	}

	public static Map<Integer, Dados> importaDadosParaMap(String url) throws FileNotFoundException, IOException {
		Map<Integer, Dados> listaDeAlunos = new Hashtable<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDeAluno = new Dados();

				String registro[] = s.split(";");
				dadosDeAluno.setNumeroMatricula(Integer.parseInt(registro[0]));
				dadosDeAluno.setNome(registro[1]);

				listaDeAlunos.put(dadosDeAluno.getNumeroMatricula(), dadosDeAluno);
				s = br.readLine();
			}
		}

		return listaDeAlunos;
	}

}
