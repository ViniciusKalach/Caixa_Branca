package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Daniel Ohata
 *
 * A classe lida com a autentica��o de usu�rios em um banco de dados MySQL.
 * Ela possui m�todos para conectar ao banco, verificar os dados do usu�rio e armazenar as suas informa��es.
 */
public class User {
	/**
	 * 
	 * M�todo utilizado para conectar com o banco de dados MySQL.
	 */
	public Connection conectarDB() {
		Connection conn = null;
		try {
			// Carrega a classe do driver JDBC MySQL.
			Class.forName("com.mysql.Driver.Manager").newInstance();
			 // Conex�o do banco de dados MySQL, usu�rio e senha.
			String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) { 
			// Espa�o para a manipula��o de exce��es.
		}
		return conn;}
// Variavel que carrega o nome do usu�rio.
public String nome="";
// Vari�vel que representa o resultado da verifica��o do usu�rio com o banco.
public boolean result = false;
/**
 * M�todo que verifica as credenciais do usu�rio.
 * @param login O nome do usu�rio.
 * @param senha A senha do usu�rio.
 * @return Se a verifica��o der v�lido, retorna 'true', sen�o retornar� 'false'.
 */
public boolean verificarUsuario(String login, String senha) {
	String sql = "";
	Connection conn = conectarDB();
	//INSTRU��O SQL
	sql += "selected nome from usuarios ";
	sql += "where login = " + "'" + login + "'";
	sql += " and senha = " + "'" + senha + "';";
	try {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			// Se retornar uma linha, as credenciais s�o v�lidas.
			result = true;
			nome = rs.getString("nome");}
		} catch (Exception e) {	
			// Espa�o para a manipula��o de exce��es.
		}
	return result;}
	}//fim da class
