package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.FuncionarioDAO;
import DTO.FuncionarioDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class MenuView extends JFrame {

	private JPanel contentPane;
	private JTable tabelaFuncionario;
	private JButton btnListarFuncionarios;
	private JScrollPane scrollPane;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
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
	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("+ Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(0, 128, 128));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFuncionario funcionario = new frmFuncionario();
				funcionario.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(23, 71, 145, 28);
		contentPane.add(btnCadastrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 140, 1009, 204);
		contentPane.add(scrollPane);
		
		tabelaFuncionario = new JTable();
		scrollPane.setViewportView(tabelaFuncionario);
		
		btnListarFuncionarios = new JButton("Atualizar");
		btnListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarValores();
			}
		});
		btnListarFuncionarios.setBounds(914, 109, 115, 21);
		contentPane.add(btnListarFuncionarios);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfFuncionario = JOptionPane.showInputDialog("Insira o CPF do usuario que deseja Editar");
				frmEditarFuncionario editar = new frmEditarFuncionario();
				editar.carregarCampos(cpfFuncionario);
				editar.editarFuncionario(cpfFuncionario);
				editar.setLocationRelativeTo(null);
				editar.setVisible(true);
				dispose();
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditar.setBackground(new Color(0, 0, 205));
		btnEditar.setBounds(180, 71, 145, 28);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfFuncionario = JOptionPane.showInputDialog("Insira o CPF do usuario que deseja Excluir");
				FuncionarioDAO funcionario = new FuncionarioDAO();
				funcionario.excluirFuncionario(cpfFuncionario);
				listarValores();
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBackground(new Color(255, 0, 0));
		btnExcluir.setBounds(335, 71, 145, 28);
		contentPane.add(btnExcluir);
		
		lblNewLabel = new JLabel("ADMINISTRAÇÃO - RECURSOS HUMANOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(23, 9, 553, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(23, 16, -4, 21);
		contentPane.add(btnNewButton);
		listarValores();
	}
	
	private void listarValores() {
		try {
			FuncionarioDAO funcionario = new FuncionarioDAO();
			Object columnNames[] = {"NOME","CPF","DATA NASCIMENTO","EMAIL","GENERO","STATUS","TELEFONE","LOTACAO"};
			DefaultTableModel model = new DefaultTableModel(columnNames, 0);
			model.setNumRows(0);
			
			ArrayList<FuncionarioDTO> lista = funcionario.PesquisarFuncionario();
			
			for(int num = 0; num < lista.size(); num ++) {
				model.addRow(new Object[] {
						lista.get(num).getNome(),
						lista.get(num).getCpf(),
						lista.get(num).getData_nascimento(),
						lista.get(num).getEmail(),
						lista.get(num).getGenero(),
						lista.get(num).getStatus_contatacao(),
						lista.get(num).getTelefone(),
						lista.get(num).getLotacao()
						
				});
				tabelaFuncionario.setModel(model);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar valores: " + e);
		}
	}
	
}






