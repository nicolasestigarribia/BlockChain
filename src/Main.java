import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.lang.System;


import Modelos.*;
import Negocio.ClientController;
import Negocio.CriptoController;
import Negocio.TransferController;
import Negocio.WalletController;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    static ClientController userController;
    static WalletController walletController;
    static TransferController transferController;

    static CriptoController criptoController;

    static Client userLogged;
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        // Cambiar path segun el directorio donde estemos trabajando

        /*File userFile= new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        File transferFile = new File("C:\\Users\\nestigarribia\\Documents\\GitHub\\BlockChain\\src\\FileData\\TransferWallet.json");*/

       /* File userFile= new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileUser.json");
        File walletFile = new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\FileWallet.json");
        File transferFile = new File("C:\\Users\\gc\\Documents\\GitHub\\BlockChain\\src\\FileData\\TransferWallet.json");*/

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

        //MenuTransferencia(walletController.getByIdWallet("033dbc80-fbef-4241-b4b1-aba20a797d45"));
        //MenuValidarTransferencia();
       // MenuTransferencia(walletController.getByIdWallet("a4556932-2ec0-46eb-833b-ed455400841f"));
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
                MenuLogin();
                break;
            case 2:
                MenuRegistry();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    public static void MenuRegistry() {
        System.out.println("///////  Menu Registro  ////////");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese nombre: ");
        String name = userController.toUpperMayus(scanner.nextLine());

        System.out.println("\nIngrese apellido: ");
        String surname = userController.toUpperMayus(scanner.nextLine());

        boolean rta = false;
        String dni = "";
        //Mientra rta sea true, sigue el bucle
        while (!rta) {
            try {
                System.out.println("\nIngrese DNI: ");
                dni = scanner.nextLine();
                rta = userController.dniValidation(dni);
            } catch (NumberFormatException ex) {
                System.out.println(rta == false ? "Formato de dni invalido \n" : "");
            }
        }


        rta = false;
        String birthday = "";

        while (!rta) {
            try {
                System.out.println("\n Ingrese fecha de nacimiento: m/dd/yyyy");
                birthday = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/uuuu");
                String date = birthday;
                //convert String to LocalDate
                LocalDate localDate = LocalDate.parse(date, formatter);
                rta = userController.ageValidation(localDate);
            }   catch(DateTimeException ex) {
                System.out.println(rta == false ? "Formato invalido, debe ser mayo de edad\n" : "");
        }}

        rta = false;
        String telephone = "";
        //Mientra rta sea true, sigue el bucle
        while (!rta) {
            try{
            System.out.println("\n Ingrese numero de telefono: ");
            telephone = scanner.nextLine();
            rta = userController.dniValidation(telephone);}
            catch (NumberFormatException ex){
            System.out.println(rta == false ? "Formato de telefono invalido \n" : "");
        }}

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
        Client clientNew = new Client(name.trim(),surname.trim(),dni.trim(),birthday.trim(),email.trim(),telephone.trim(),pass.trim());
        int idCLient= userController.createUser(clientNew);
        if(idCLient >0)
        {
            //Creamos unuevaa n wallet para el cliente nuevo y seteamos su idwallet correspondiente
            Wallet newWallet = new Wallet(idCLient, new ArrayList<String>());
            newWallet.setWalletCode(clientNew.getIdWallet());
            walletController.Insert(newWallet);


            System.out.println("\n Usuario creado con exito, su UUID es : " + userController.getById(idCLient).getUuidCliente());
            System.out.println("Guarde su codigo de seguridad, no lo comparta con nadie \n");
            MenuPrincipal();
        }

    }

    public static void MenuLogin()
    {
        boolean rta = false;
        while (!rta){
            Scanner scan = new Scanner(System.in);
            System.out.println("\t\n///////  Login //////// \n");
            System.out.println("Ingrese Mail :");
            String email= scan.nextLine();
            System.out.println("\n Ingrese contraseña:");
            String pass = scan.nextLine();
            System.out.println("\n Ingrese Codigo UUID : ");
            String uuid = scan.nextLine();

            var client = userController.login(email.trim(),pass.trim(),uuid.trim());
            if(client != null)
            {
                rta = true;
                 userLogged =client;
                 MenuWallet();
            }else{
                System.out.println("\n ------ Usuario invalido ------");
                MenuPrincipal();
            }
        }
    }

    public static void MenuWallet()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\t//////  MENU WALLET //////");
        System.out.println("\n 1- Consultar Activos" );
        System.out.println("\n 2- Realizar transaccion a otro usuario" );
        System.out.println("\n 3- Menu Transacciones " );
        System.out.println("\n 4- Ver historial de transacciones" );
        System.out.println("\n 5- Salir");
        System.out.println("\nIngrese opcion deseada :");
        int rta = scan.nextInt();
        Wallet walletClient = walletController.getByIdClient(userLogged.getIdClient());
        switch (rta)
        {
            case 1:
                System.out.println("\n Sus activos son :");
                if(walletClient.getCripto().getAmount() > 0)
                {
                    walletClient.getCripto().mostrar();
                }else{
                    System.out.println("Usted no posee activos en su wallet");
                }
                MenuWallet();
                break;
            case 2:
                MenuTransferencia(walletClient);
                break;
            case 3:
                MenuTransacciones();
                break;
            case 4:
                System.out.println("\n El historial de transacciones es : ");
                List<Transfer> all = transferController.getAll();
                for (Transfer transfer: all) {
                    System.out.println(all);
                }
                MenuWallet();
                break;
            case 5:
                MenuPrincipal();
                break;
        }
    }

    public static void MenuTransacciones (){
        System.out.println("\n\t//////  MENU TRANSACCIONES //////");
        System.out.println("\n 1- Mostrar todas las  transacciones pendientes de validacion" );
        System.out.println("\n 2- Ver mis transacciones sin validar" );
        System.out.println("\n 3- Validar una transaccion" );
        System.out.println("\n 4- Salir" );
        Scanner scan = new Scanner(System.in);
        int rta=scan.nextInt();
        var walletClient= walletController.getByIdClient(userLogged.getIdClient());
        switch (rta){
            case 1:
                List <Transfer> waitingListAll = transferController.getWaitingAll();
                if(waitingListAll.stream().count() != 0)
                {
                    System.out.println("\n Todas las transacciones sin validar : ");
                    for (Transfer transfer: waitingListAll) {
                        transfer.mostrar();
                    }
                }else{
                    System.out.println("\n No hay transacciones para validar ");
                }
                MenuTransacciones();
                break;
            case 2:
                ArrayList <Transfer> waitingList = transferController.getWaitingT(walletClient.getTranfList());
                if(waitingList.stream().count() !=0)
                {
                    System.out.println("\n Mis transacciones sin validar son : ");
                    for (Transfer transfer: waitingList) {
                        transfer.mostrar();
                    }
                }else{
                    System.out.println("\n Ustede no posee transacciones sin validar ");
                }
                MenuTransacciones();
                break;
            case 3:
                MenuValidarTransferencia();
                break;
            case 4:
                userLogged= new Client();
                MenuWallet();
                break;

        }
    }

    public static void MenuTransferencia(Wallet clientWallet)
    {
        int flag =0;
        while (flag == 0)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("\t/// 2- Realizar Tranferencia \n");
            System.out.println("\nIngrese el codigo de la wallet al cual enviar:  ");
            var uuid= scan.nextLine();
            var walletReceiver = walletController.getByIdWallet(uuid);
            while(flag == 0)
            {
                if(walletReceiver != null)
                {
                    scan = new Scanner(System.in);
                    System.out.println("\n Ingrese monto a enviar: ");
                    var monto = scan.nextInt();
                    var aux =clientWallet.getCripto().getAmount();
                    if( aux >= monto)
                    {
                        var montoResta = clientWallet.getCripto().getAmount() -monto;
                        clientWallet.getCripto().setAmount(montoResta);
                        var newTransfer = new Transfer(monto,clientWallet.getWalletCode().toString(),walletReceiver.getWalletCode().toString(), "UTNCoins", State.WAITING);
                        clientWallet.getTranfList().add(newTransfer.getTransferCode().toString());
                        walletController.update(clientWallet);
                        transferController.insert(newTransfer);
                        System.out.println("\n¡ Transferencia realizada con exito !");
                    }else{
                        System.out.println("\n No posee el monto suficiente para la transferencia");

                    }
                }else{
                    System.out.println("\n La wallet ingresada no existe");
                }
                System.out.println("Desea continuar ? s/n");
                scan = new Scanner(System.in);
                var rta =scan.nextLine();
                if(!rta.toLowerCase().equals("s"))
                {
                    flag =1;
                    MenuWallet();
                }
            }
        }

    }

    public static void MenuValidarTransferencia()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("///// 3- Validar una transaccion");
        System.out.println("\n Ingrese el codigo de la tranferencia que quiere validar : ");
        int idTransfer=scan.nextInt();
        var transfer= transferController.getById(idTransfer);

        if(transfer != null && transfer.getState() != State.CONFIRMED)
        {
            var count = transfer.getCountValidate()  + 1;
            if(count == 3)
            {
                transfer.setCountValidate(count);
                transfer.setState(State.CONFIRMED);
                transferController.Update(transfer);
                var wallet =walletController.getByIdWallet(transfer.getUserReceiver());
                wallet.getCripto().setAmount(wallet.getCripto().getAmount()+transfer.getAmount());
                walletController.update(wallet);
                System.out.println("Validacion realizada con exito \n");
                MenuWallet();
            }else{
                transfer.setCountValidate(count);
                transferController.Update(transfer);
                System.out.println("Validacion realizada con exito \n");
                MenuWallet();
            }
        }else{
            System.out.println("\n No existe la transferencia indicada");
            MenuTransacciones();
        }

    }





}