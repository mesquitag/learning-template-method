
package br.com.senai.eugenio.visao;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.senai.eugenio.modelo.Dados;
import br.com.senai.eugenio.persistencia.ComparaCodigo;
import br.com.senai.eugenio.persistencia.ComparaEquipe;
import br.com.senai.eugenio.persistencia.ComparaEquipeNome;
import br.com.senai.eugenio.persistencia.ComparaIdade;
import br.com.senai.eugenio.persistencia.ComparaMotor;
import br.com.senai.eugenio.persistencia.ComparaMotorEquipeNome;
import br.com.senai.eugenio.persistencia.ComparaNome;
import br.com.senai.eugenio.persistencia.ComparaPais;
import br.com.senai.eugenio.persistencia.ComparaPaisNome;
import br.com.senai.eugenio.persistencia.ComparaPontos;
import br.com.senai.eugenio.persistencia.ComparaPontosIdade;
import br.com.senai.eugenio.persistencia.ComparaSobrenome;

public class TelaComFiltro extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private List<Dados> listaDeDados = null;
	private String url = "DadosDosPilotosDeF1.csv";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaComFiltro frame = new TelaComFiltro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaComFiltro() {
		setResizable(false);
		setTitle("Design Patterns - Template Method - Prof. Eugênio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 140, 766, 367);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		String[] colunas = { "Código", "Nome", "Sobrenome", "País", "Idade", "Equipe", "Motor", "Pontos" };
		modelo = new DefaultTableModel(new Object[][] {}, colunas);
		table.setModel(modelo);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(0);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(39, 21, 719, 91);
		contentPane.add(panel);

		JCheckBox ordenaCodigo = new JCheckBox("Ordena por código");

		JCheckBox ordenaNome = new JCheckBox("Ordenar por nome");

		JCheckBox ordenaSobrenome = new JCheckBox("Ordenar por sobrenome");

		JCheckBox ordenaEquipe = new JCheckBox("Ordenar por equipe");

		JCheckBox ordenaMotor = new JCheckBox("Ordenar por motor");

		JCheckBox ordenaPais = new JCheckBox("Ordenar por país");

		JCheckBox ordenaPontos = new JCheckBox("Ordenar por pontos");

		JCheckBox ordenaIdade = new JCheckBox("Ordenar por idade");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(24)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(ordenaCodigo, Alignment.TRAILING)
										.addComponent(ordenaMotor, Alignment.TRAILING))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(ordenaNome, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE).addComponent(ordenaPais))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING).addComponent(ordenaSobrenome)
										.addComponent(ordenaPontos))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING).addComponent(ordenaEquipe)
										.addComponent(ordenaIdade)).addGap(26)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(ordenaNome)
										.addComponent(ordenaSobrenome).addComponent(ordenaCodigo)
										.addComponent(ordenaIdade))
						.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(ordenaPais)
										.addComponent(ordenaPontos).addComponent(ordenaMotor)
										.addComponent(ordenaEquipe)).addContainerGap()));
		panel.setLayout(gl_panel);

		ordenaCodigo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Iterator<Dados> iterator = new ComparaCodigo().listaDados(url);
					listaNaTabela(iterator);
				}
			}
		});

		ordenaNome.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if ((ordenaMotor.isSelected() && ordenaEquipe.isSelected()) && !ordenaPais.isSelected()) {
						Iterator<Dados> iterator = new ComparaMotorEquipeNome().listaDados(url);
						listaNaTabela(iterator);
					} else if (ordenaEquipe.isSelected() && !ordenaPais.isSelected()) {
						Iterator<Dados> iterator = new ComparaEquipeNome().listaDados(url);
						listaNaTabela(iterator);
					} else if (ordenaPais.isSelected() && !ordenaEquipe.isSelected()) {
						Iterator<Dados> iterator = new ComparaPaisNome().listaDados(url);
						listaNaTabela(iterator);
					} else {
						Iterator<Dados> iterator = new ComparaNome().listaDados(url);
						listaNaTabela(iterator);
					}
				}
			}
		});

		ordenaEquipe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Iterator<Dados> iterator = new ComparaEquipe().listaDados(url);
					listaNaTabela(iterator);
				}
			}
		});

		ordenaMotor.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Iterator<Dados> iterator = new ComparaMotor().listaDados(url);
					listaNaTabela(iterator);
				}
			}
		});

		ordenaPontos.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Iterator<Dados> iterator = new ComparaPontos().listaDados(url);
					listaNaTabela(iterator);
				}
			}
		});

		ordenaIdade.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (ordenaPontos.isSelected()) {
						Iterator<Dados> iterator = new ComparaPontosIdade().listaDados(url);
						listaNaTabela(iterator);
					} else {
						Iterator<Dados> iterator = new ComparaIdade().listaDados(url);
						listaNaTabela(iterator);
					}
				}
			}
		});

		ordenaPais.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Iterator<Dados> iterator = new ComparaPais().listaDados(url);
					listaNaTabela(iterator);
				}
			}
		});

		ordenaSobrenome.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Iterator<Dados> iterator = new ComparaSobrenome().listaDados(url);
					listaNaTabela(iterator);
				}
			}
		});
	}

	public void listaNaTabela(Iterator<?> i) {
		modelo.setRowCount(0);
		while (i.hasNext()) {
			Dados dado = (Dados) i.next();
			modelo.addRow(new Object[] { dado.getCodigo(), dado.getNome(), dado.getSobrenome(), dado.getPais(),
					dado.getIdade(), dado.getEquipe(), dado.getMotor(), dado.getPontos() });
		}
	}
}