package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import DTO.AdminDTO;

public class AdminDAO {
	
	Connection conn;
	
	public ResultSet autenticacao(AdminDTO objUsuarioDTO) {
		conn = new ConexaoDAO().conectarDB();
		
		try {
			String sql = "select * from admin where usuario = ? and senha = ?";
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, objUsuarioDTO.getNome());
			pstm.setString(2, objUsuarioDTO.getSenha());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ErroUsuarioDao" + erro);
			return null;
		}
		
	}

}
