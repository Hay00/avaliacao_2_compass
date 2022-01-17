package avaliacao2.questao09;

import avaliacao2.factory.ConnectionFactory;
import avaliacao2.questao09.dao.ProductDAO;
import avaliacao2.questao09.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

    private Scanner input = new Scanner(System.in);


    private void showMenu() {
        System.out.println("========= XPTO Sysyem =========");
        System.out.println("Opções:");
        System.out.println("1 - Para INSERIR nova oferta");
        System.out.println("2 - Para ATUALIZAR uma oferta");
        System.out.println("3 - Para DELETAR uma oferta");
        System.out.println("4 - Listar palavras que contém ?");
        System.out.println("0 - Sair");
        System.out.print("Opção desejada: ");
    }

    public void handleInput() {
        while (true) {
            showMenu();
            String value = input.nextLine();
            switch (value) {
                case "0":
                    return;
                case "1":
                    insert();
                    break;
                case "2":
                    update();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    search();
                    break;
                default:
                    System.err.println("Entrada Inválida");
            }
        }
    }

    private void insert() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            RandomData rd = new RandomData();
            productDAO.save(new Product(rd.getString(), rd.getString(), rd.getDouble(), LocalDate.now()));
            productDAO.save(new Product(rd.getString(), rd.getString(), rd.getDouble(), LocalDate.now()));
            productDAO.save(new Product(rd.getString(), rd.getString(), rd.getDouble(), LocalDate.now()));
            System.out.println();
            System.out.println("-=-=-= Sucesso -=-=-=");
            System.out.println();
        } catch (SQLException ex) {
            System.err.println("Erro na conexão");
        }

    }

    private void update() {
        System.out.println("Informe os dados para atualizar o produto");
        System.out.print("Id: ");
        String idStr = input.nextLine();
        System.out.print("Nome: ");
        String name = input.nextLine();
        System.out.print("Descrição: ");
        String description = input.nextLine();
        System.out.print("Desconto: ");
        String discountStr = input.nextLine();

        try {
            Integer.parseInt(idStr);
            Double.parseDouble(discountStr);
        } catch (NumberFormatException ex) {
            System.err.println("Desconto inválido, ex de valores válidos: 0.0, 1, 3.44");
            return;
        }

        int id = Integer.parseInt(idStr);
        double discount = Double.parseDouble(discountStr);

        if (name.isEmpty() || description.isEmpty()) {
            System.err.println("Dados inválidos, insira valores!");
            return;
        }

        try (Connection connection = new ConnectionFactory().getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            Product product = new Product(id, name, description, discount, LocalDate.now());
            productDAO.update(product);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            System.err.println("Erro na conexão");
        }
    }

    private void delete() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Para cancelar digite 0");
        System.out.print("Informe o id do produto que será deletado: ");
        String str = input.nextLine();

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            System.err.println("Valor inválido, somente números");
            return;
        }

        int idToDelete = Integer.parseInt(str);
        if (idToDelete <= 0) return;

        try (Connection connection = new ConnectionFactory().getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            productDAO.delete(idToDelete);
            System.out.println();
            System.out.println("-=-=-= Sucesso -=-=-=");
            System.out.println();
        } catch (SQLException ex) {
            System.err.println("Erro na conexão");
        }
    }

    private void search() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.print("Informe a palavra a ser buscada: ");
        String wordToSearch = input.nextLine();

        if (wordToSearch.isEmpty()) {
            System.err.println("Dados inválidos, insira valores!");
            return;
        }
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            System.out.println("Resultados encontrados: ");
            for (Product product : productDAO.find(wordToSearch)) {
                System.out.println(product.toString());
            }
        } catch (SQLException ex) {
            System.err.println("Erro na conexão");
        }
    }

}
