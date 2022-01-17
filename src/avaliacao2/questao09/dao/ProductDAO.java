package avaliacao2.questao09.dao;

import avaliacao2.questao09.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Product> showAll() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT id, nome, descricao, desconto, dataInicio desconto FROM produtos";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    products.add(new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getDate(5).toLocalDate()
                    ));
                }
            }
        }
        return products;
    }

    public List<Product> find(String input) throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT id, nome, descricao, desconto, dataInicio desconto FROM produtos WHERE nome LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + input + "%");
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    products.add(new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getDate(5).toLocalDate()
                    ));
                }
            }
        }
        return products;
    }


    public void save(Product product) throws SQLException {
        String sql = "INSERT INTO produtos (nome, descricao, desconto, dataInicio) values (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getDiscount());
            ps.setDate(4, Date.valueOf(product.getBeginDate()));
            ps.execute();
        }
    }

    public void save(int id, Product product) throws SQLException {
        String sql = "INSERT INTO produtos (id, nome, descricao, desconto, dataInicio) values (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getDiscount());
            ps.setDate(5, Date.valueOf(product.getBeginDate()));
            ps.execute();
        }
    }

    public void update(Product product) throws SQLException {
        String sql = "UPDATE produtos SET " +
                "nome = ?, descricao = ?, desconto = ?, dataInicio = ? " +
                "WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getDiscount());
            ps.setDate(4, Date.valueOf(product.getBeginDate()));
            ps.setInt(5, product.getId());
            ps.execute();
            if (ps.getUpdateCount() == 0) this.save(product.getId(), product);
        }
    }


    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            if (ps.getUpdateCount() == 0) System.err.println("Produto não encontrado");
        }
    }
}
