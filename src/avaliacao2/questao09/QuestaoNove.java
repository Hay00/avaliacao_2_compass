package avaliacao2.questao09;

import avaliacao2.factory.ConnectionFactory;
import avaliacao2.questao09.dao.ProductDAO;
import avaliacao2.questao09.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class QuestaoNove {
    public static void main(String[] args) throws SQLException {
        InputHandler ip = new InputHandler();
        ip.handleInput();

    }
}
