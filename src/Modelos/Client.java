package Modelos;



import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Client {
    private  int idClient;
    private String name;
    private String surname;
    private String dni;
    private LocalDate dateOfBirth;
    private String telephone;
    private String email;
    private String password;
    private UUID uuidCliente;
    private UUID idWallet;

    public Client(String name, String surname, String dni, LocalDate dateOfBirth, String telephone) {

        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.uuidCliente= UUID.randomUUID();
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
                ", uuid=" + uuidCliente +
                ", idWallet=" + idWallet +
                '}';
    }
}
