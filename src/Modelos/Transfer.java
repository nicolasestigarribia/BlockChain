package Modelos;

import org.joda.time.DateTime;

import java.io.Serializable;

public class Transfer implements Serializable {
    private int id;
    private int countValidate;
    private int amount;
    private DateTime date;
    private String userSender;
    private String userReceiver;
    private String criptoName;
    private State state;

    public Transfer(int id, int amount, DateTime date, String userSender, String userReceiver, String criptoName, State state) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.criptoName = criptoName;
        this.state = state;
    }

    public int getCountValidate() {
        return countValidate;
    }

    public void setCountValidate(int countValidate) {
        this.countValidate = countValidate;
    }
}
