import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelos.User;
import Negocio.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        File userFile= new File("C:\\Users\\gc\\IdeaProjects\\BlockChain\\src\\FileData\\UserFile.json");

        ObjectMapper mapper = new ObjectMapper();

        UserController userController = new UserController(userFile);

        var rta= userController.login(new User("nestigarribia", "1234","1234"));

        System.out.println(rta);
    }


}