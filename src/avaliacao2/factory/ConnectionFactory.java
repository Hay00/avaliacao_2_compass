package avaliacao2.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/";
        String db = "teste";
        String options = "?useTimezone=true&serverTimezone=UTC";
        return DriverManager.getConnection(url + db + options, "usuario_teste", "senha");
    }
}
