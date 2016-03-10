
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
		List<Dados> listaDePilotos = new LinkedList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDePiloto = new Dados();

				String registro[] = s.split(",");
				dadosDePiloto.setCodigo(Integer.parseInt(registro[0]));
				dadosDePiloto.setNome(registro[1]);
				dadosDePiloto.setPais(registro[2]);
				dadosDePiloto.setIdade(Integer.parseInt(registro[3]));
				dadosDePiloto.setEquipe(registro[4]);
				dadosDePiloto.setMotor(registro[5]);
				dadosDePiloto.setPontos(Integer.parseInt(registro[6]));

				listaDePilotos.add(dadosDePiloto);
				s = br.readLine();
			}
		}

		return listaDePilotos;
	}

	public static List<Dados> importaDadosParaArrayList(String url) throws FileNotFoundException, IOException {
		List<Dados> listaDePilotos = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDePiloto = new Dados();

				String registro[] = s.split(",");
				dadosDePiloto.setCodigo(Integer.parseInt(registro[0]));
				dadosDePiloto.setNome(registro[1]);
				dadosDePiloto.setPais(registro[2]);
				dadosDePiloto.setIdade(Integer.parseInt(registro[3]));
				dadosDePiloto.setEquipe(registro[4]);
				dadosDePiloto.setMotor(registro[5]);
				dadosDePiloto.setPontos(Integer.parseInt(registro[6]));

				listaDePilotos.add(dadosDePiloto);
				s = br.readLine();
			}
		}

		return listaDePilotos;
	}

	public static List<Dados> importaDadosParaStack(String url) throws FileNotFoundException, IOException {
		List<Dados> pilhaDePilotos = new Stack<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDePiloto = new Dados();

				String registro[] = s.split(",");
				dadosDePiloto.setCodigo(Integer.parseInt(registro[0]));
				dadosDePiloto.setNome(registro[1]);
				dadosDePiloto.setPais(registro[2]);
				dadosDePiloto.setIdade(Integer.parseInt(registro[3]));
				dadosDePiloto.setEquipe(registro[4]);
				dadosDePiloto.setMotor(registro[5]);
				dadosDePiloto.setPontos(Integer.parseInt(registro[6]));

				pilhaDePilotos.add(dadosDePiloto);
				s = br.readLine();
			}
		}
		return pilhaDePilotos;
	}

	public static Queue<Dados> importaDadosParaQueue(String url) throws FileNotFoundException, IOException {
		Queue<Dados> filaDePilotos = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDePiloto = new Dados();

				String registro[] = s.split(",");
				dadosDePiloto.setCodigo(Integer.parseInt(registro[0]));
				dadosDePiloto.setNome(registro[1]);
				dadosDePiloto.setPais(registro[2]);
				dadosDePiloto.setIdade(Integer.parseInt(registro[3]));
				dadosDePiloto.setEquipe(registro[4]);
				dadosDePiloto.setMotor(registro[5]);
				dadosDePiloto.setPontos(Integer.parseInt(registro[6]));

				filaDePilotos.add(dadosDePiloto);
				s = br.readLine();
			}
		}

		return filaDePilotos;
	}

	public static Set<Dados> importaDadosParaSet(String url) throws FileNotFoundException, IOException {
		Set<Dados> conjuntoDePilotos = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDePiloto = new Dados();

				String registro[] = s.split(",");
				dadosDePiloto.setCodigo(Integer.parseInt(registro[0]));
				dadosDePiloto.setNome(registro[1]);
				dadosDePiloto.setPais(registro[2]);
				dadosDePiloto.setIdade(Integer.parseInt(registro[3]));
				dadosDePiloto.setEquipe(registro[4]);
				dadosDePiloto.setMotor(registro[5]);
				dadosDePiloto.setPontos(Integer.parseInt(registro[6]));

				conjuntoDePilotos.add(dadosDePiloto);
				s = br.readLine();
			}
		}

		return conjuntoDePilotos;
	}

	public static Map<Integer, Dados> importaDadosParaMap(String url) throws FileNotFoundException, IOException {
		Map<Integer, Dados> listaDePilotos = new Hashtable<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url)))) {

			String s = br.readLine();

			while (s != null) {
				Dados dadosDePiloto = new Dados();

				String registro[] = s.split(",");
				dadosDePiloto.setCodigo(Integer.parseInt(registro[0]));
				dadosDePiloto.setNome(registro[1]);
				dadosDePiloto.setPais(registro[2]);
				dadosDePiloto.setIdade(Integer.parseInt(registro[3]));
				dadosDePiloto.setEquipe(registro[4]);
				dadosDePiloto.setMotor(registro[5]);
				dadosDePiloto.setPontos(Integer.parseInt(registro[6]));

				listaDePilotos.put(dadosDePiloto.getCodigo(), dadosDePiloto);
				s = br.readLine();
			}
		}

		return listaDePilotos;
	}

}
