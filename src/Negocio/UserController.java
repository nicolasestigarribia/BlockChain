package Negocio;

import Modelos.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;

public class UserController  {
    private ObjectMapper userMapper;
    private File userFile ;
    public UserController(File userFile) {
        this.userFile= userFile;
    }
    public boolean login(User userLogin)
    {
        ArrayList<User> userList = new ArrayList<>();
        try {
            userMapper = new ObjectMapper();
            //Esta linea crear el arrayList para poder leer el json
            CollectionType listUserFile = userMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
            userList = userMapper.readValue(userFile, listUserFile);

            for (var user: userList) {
                if (userLogin.equals(user)){
                    return true;
                }
            }
        }catch (IOException e)
        {
            System.out.println("Error en login : "+ e.getMessage());
        }
        return false;
    }
}
