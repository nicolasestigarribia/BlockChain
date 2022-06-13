import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.Client;
import Modelos.Cripto;
import Modelos.Transfer;
import Modelos.Wallet;
import Negocio.ClientController;
import Negocio.WalletController;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        File userFile= new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        ArrayList<Client> listUser= new ArrayList<Client>();
        ArrayList<Wallet> walletList =  new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        /*var aux = new User("nestigarribia", "1234");
        var aux1 = new User("Matias", "1234");
        var aux2 = new User("Gabriel", "1234");

        listUser.add(aux);
        listUser.add(aux1);
        listUser.add(aux2);
        mapper.writeValue(userFile,listUser);*/

        ClientController userController = new ClientController(userFile, listUser);
        WalletController walletController = new WalletController(walletList, walletFile);


        var rta= userController.login("Manuel", "1234", "c09590fa-ac80-4563-8757-6e860cc04c64");
        if (rta)
        {
            System.out.println("Usuario Logueado correctamente");
        }
        walletController.Insert(new Wallet(2, new ArrayList<Cripto>(), new ArrayList<Transfer>()));
       var wallet = walletController.getById("80e0975b-b284-4ad0-bc12-e89996e9e8bd");

        System.out.println(wallet);
    }

}