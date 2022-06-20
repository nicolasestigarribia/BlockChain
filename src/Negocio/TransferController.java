package Negocio;

import Modelos.State;
import Modelos.Transfer;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransferController {

    public ArrayList<Transfer> transferList = new ArrayList<Transfer>();
    private ObjectMapper transferMapper;
    private File transferFile ;

    public TransferController() {
    }

    public TransferController(ArrayList<Transfer> transferList, File transferFile) {
        this.transferList = transferList;
        this.transferFile = transferFile;
    }

    public ArrayList <Transfer> getWaitingT(List<Transfer> transferList){
            ArrayList <Transfer> transferWait  = new ArrayList<>();
          for ( Transfer transfer: transferList){
          if (transfer.getState()==State.WAITING ){
              transferWait.add(transfer);
          }
      }

      return  transferWait;
  }

    public List <Transfer> getWaitingAll(){

        List <Transfer> transferWait  = getAll();
        for ( Transfer transfer: transferList){
            if (transfer.getState()==State.WAITING ){
                transferWait.add(transfer);
            }
        }

        return  transferWait;
    }


    public int insert (Transfer newTranfers)
    {
        try {
            readFile();
            var aux = transferList.stream().filter(w -> w.getId() == newTranfers.getId()).count();
            if(aux > 0)
            {
                return 0;
            }
            newTranfers.setId((int)transferList.stream().count() + 1);
            transferList.add(newTranfers);
            transferMapper.writeValue(transferFile,transferList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (int)transferList.stream().count();
    }


    public Transfer getById(int id)
    {
        readFile();
        Transfer transfer = new Transfer();
        if( transferList.stream().filter(a -> a.getId() == id).count() > 0)
        {
            return transferList.stream().filter(a -> a.getId() == id).findFirst().get();
        }
        return  transfer;
    }

    public List<Transfer> getAll()
    {
        readFile();
        return transferList;
    }

    public void Update(Transfer transferUpdate){


        try {
            readFile();
            var transferRemove = getById(transferUpdate.getId());
            transferList.remove(transferRemove);
            transferList.add((transferUpdate));
            transferMapper.writeValue(transferFile, transferList);
        } catch (IOException e) {
            System.out.println("Error al intentar escribir el archivo : "+ e.getMessage());
        }
    }

    private void readFile()
    {
        transferMapper = new ObjectMapper();
        //Esta linea crear el arrayList para poder leer el json
        try {
            CollectionType listTransferFile = transferMapper.getTypeFactory().constructCollectionType(ArrayList.class, Transfer.class);
            transferList = transferMapper.readValue(transferFile, listTransferFile);
        } catch (IOException e) {
            System.out.println("Error en abrir archivo : "+ e.getMessage());
        }
    }
}
