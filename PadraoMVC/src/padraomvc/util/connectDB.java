package padraomvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vickttor
 */
public class connectDB {

    public static String status = "Não conectado...";

    public connectDB() {
    }

    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;

        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            String serverName = "localhost";
            String mydatabase = "ams20241";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.out.println("[ERROR]: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("[ERROR]: " + e.getMessage());
            return null;
        }
    }

    //Método que retorna o status da sua conexão//

    public static String statusConection() {
        return status;
    }
    //Método que fecha sua conexão//

    public static boolean FecharConexao() {
        try {
            connectDB.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return connectDB.getConexaoMySQL();
    }
}