package Negocio;

import Modelos.Wallet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.*;

public class WalletController {

    public ArrayList<Wallet> walletList = new ArrayList<Wallet>();
    private ObjectMapper walletMapper;
    private File walletFile ;

    public WalletController(ArrayList<Wallet> walletList, File walletFile) {
        this.walletList = walletList;
        this.walletFile = walletFile;
    }

    public int Insert (Wallet newWallet)
    {
        try {
            readFile();
            var aux = walletList.stream().filter(w -> w.getIdClient() == newWallet.getIdClient()).count();
            if (aux > 0)
            {
                return 0;
            }
            walletList.add(newWallet);
            walletMapper.writeValue(walletFile, walletList);
        }catch (IOException e)
        {
            System.out.println("Error al insertar nueva wallet al archivo"+e.getMessage());
        }
        return (int)walletList.stream().count();
    }

    //Metodo qu retorna una wallet segun el codigo de wallet ingresado por parametro
    public Wallet getById(String codeWallet)
    {
        var code = UUID.fromString(codeWallet);
        readFile();
        var rta = new Wallet();
            if(walletList.stream().filter(a -> a.getWalletCode().equals(code)).count() > 0)
            {
                return walletList.stream().filter(a -> a.getWalletCode().equals(code)).findFirst().get();
            }
        return rta;
    }

    private void readFile()
    {
        walletMapper = new ObjectMapper();
        //Esta linea crear el arrayList para poder leer el json
        try {
            CollectionType listWalletFile = walletMapper.getTypeFactory().constructCollectionType(ArrayList.class, Wallet.class);
            walletList = walletMapper.readValue(walletFile, listWalletFile);
        } catch (IOException e) {
            System.out.println("Error en abrir archivo : "+ e.getMessage());
        }
    }


}