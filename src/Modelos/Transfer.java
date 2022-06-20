package Modelos;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Transfer implements Serializable {
    private int id;
    private int countValidate;
    private int amount;
    private String date;
    private String userSender;
    private String userReceiver;
    private String criptoName;
    private State state;
    private UUID transferCode;

    public Transfer(int amount, String userSender, String userReceiver, String criptoName, State state) {
        this.amount = amount;
        this.date = LocalDate.now().toString();
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.criptoName = criptoName;
        this.state = state;
        this.transferCode = UUID.randomUUID();
    }

    public Transfer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserSender() {
        return userSender;
    }

    public void setUserSender(String userSender) {
        this.userSender = userSender;
    }

    public String getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(String userReceiver) {
        this.userReceiver = userReceiver;
    }

    public String getCriptoName() {
        return criptoName;
    }

    public void setCriptoName(String criptoName) {
        this.criptoName = criptoName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCountValidate() {
        return countValidate;
    }

    public void setCountValidate(int countValidate) {
        this.countValidate = countValidate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return id == transfer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", date=" + date +
                ", countValidate=" + countValidate +
                ", amount=" + amount +
                ", userSender='" + userSender + '\'' +
                ", userReceiver='" + userReceiver + '\'' +
                ", criptoName='" + criptoName + '\'' +
                ", state=" + state +
                '}';
    }
}
