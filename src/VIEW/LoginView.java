package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AdminDAO;
import DTO.AdminDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import DTO.*;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Panel;
import javax.swing.JEditorPane;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JLabel lblErroLogin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 339);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(102, 22, 135, 33);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(20, 88, 289, 33);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 65, 107, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 131, 107, 13);
		contentPane.add(lblNewLabel_1_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(20, 154, 289, 33);
		contentPane.add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(0, 0, 255));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logar();
			}
		});
		btnEntrar.setBounds(209, 197, 100, 41);
		contentPane.add(btnEntrar);
	}
	
	public void Logar() {
		try {
			String usuario = txtUsuario.getText();
			String senha = txtSenha.getText();
			
			AdminDTO objUsuarioDto = new AdminDTO();
			objUsuarioDto.setNome(usuario);
			objUsuarioDto.setSenha(senha);
			
			AdminDAO objUsuarioDao = new AdminDAO();
			ResultSet result = objUsuarioDao.autenticacao(objUsuarioDto);
			
			if(result.next()) {
				MenuView menu = new MenuView();
				menu.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", null,2);
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
