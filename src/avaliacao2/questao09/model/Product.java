package avaliacao2.questao09.model;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private String description;
    private double discount;
    private LocalDate beginDate;

    public Product(int id, String name, String description, double discount, LocalDate beginDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.beginDate = beginDate;
    }

    public Product(String name, String description, double discount, LocalDate beginDate) {
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.beginDate = beginDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", beginDate=" + beginDate +
                '}';
    }
}
