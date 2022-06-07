package Modelos;

import java.util.List;

public class Wallet {
    private Client client;
    private List<Cripto> criptoList;
    private List<Transfer> tranfList;

    public Wallet(Client client, List<Cripto> criptoList, List<Transfer> tranfList) {
        this.client = client;
        this.criptoList = criptoList;
        this.tranfList = tranfList;
    }

    public Wallet() {
    }
}
