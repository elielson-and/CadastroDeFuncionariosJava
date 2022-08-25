package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import DTO.FuncionarioDTO;
import DTO.AdminDTO;

public class FuncionarioDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ArrayList<FuncionarioDTO> lista = new ArrayList<>();
	ResultSet rs;
	
	public void cadastrarFuncionario(FuncionarioDTO objFuncionarioDTO) {
		String sql = "insert into funcionarios values (null,?,?,?,?,?,?,?,?)";
		
		conn = new ConexaoDAO().conectarDB();
		
		try {
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, objFuncionarioDTO.getNome());
			pstm.setString(2, objFuncionarioDTO.getCpf());
			pstm.setString(3, objFuncionarioDTO.getData_nascimento());
			pstm.setString(4, objFuncionarioDTO.getEmail());
			pstm.setString(5, objFuncionarioDTO.getGenero());
			pstm.setString(6, objFuncionarioDTO.getStatus_contatacao());
			pstm.setString(7, objFuncionarioDTO.getTelefone());
			pstm.setString(8, objFuncionarioDTO.getLotacao());
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro funcionariodao: " + erro);
		}
	}
	
	public void editarFuncionario(FuncionarioDTO objFuncionarioDTO,String cpfFuncionario) {
		String sql = "update funcionarios set nome = ?,"
				+ "cpf = ?, data_nascimento = ?, email = ?, genero = ?, status_contratacao = ?, telefone = ?,"
				+ " lotacao = ? where cpf = " + cpfFuncionario;
		
		conn = new ConexaoDAO().conectarDB();
		
		try {
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, objFuncionarioDTO.getNome());
			pstm.setString(2, objFuncionarioDTO.getCpf());
			pstm.setString(3, objFuncionarioDTO.getData_nascimento());
			pstm.setString(4, objFuncionarioDTO.getEmail());
			pstm.setString(5, objFuncionarioDTO.getGenero());
			pstm.setString(6, objFuncionarioDTO.getStatus_contatacao());
			pstm.setString(7, objFuncionarioDTO.getTelefone());
			pstm.setString(8, objFuncionarioDTO.getLotacao());
			pstm.execute();
			pstm.close();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro funcionariodao: " + erro);
		}
	}
	
	public ArrayList<FuncionarioDTO> PesquisarFuncionario(){
		String sql = "select * from funcionarios";
		conn = new ConexaoDAO().conectarDB();
		try {
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				FuncionarioDTO objFuncionario = new FuncionarioDTO();
				objFuncionario.setId(rs.getInt("id"));
				objFuncionario.setNome(rs.getString("nome"));
				objFuncionario.setCpf(rs.getString("cpf"));
				objFuncionario.setData_nascimento(rs.getString("data_nascimento"));
				objFuncionario.setEmail(rs.getString("email"));
				objFuncionario.setGenero(rs.getString("genero"));
				objFuncionario.setStatus_contatacao(rs.getString("status_contratacao"));
				objFuncionario.setTelefone(rs.getString("telefone"));
				objFuncionario.setLotacao(rs.getString("lotacao"));
				lista.add(objFuncionario);
			}
		} catch (Exception e) {
			System.out.println("Erro  " + e);
		}
		return lista;
	}
	
	public ArrayList<FuncionarioDTO> PesquisarFuncionarioPeloCpf(String cpf){
		String sql = "select * from funcionarios where cpf = '"+cpf+"'";
		conn = new ConexaoDAO().conectarDB();
		try {
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				FuncionarioDTO objFuncionario = new FuncionarioDTO();
				objFuncionario.setId(rs.getInt("id"));
				objFuncionario.setNome(rs.getString("nome"));
				objFuncionario.setCpf(rs.getString("cpf"));
				objFuncionario.setData_nascimento(rs.getString("data_nascimento"));
				objFuncionario.setEmail(rs.getString("email"));
				objFuncionario.setGenero(rs.getString("genero"));
				objFuncionario.setStatus_contatacao(rs.getString("status_contratacao"));
				objFuncionario.setTelefone(rs.getString("telefone"));
				objFuncionario.setLotacao(rs.getString("lotacao"));
				lista.add(objFuncionario);
			}
		} catch (Exception e) {
			System.out.println("Erro  " + e);
		}
		return lista;
	}
	
	public void excluirFuncionario(String CpfFuncionario) {
		
		try {
			String sql = "delete from funcionarios where cpf = " + CpfFuncionario;
			conn = new ConexaoDAO().conectarDB();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.execute(sql);
			pstm.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Usuario com CPF: " + CpfFuncionario + " não encontrado!");
			System.out.println("Erro: " + e);
		}
	}
}




