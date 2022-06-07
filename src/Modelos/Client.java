package Modelos;

import org.joda.time.DateTime;

import java.sql.Date;

public class Client {
    private  int id;
    private String name;
    private String surname;
    private String dni;
    private DateTime dateOfBirth;
    private String telephone;
    private User user;
    private Wallet wallet;

    public Client(String name, String surname, int id, String dni, DateTime dateOfBirth, String adress, String telephone, User user, Wallet wallet) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dni = dni;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.user = user;
        this.wallet = wallet;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephone='" + telephone + '\'' +
                ", user=" + user +
                ", wallet=" + wallet +
                '}';
    }
}
