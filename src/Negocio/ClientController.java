package Negocio;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Modelos.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class ClientController {

    public List<Client> clientList = new ArrayList<Client>();
    private ObjectMapper clientMapper;
    private File clientFile ;
    public ClientController(File clientFile , List<Client>clientList) {
        this.clientFile= clientFile;
        this.clientList = clientList;
    }

    //Retorno true si el login fue correcto.
    public Client login(String email, String pass, String code)
    {
        Client clientLogin = new Client(email,pass);
        clientLogin.setUuidCliente(UUID.fromString(code));
        readFile();
            for (var client: clientList) {
                if (clientLogin.equals(client)){
                    return client;
                }
            }
        return null;
    }

    public int Update(Client clientUpdate)
    {
        try {
            readFile();
            var clientToRemove = getById(clientUpdate.getIdClient());
            clientList.remove(clientToRemove);
            clientList.add(clientUpdate);
            clientMapper.writeValue(clientFile,clientList);
            return (int)clientList.stream().count();
        } catch (IOException e) {
            System.out.println("Error al intentar escribir el Archivo  :"+ e.getMessage() );
        }
        return  0;
    }

        public int createUser (Client clientNew){
            int rta =0;
            try {
                readFile();
                //Agrego el ID segun la cantidad de usuarios que haya en el archivo
                clientNew.setIdClient((int) clientList.stream().count() +1);
                clientList.add(clientNew);
                clientMapper.writeValue(clientFile, clientList);
                return clientNew.getIdClient();

            }catch (IOException ex)
            {
                System.out.println("Error en abrir archivo : "+ ex.getMessage());
            }
            return rta;
        }

    public int recordCounter ()
    {
        double counter =0;
        readFile();
        counter = clientList.stream().count()+1;

        return (int)(counter);
    }

    public String toUpperMayus (String name){
        return name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
    }

    public boolean mailValidation(String mail){

        String validMail = "^(.+)@(.+)$";
        Pattern patron = Pattern.compile(validMail);
        Matcher mat = patron.matcher(mail);
        boolean val = mat.find();
        boolean rta = false;
        readFile();
        Client client = new Client();
        if(clientList.stream().filter(a ->a.getEmail().equals(mail)).count() == 0 && val ==true)
        {
            rta = true;
        }
        return rta;

    }

    public String passwordValidation (String pass) {
        String messsage = "";
        // Specify the maximum number of letters in a password
        final int MAX = 8;
        // Specifying the number of uppercase letters in password
        final int MIN_Uppercase = 2;
        // Specifying the minimum lowercase letters in password
        final int MIN_Lowercase = 2;
        // Specifying the number of digits in a password
        final int NUM_Digits = 2;
        // Count number of uppercase letters in a password
        int uppercaseCounter = 0;
        // Counter lowercase letters in a password
        int lowercaseCounter = 0;
        // Count digits in a password
        int digitCounter = 0;
        // count special case letters in a password
        int specialCounter = 0;
        boolean b = false;

        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isUpperCase(c))
                uppercaseCounter++;
            else if (Character.isLowerCase(c))
                lowercaseCounter++;
            else if (Character.isDigit(c))
                digitCounter++;
        }

        if (pass.length() >= MAX && uppercaseCounter >= MIN_Uppercase
                && lowercaseCounter >= MIN_Lowercase && digitCounter >= NUM_Digits ) {
            return messsage;

        }else {

            if (pass.length() < MAX)
                messsage= ("Your password does not contain the following: atleast 8 characters");
            if (lowercaseCounter < MIN_Lowercase)
                messsage=("Your password does not contain the following: Minimum lowercase letters");
            if (uppercaseCounter < MIN_Uppercase)
                messsage=("Your password does not contain the following: Minimum uppercase letters");
            if (digitCounter < NUM_Digits)
                messsage=("Your password does not contain the following: Minimum number of numeric digits");


        }
        return messsage;
    }

    public boolean dniValidation(String cadena) {
        boolean val = false;
        double dniOk = Integer.parseInt(cadena);
        boolean cad = cadena.matches("[0-9]+");
        readFile();
        Client client = new Client();
        if(clientList.stream().filter(a ->a.getDni().equals(cadena)).count() == 0 && dniOk>1000000 && cad ==true)
        {
            val = true;
        }
        return val;
    }

    public String dateInput(String userInput) { //M-d-yyyy
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/dd/uuuu");
        String date = LocalDate.parse(userInput, dateFormat).toString();
        return date ;

    }
    public boolean ageValidation (LocalDate dateOfBirth){
        LocalDate birthdate = dateOfBirth;
        LocalDate now = LocalDate.now();
        int age =0;
        boolean a;
        age = now.getYear() -birthdate.getYear();
        if (age>=18) {
            a = true;
        }else {

            a=false;
        }

        return a;

    }


    //Retorno la cantidad de registro afectados
    public int registry (String email, String pass )
    {
        var clientNew = new Client(email,pass);
        try {

            readFile();
            //Agrego el ID segun la cantidad de usuarios que haya en el archivo
            clientNew.setIdClient((int) clientList.stream().count() +1);
            clientList.add(clientNew);

            clientMapper.writeValue(clientFile, clientList);

        }catch (IOException ex)
        {
            System.out.println("Error en abrir archivo : "+ ex.getMessage());
        }
        return (int)clientList.stream().count();


    }

    public Client getByDni(String dni)
    {
        Client client = new Client();
            readFile();
            if(clientList.stream().filter(a ->a.getDni().equals(dni)).count() > 0)
            {
                client = clientList.stream().filter(a ->a.getDni().equals(dni)).findFirst().get();
                return  client;
            }
        return client;
    }

    public Client getById(int id)
    {
        Client client = new Client();
        readFile();
        if(clientList.stream().filter(a ->a.getIdClient() == id).count() > 0)
        {
            client = clientList.stream().filter(a ->a.getIdClient() == id).findFirst().get();
            return  client;
        }
        return client;
    }

    private void readFile()
    {
        clientMapper = new ObjectMapper();
        //Esta linea crear el arrayList para poder leer el json
        try {
            CollectionType listClientFile = clientMapper.getTypeFactory().constructCollectionType(ArrayList.class, Client.class);
            clientList = clientMapper.readValue(clientFile, listClientFile);
        } catch (IOException e) {
            System.out.println("Error en abrir archivo : "+ e.getMessage());
        }
    }

    public Client getClienteByIdWallet(String idWallet)
    {
        var wallet = new WalletController().getByIdWallet(idWallet);
        return getById(wallet.getIdClient());
    }

}
