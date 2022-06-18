package Modelos;

import java.io.Serializable;

public class Cripto implements Serializable {


    // archivo cripton
    private String name;
    private int amount;

    public Cripto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Cripto() {
    }


    @Override
    public String toString() {
        return "Cripto{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
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
}
