package Modelos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Wallet implements Serializable {

    private int idClient;
    private UUID walletCode;
    private List<Cripto> criptoList;
    private List<Transfer> tranfList;

    public Wallet(int idCLient, List<Cripto> criptoList, List<Transfer> tranfList) {
        this.idClient = idCLient;
        this.criptoList = criptoList;
        this.tranfList = tranfList;
        this.walletCode = UUID.randomUUID();
    }

    public Wallet() {
    }
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public List<Cripto> getCriptoList() {
        return criptoList;
    }

    public void setCriptoList(List<Cripto> criptoList) {
        this.criptoList = criptoList;
    }

    public List<Transfer> getTranfList() {
        return tranfList;
    }

    public void setTranfList(List<Transfer> tranfList) {
        this.tranfList = tranfList;
    }

    public UUID getWalletCode() {
        return walletCode;
    }

    public void setWalletCode(UUID walletCode) {
        this.walletCode = walletCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(walletCode, wallet.walletCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletCode);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "idClient=" + idClient +
                ", criptoList=" + criptoList +
                ", tranfList=" + tranfList +
                ", walletCode=" + walletCode +
                '}';
    }
}
