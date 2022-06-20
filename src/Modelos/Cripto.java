package Modelos;

import java.io.Serializable;

public class Cripto implements Serializable {


    // archivo cripton
    private String name;
    private int amount;
    private double price;

    public Cripto(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Cripto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cripto{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
