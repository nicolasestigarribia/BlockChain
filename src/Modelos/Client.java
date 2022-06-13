package Modelos;

import org.joda.time.DateTime;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

public class Client {
    private  int idClient;
    private String name;
    private String surname;
    private String dni;
    private DateTime dateOfBirth;
    private String telephone;
    private String email;
    private String password;
    private UUID uuid;
    private int idWallet;

    public Client(int idClient, String name, String surname, String dni, DateTime dateOfBirth, String telephone, int idWallet) {
        this.idClient = idClient;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.idWallet = idWallet;
    }

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
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
        return idClient;
    }

    public void setId(int id) {
        this.idClient = id;
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

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email) && Objects.equals(password, client.password) && Objects.equals(uuid, client.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, uuid);
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", uuid=" + uuid +
                ", idWallet=" + idWallet +
                '}';
    }
}
