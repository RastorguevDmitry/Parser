package ParsPZ;

public class SpisokZakupok {

    private String nomerPZ;
    private String NomerZakupkiEIS;

    private String nazvanieLota;
    private String nachalnayaMaxCenalota;
    private String srokIspolneniyaDogovora;
    private String razmeshenieIzvesheniya;
    private String dopolnitelnayaInformachiya;


    public SpisokZakupok(String nomerPZ, String NomerZakupkiEIS,
                         String nazvanieLota, String nachalnayaMaxCenalota, String srokIspolneniyaDogovora,
                         String razmeshenieIzvesheniya, String dopolnitelnayaInformachiya) {
        this.nomerPZ = nomerPZ;
        this.NomerZakupkiEIS = NomerZakupkiEIS;
        this.nazvanieLota = nazvanieLota;
        this.nachalnayaMaxCenalota = nachalnayaMaxCenalota;
        this.srokIspolneniyaDogovora = srokIspolneniyaDogovora;
        this.razmeshenieIzvesheniya = razmeshenieIzvesheniya;
        this.dopolnitelnayaInformachiya = dopolnitelnayaInformachiya;

    }

    public String getnomerPZ() {
        return nomerPZ;
    }

    public void setnomerPZ(String nomerPZ) {
        this.nomerPZ = nomerPZ;
    }

    public String getNomerZakupkiEIS() {
        return NomerZakupkiEIS;
    }

    public void setNomerZakupkiEIS(String NomerZakupkiEIS) {
        this.NomerZakupkiEIS = NomerZakupkiEIS;
    }

    public String getnazvanieLota() {
        return nazvanieLota;
    }

    public void setnazvanieLota(String nazvanieLota) {
        this.nazvanieLota = nazvanieLota;
    }

    public String getNachalnayaMaxCenalota() {
        return nachalnayaMaxCenalota;
    }

    public void setNachalnayaMaxCenalota(String nachalnayaMaxCenalota) {
        this.nachalnayaMaxCenalota = nachalnayaMaxCenalota;
    }

    public String getSrokIspolneniyaDogovora() {
        return srokIspolneniyaDogovora;
    }

    public void setSrokIspolneniyaDogovora(String srokIspolneniyaDogovora) {
        this.srokIspolneniyaDogovora = srokIspolneniyaDogovora;
    }

    public String getrazmeshenieIzvesheniya() {
        return razmeshenieIzvesheniya;
    }

    public void setrazmeshenieIzvesheniya(String razmeshenieIzvesheniya) {
        this.razmeshenieIzvesheniya = razmeshenieIzvesheniya;
    }

    public String getdopolnitelnayaInformachiya() {
        return dopolnitelnayaInformachiya;
    }

    public void setdopolnitelnayaInformachiya(String dopolnitelnayaInformachiya) {
        this.dopolnitelnayaInformachiya = dopolnitelnayaInformachiya;
    }

}
