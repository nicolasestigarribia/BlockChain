import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import Modelos.Client;
import Modelos.Cripto;
import Modelos.Transfer;
import Modelos.Wallet;
import Negocio.ClientController;
import Negocio.CriptoController;
import Negocio.TransferController;
import Negocio.WalletController;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        // Cambiar path segun el directorio donde estemos trabajando

       /* File userFile= new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        File transferFile = new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\TransferWallet.json");*/

        File userFile= new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        File transferFile = new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\TransferWallet.json");
        File criptoFile = new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\FileCripto.json");

        ArrayList<Transfer> transfersList = new ArrayList<Transfer>();
        ArrayList<Client> listUser= new ArrayList<Client>();
        ArrayList<Wallet> walletList =  new ArrayList<>();
        ArrayList<Cripto> criptoList =  new ArrayList<Cripto>();

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
        TransferController transferController = new TransferController(transfersList, transferFile);


        transferController.insert(new Transfer());
        System.out.println(transferController.getById(3));
        //var rta= userController.login("Manuel", "1234", "c09590fa-ac80-4563-8757-6e860cc04c64");
        /*if (rta)
        {
            System.out.println("Usuario Logueado correctamente");
        }
        walletController.Insert(new Wallet(2, new ArrayList<Cripto>(), new ArrayList<Transfer>()));
        var wallet = walletController.getById("80e0975b-b284-4ad0-bc12-e89996e9e8bd");

        CriptoController criptoController = new CriptoController(criptoList, criptoFile);


        Cripto bitcoin = new Cripto("bitcoin",100);
        Cripto ether = new Cripto("etherum",300);
        criptoController.Insert(bitcoin);
        criptoController.Insert(ether);

        Cripto aux = new Cripto();
        aux= criptoController.getByName("Etherum");
        System.out.println(aux);
        System.out.println(criptoController.getByName("bitcoin"));

        System.out.println(wallet);*/

    }

}