
package br.com.videoaulasneri.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost/javaweb4";
	private String usuario = "postgres";
	private String senha   = "woto"; 
	public Connection getConnetion()  {
		try {
			Class.forName(driver);
			return  DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException erro) {
			throw new RuntimeException(erro);		
		  }
		catch (ClassNotFoundException erro) {
			throw new RuntimeException(erro);		
		  }
	}

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
