package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Daniel Ohata
 *
 * A classe lida com a autenticação de usuários em um banco de dados MySQL.
 * Ela possui métodos para conectar ao banco, verificar os dados do usuário e armazenar as suas informações.
 */
public class User {
	/**
	 * 
	 * Método utilizado para conectar com o banco de dados MySQL.
	 */
	public Connection conectarDB() {
		Connection conn = null;
		try {
			// Carrega a classe do driver JDBC MySQL.
			Class.forName("com.mysql.Driver.Manager").newInstance();
			 // Conexão do banco de dados MySQL, usuário e senha.
			String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) { 
			// Espaço para a manipulação de exceções.
		}
		return conn;}
// Variavel que carrega o nome do usuário.
public String nome="";
// Variável que representa o resultado da verificação do usuário com o banco.
public boolean result = false;
/**
 * Método que verifica as credenciais do usuário.
 * @param login O nome do usuário.
 * @param senha A senha do usuário.
 * @return Se a verificação der válido, retorna 'true', senão retornará 'false'.
 */
public boolean verificarUsuario(String login, String senha) {
	String sql = "";
	Connection conn = conectarDB();
	//INSTRUÇÃO SQL
	sql += "selected nome from usuarios ";
	sql += "where login = " + "'" + login + "'";
	sql += " and senha = " + "'" + senha + "';";
	try {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			// Se retornar uma linha, as credenciais são válidas.
			result = true;
			nome = rs.getString("nome");}
		} catch (Exception e) {	
			// Espaço para a manipulação de exceções.
		}
	return result;}
	}//fim da class
