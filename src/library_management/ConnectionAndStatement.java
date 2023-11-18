package library_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionAndStatement {
    private static ConnectionAndStatement instance;
    private Connection connection;
    private Statement statement;

    private ConnectionAndStatement() {
        try {
            String url = System.getenv("db_url");
            String username = System.getenv("user_admin");
            String password = System.getenv("admin_pass");

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection réussie");
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    public static ConnectionAndStatement getInstance(){
        if(instance == null){
            synchronized (ConnectionAndStatement.class){
                if (instance == null){
                    instance = new ConnectionAndStatement();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public static void main(String[] args) {
        Connection connection = ConnectionAndStatement.getInstance().connection;
    }
}
