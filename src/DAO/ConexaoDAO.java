package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	
	public Connection conectarDB() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/crud_java?user=root&password=";
			conn = DriverManager.getConnection(url);
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro na conexao como banco de dados",null, 0);
			
		}
		
		return conn;
		
	}
	
	
}
