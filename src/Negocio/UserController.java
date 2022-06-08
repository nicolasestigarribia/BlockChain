package Negocio;

import Modelos.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;

public class UserController  {

    public List<User> userList = new ArrayList<User>();
    private ObjectMapper userMapper;
    private File userFile ;
    public UserController(File userFile , List<User> userList) {
        this.userFile= userFile;
        this.userList = userList;
    }

    //Retorno true si el login fue correcto.
    public boolean login(String email, String pass, String code)
    {
        User userLogin = new User(email,pass);
        userLogin.setUuid(UUID.fromString(code));
        readFile();
            for (var user: userList) {
                if (userLogin.equals(user)){
                    return true;
                }
            }
        return false;
    }

    //Retorno la cantidad de registro afectados
    public int registry (String email, String pass )
    {
        var userNew = new User(email,pass);
        try {

            readFile();
            //Agrego el ID segun la cantidad de usuarios que haya en el archivo
             userNew.setIdUser((int) userList.stream().count() +1);
            userList.add(userNew);

            userMapper.writeValue(userFile, userList);

        }catch (IOException ex)
        {
            System.out.println("Error en abrir archivo : "+ ex.getMessage());
        }
        return (int)userList.stream().count();
    }

    private void readFile()
    {
        userMapper = new ObjectMapper();
        //Esta linea crear el arrayList para poder leer el json
        try {
            CollectionType listUserFile = userMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
            userList = userMapper.readValue(userFile, listUserFile);
        } catch (IOException e) {
            System.out.println("Error en abrir archivo : "+ e.getMessage());
        }

    }

}
