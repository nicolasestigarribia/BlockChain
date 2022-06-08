package Modelos;

import java.util.List;

public class Wallet {

    private int idClient;
    private List<Cripto> criptoList;
    private List<Transfer> tranfList;

    public Wallet(int idCLient, List<Cripto> criptoList, List<Transfer> tranfList) {
        this.idClient = idCLient;
        this.criptoList = criptoList;
        this.tranfList = tranfList;
    }

    public Wallet() {
    }
}
