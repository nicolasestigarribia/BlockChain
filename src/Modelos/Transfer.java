package Modelos;



import java.io.Serializable;
<<<<<<< Updated upstream
=======
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
>>>>>>> Stashed changes

public class Transfer implements Serializable {
    private int id;
    private int countValidate;
    private int amount;
    private LocalDate date;
    private String userSender;
    private String userReceiver;
    private String criptoName;
    private State state;

<<<<<<< Updated upstream
    public Transfer(int id, int amount, DateTime date, String userSender, String userReceiver, String criptoName, State state) {
=======
    public Transfer(int amount, String userSender, String userReceiver, String criptoName, State state) {
        this.amount = amount;
        this.date = LocalDate.now();
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.criptoName = criptoName;
        this.state = state;
    }

    public Transfer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
>>>>>>> Stashed changes
        this.id = id;
        this.amount = amount;
<<<<<<< Updated upstream
=======
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
>>>>>>> Stashed changes
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
