import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.lang.System;


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
    static ClientController userController;
    static WalletController walletController;
    static TransferController transferController;
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        // Cambiar path segun el directorio donde estemos trabajando

        /*File userFile= new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        File transferFile = new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\TransferWallet.json");*/

        File userFile= new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        File transferFile = new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\TransferWallet.json");

        /*File userFile= new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        File transferFile = new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\TransferWallet.json");
        File criptoFile = new File("C:\\Users\\agust\\OneDrive\\Documentos\\GitHub\\BlockChain\\src\\FileData\\FileCripto.json");*/

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

        userController = new ClientController(userFile, listUser);
         walletController = new WalletController(walletList, walletFile);
         transferController = new TransferController(transfersList, transferFile);


        //transferController.insert(new Transfer());
        //System.out.println(transferController.getById(3));
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
        MenuPrincipal();
    }


    public static void MenuPrincipal()
    {

        System.out.println("\t\n Bienvenido al sistema \n");
        System.out.println("\n 1- Iniciar sesion");
        System.out.println("\n 2- Registrar");
        System.out.println("\n 3- Salir");
        System.out.println( "\n Ingrese opcion : ");
        Scanner scanner = new Scanner(System.in);
        var rta = scanner.nextInt();
        switch (rta)
        {
            case 1:
                //Menu Login
                break;
            case 2:
                MenuRegistry();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    public static void MenuRegistry()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre: \n");
        String name = userController.toUpperMayus(scanner.nextLine());

        System.out.println("Ingrese apellido: \n");
        String surname = userController.toUpperMayus(scanner.nextLine());

        boolean rta = false;
        String dni = "";
        //Mientra rta sea true, sigue el bucle
        while (!rta)
        {
            System.out.println("Ingrese DNI: \n");
            dni = scanner.nextLine();
            rta = userController.dniValidation(dni);
            System.out.println(rta == false ? "Formato de dni invalido \n" : "");
        }

        System.out.println("\n Ingrese fecha de nacimiento: m/dd/yyyy");
        String birthday = userController.dateInput(scanner.nextLine());


        rta = false;
        String telephone = "";
        //Mientra rta sea true, sigue el bucle
        while (!rta)
        {
            System.out.println("\n Ingrese numero de telefono: ");
            telephone = scanner.nextLine();
            rta = userController.dniValidation(telephone);
            System.out.println(rta == false ? "Formato de telefono invalido \n" : "");
        }


        rta = false;
        String email = "";
        //Mientra rta sea true, sigue el bucle
        while (!rta)
        {
            System.out.println("\n Ingrese Email: ");
            email = scanner.nextLine();
            rta = userController.mailValidation(email);
            System.out.println(rta == false ? "Formato email invalido" : "" );
        }

        rta = false;
        String pass = "";
        //Mientra rta sea true, sigue el bucle
        while (!rta)
        {
            System.out.println("\n Ingrese Contraseña: ");
            pass = scanner.nextLine();
            String msj = userController.passwordValidation(pass);
            rta = msj.length() > 0 ? false : true;
            System.out.println(msj);
        }
        Client clientNew = new Client(name,surname,dni,birthday,telephone,email,pass);
        int idCLient= userController.createUser(clientNew);
        if(idCLient >0)
        {
            System.out.println("\nUsuario creado con exito, su UUID es : " + userController.getById(idCLient).getUuid());
            System.out.println("Guardo su codigo de seguridad, no lo comparta con nadie \n");
        }

    }







}