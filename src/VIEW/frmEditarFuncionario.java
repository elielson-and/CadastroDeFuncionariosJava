package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.FuncionarioDAO;
import DTO.FuncionarioDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Menu;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class frmEditarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDtNascimento;
	private JTextField txtEmail;
	private JTextField txtTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEditarFuncionario frame = new frmEditarFuncionario();
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
	public frmEditarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar dados do Funcionário");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 21, 244, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 89, 127, 13);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(22, 112, 270, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(30, 170, 127, 13);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setColumns(10);
		txtCpf.setBounds(22, 193, 270, 31);
		contentPane.add(txtCpf);
		
		txtDtNascimento = new JTextField();
		txtDtNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDtNascimento.setColumns(10);
		txtDtNascimento.setBounds(302, 112, 270, 31);
		contentPane.add(txtDtNascimento);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data de nascimento:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(302, 89, 161, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(25, 245, 161, 13);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(25, 268, 270, 31);
		contentPane.add(txtEmail);
		
		JLabel lblGen = new JLabel("Gênero");
		lblGen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGen.setBounds(307, 170, 127, 13);
		contentPane.add(lblGen);
		
		JComboBox drpGenero = new JComboBox();
		drpGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		drpGenero.setBackground(new Color(255, 255, 255));
		drpGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		drpGenero.setBounds(302, 193, 270, 25);
		contentPane.add(drpGenero);
		
		JLabel lblStatus = new JLabel("Status da contratação");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(307, 309, 204, 13);
		contentPane.add(lblStatus);
		
		JComboBox drpStatusContratacao = new JComboBox();
		drpStatusContratacao.setModel(new DefaultComboBoxModel(new String[] {"EFETIVO", "DIARISTA", "AFASTADO", "LICENÇA MATERNIDADE", "EXONERADO"}));
		drpStatusContratacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		drpStatusContratacao.setBackground(Color.WHITE);
		drpStatusContratacao.setBounds(302, 332, 270, 25);
		contentPane.add(drpStatusContratacao);
		
		JLabel lblTelefonel = new JLabel("Telefone:");
		lblTelefonel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefonel.setBounds(302, 245, 161, 13);
		contentPane.add(lblTelefonel);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(302, 268, 270, 31);
		contentPane.add(txtTelefone);
		
		JLabel lblStatus_1 = new JLabel("Lotação");
		lblStatus_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus_1.setBounds(25, 309, 127, 13);
		contentPane.add(lblStatus_1);
		
		JComboBox drpLotacao = new JComboBox();
		drpLotacao.setModel(new DefaultComboBoxModel(new String[] {"Unidade Cohab Anil I", "Unidade São Francisco", "Unidade Cohatrac IV\t", "Unidade Maiobão"}));
		drpLotacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		drpLotacao.setBackground(Color.WHITE);
		drpLotacao.setBounds(25, 332, 270, 25);
		contentPane.add(drpLotacao);
		
		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome,cpf,data_nascimento,email,genero,status_contratacao,telefone,lotacao;
					nome = txtNome.getText();
					cpf = txtCpf.getText();
					data_nascimento = txtDtNascimento.getText();
					email = txtEmail.getText();
					genero = (String) drpGenero.getSelectedItem();
					status_contratacao = (String) drpStatusContratacao.getSelectedItem();
					telefone = txtTelefone.getText();
					lotacao = (String) drpLotacao.getSelectedItem();
					
					FuncionarioDTO objFuncionarioDto = new FuncionarioDTO();
					objFuncionarioDto.setNome(nome);
					objFuncionarioDto.setCpf(cpf);
					objFuncionarioDto.setData_nascimento(data_nascimento);
					objFuncionarioDto.setEmail(email);	
					objFuncionarioDto.setGenero(genero);
					objFuncionarioDto.setStatus_contatacao(status_contratacao);
					objFuncionarioDto.setTelefone(telefone);
					objFuncionarioDto.setLotacao(lotacao);
					
					FuncionarioDAO objFuncionarioDao = new FuncionarioDAO();
					objFuncionarioDao.editarFuncionario(objFuncionarioDto, cpf);
				
					MenuView menu = new MenuView();
					menu.setVisible(true);
					dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar", null,0);
				}
				
			}
		});
		btnCadastrar.setBackground(new Color(0, 128, 0));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar.setBounds(418, 381, 151, 31);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuView menu = new MenuView();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(220, 220, 220));
		btnCancelar.setBounds(257, 381, 151, 31);
		contentPane.add(btnCancelar);
	}
	
	public void carregarCampos(String cpfFuncionario) {
		FuncionarioDAO funcionario = new FuncionarioDAO();
		ArrayList<FuncionarioDTO> lista = funcionario.PesquisarFuncionarioPeloCpf(cpfFuncionario);
		
		for(int num = 0; num < lista.size(); num ++) {
			txtNome.setText(lista.get(num).getNome());
			txtCpf.setText(lista.get(num).getCpf());
			txtDtNascimento.setText(lista.get(num).getData_nascimento());
			txtEmail.setText(lista.get(num).getEmail());
			txtTelefone.setText(lista.get(num).getTelefone());
			
		}
		
	}
	
	public void editarFuncionario(String cpfFuncionario) {
		
	}
}



