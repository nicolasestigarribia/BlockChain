package Negocio;

import Modelos.Cripto;
import Modelos.Wallet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class CriptoController {

    //insert baja  abm get by id y
    public ArrayList<Cripto> criptoList = new ArrayList<Cripto>();
    private ObjectMapper criptoMapper;
    private File criptotFile;

    public CriptoController(ArrayList<Cripto> criptoList, File criptotFile) {
        this.criptoList = criptoList;
        this.criptotFile = criptotFile;
    }


    public int Insert (Cripto newCripto)
    {
        try {
            readFile();
            var aux = criptoList.stream().filter(c -> c.getName().equalsIgnoreCase(newCripto.getName())).count();
            if (aux > 0)
            {
                return 0;
            }
            criptoList.add(newCripto);
            criptoMapper.writeValue(criptotFile, criptoList);
        }catch (IOException e)
        {
            System.out.println("Error al insertar nueva cripto al archivo"+e.getMessage());
        }
        return (int)criptoList.stream().count();
    }

    //Metodo qu retorna la crito segun el nombre ingresado por parametro
    public Cripto getByName(String criptoName)
    {

            readFile();
            var rta = new Cripto();
            var aux= (criptoList.stream().filter(n -> n.getName().equalsIgnoreCase(criptoName) ).count()) ;
            if (aux>0) {
            rta = criptoList.stream().filter(n -> n.getName().equalsIgnoreCase(criptoName)).findFirst().get();


            }else{
            System.out.println("La cripto ingresada no se encuentra");
            }
            return rta;



    }

    private void readFile()
    {
        criptoMapper = new ObjectMapper();
        //Esta linea crear el arrayList para poder leer el json
        try {
            CollectionType listCriptoFile = criptoMapper.getTypeFactory().constructCollectionType(ArrayList.class, Cripto.class);
            criptoList = criptoMapper.readValue(criptotFile, listCriptoFile);
        } catch (IOException e) {
            System.out.println("Error en abrir archivo : "+ e.getMessage());
        }
    }
}
