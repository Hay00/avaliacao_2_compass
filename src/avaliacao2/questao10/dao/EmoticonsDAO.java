package avaliacao2.questao10.dao;

import avaliacao2.questao10.model.Emoticons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmoticonsDAO {
    private Connection connection;

    public EmoticonsDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Emoticons emoticons) throws SQLException {
        String sql = "INSERT INTO emoticons (sentiment) values (?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, emoticons.getSentiment());
            pstm.execute();
        }
    }
}
