package avaliacao2.questao10;

import avaliacao2.factory.ConnectionFactory;
import avaliacao2.questao10.dao.EmoticonsDAO;
import avaliacao2.questao10.model.Emoticons;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class QuestaoDez {
    public static void main(String[] args) throws SQLException {

        Scanner scn = new Scanner(System.in);

        System.out.print("Expresse como você está se sentindo: ");
        String input = scn.nextLine();
        EmoticonsEvaluator emoteEvaluator = new EmoticonsEvaluator(input);

        Emoticons emoticons = new Emoticons(emoteEvaluator.evaluateMessage());
        try (Connection connection = new ConnectionFactory().getConnection()) {
            EmoticonsDAO emoticonsDAO = new EmoticonsDAO(connection);
            emoticonsDAO.save(emoticons);
        }
        System.out.println("Resultado: " + emoteEvaluator.evaluateMessage());
    }
}
