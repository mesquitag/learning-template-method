
package br.com.senai.eugenio.visao;

import java.awt.Color;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.senai.eugenio.modelo.Dados;
import br.com.senai.eugenio.persistencia.ComparaNome;
import br.com.senai.eugenio.persistencia.ComparaNumeroMatricula;

public class TelaComFiltro extends JFrame {

	/**
	 * 
	 */
   private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private List<Dados> listaDeDados = null;
	private String url = "ArquivoAlunos.csv";

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
		setTitle("| Design Patterns  - Prof. Eugênio |\n");
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
		String[] colunas = { "Nº Matricula", "Nome Completo"};
		modelo = new DefaultTableModel(new Object[][] {}, colunas);
		table.setModel(modelo);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(0);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel.setBounds(17, 21, 755, 91);
		contentPane.add(panel);

		final JCheckBox ordenaNumeroMatricula = new JCheckBox("Ordena por Maatricula");
		final JCheckBox ordenaNome = new JCheckBox("Ordenar por Nome");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(ordenaNumeroMatricula)
					.addGap(18)
					.addComponent(ordenaNome, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(339))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ordenaNumeroMatricula)
						.addComponent(ordenaNome))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		ordenaNumeroMatricula.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Iterator<Dados> iterator = new ComparaNumeroMatricula().listaDados(url);
					listaNaTabela(iterator);
				}
			}
		});

		ordenaNome.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					if ((ordenaNumeroMatricula.isSelected() && !ordenaNome.isSelected())) {
						Iterator<Dados> iterator = new ComparaNumeroMatricula().listaDados(url);
						listaNaTabela(iterator);
					} else if (ordenaNome.isSelected() && !ordenaNumeroMatricula.isSelected()) {
						Iterator<Dados> iterator = new ComparaNome().listaDados(url);
						listaNaTabela(iterator);
					} else {
						Iterator<Dados> iterator = new ComparaNome().listaDados(url);
						listaNaTabela(iterator);
					}
				}
			}
		});
	}

	public void listaNaTabela(Iterator<?> i) {
		modelo.setRowCount(0);
		while (i.hasNext()) {
			Dados dado = (Dados) i.next();
			modelo.addRow(new Object[] { dado.getNumeroMatricula().toString(), dado.getNome()});
		}
	}
}