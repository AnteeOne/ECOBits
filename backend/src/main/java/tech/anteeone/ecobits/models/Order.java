package tech.anteeone.ecobits.models;

public class Order {
    private Integer id;
    private String title;
    private String description;
    private Integer bitsPrice;

    public Order(Integer id, String title, String description, Integer bitsPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.bitsPrice = bitsPrice;
    }

    public Order(String title, String description, Integer bitsPrice) {
        this.title = title;
        this.description = description;
        this.bitsPrice = bitsPrice;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getBitsPrice() {
        return bitsPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bitsPrice=" + bitsPrice +
                '}';
    }
}
