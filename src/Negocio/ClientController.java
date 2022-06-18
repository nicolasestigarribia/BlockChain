package Negocio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public boolean login(String email, String pass, String code)
    {
        Client clientLogin = new Client(email,pass);
        clientLogin.setUuid(UUID.fromString(code));
        readFile();
            for (var client: clientList) {
                if (clientLogin.equals(client)){
                    return true;
                }
            }
        return false;
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

}
