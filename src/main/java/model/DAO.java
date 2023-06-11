package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class DAO {
	/** Modulo de conexão **/
	// paraâmetro de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbigreja?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// metodo de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// teste de conexão

	// public void testeConexao() {
	// try {
	// Connection con = conectar();
	// System.out.println(con);
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	// }

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans membro) {
		String create = "insert into membro (nome, cargo ,dizimista) values (? , ? ,?)";
		try {
			// abrir a conexao com bd
			Connection con = conectar();
			// preparar a query para execução no bb
			PreparedStatement pst = con.prepareStatement(create);
			// subistituir os parametros (?) pelos conteudos das variaveis JavaBeans
			pst.setString(1, membro.getNome());
			pst.setString(2, membro.getCargo());
			pst.setString(3, membro.getDizimista());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// crud read
	public ArrayList<JavaBeans> listarContatos() {
		// criando um objeto para acessar a class javabean
		ArrayList<JavaBeans> cadastros = new ArrayList<>();
		String read = "SELECT * FROM membro WHERE cargo = 'Presbitero' ORDER BY nome;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id_membro = rs.getString(1);
				String nome = rs.getString(2);
				String cargo = rs.getString(3);
				String dizimista = rs.getString(4);
				// populando o arraylist
				cadastros.add(new JavaBeans(id_membro, nome, cargo, dizimista));
			}
			con.close();
			return cadastros;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// crud update 
	// selecionar cadastro
	
	public void selecionarContato(JavaBeans membro ) {
		String read2 = "select * from membro where id_membro = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, membro.getId_membro());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				// setar as variaveis javabeans
				membro.setId_membro(rs.getString(1));
				membro.setNome(rs.getString(2));
				membro.setCargo(rs.getString(3));
				membro.setDizimista(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// editar o cadastro
	
	public void alterarCadastro(JavaBeans membro) {
		String creat = "UPDATE membro SET nome=?, cargo=?, dizimista=? WHERE id_membro=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(creat);
			pst.setString(1, membro.getNome());
			pst.setString(2, membro.getCargo());
			pst.setString(3, membro.getDizimista());
			pst.setString(4, membro.getId_membro());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// crud delet 
	public void deletarCadastro(JavaBeans membro) {
		String delete = "delete from membro where id_membro = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, membro.getId_membro());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
