package Modelos;



import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Client implements Serializable {
    private  int idClient;
    private String name;
    private String surname;
    private String dni;
    private String dateOfBirth;
    private String telephone;
    private String email;
    private String password;
    private UUID uuidCliente;
    private UUID idWallet;

    private boolean activ;

    public Client(String name, String surname, String dni, String dateOfBirth,String email, String telephone, String pass) {

        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.uuidCliente= UUID.randomUUID();
        this.activ = true;
        this.email = email;
        this.password = pass;
    }

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Client() {
        this.uuidCliente = UUID.randomUUID();
        this.activ = true;
    }

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
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

    public void setId(int id) {
        this.idClient = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public UUID getUuidCliente() {
        return uuidCliente;
    }

    public void setUuidCliente(UUID uuidCliente) {
        this.uuidCliente = uuidCliente;
    }

    public UUID getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(UUID idWallet) {
        this.idWallet = idWallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email) && Objects.equals(password, client.password) && Objects.equals(uuidCliente, client.uuidCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, uuidCliente);
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
                ", uuidCliente=" + uuidCliente +
                ", idWallet=" + idWallet +
                '}';
    }
}
