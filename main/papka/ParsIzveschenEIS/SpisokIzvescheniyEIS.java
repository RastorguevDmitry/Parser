package ParsIzveschenEIS;

public class SpisokIzvescheniyEIS {



    private String NomerZakupkiEIS;
    private String nazvanieLota;
    private String nachalnayaMaxCenalota;

    private String sposobZakupki;
    private String etapZakupki;


    public SpisokIzvescheniyEIS(
            String NomerZakupkiEIS,
            String nazvanieLota,
            String etapZakupki,
            String sposobZakupki,
            String nachalnayaMaxCenalota
            ) {

        this.NomerZakupkiEIS = NomerZakupkiEIS;
        this.nazvanieLota = nazvanieLota;
        this.etapZakupki = etapZakupki;
        this.sposobZakupki = sposobZakupki;
        this.nachalnayaMaxCenalota = nachalnayaMaxCenalota;
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

    public String getetapZakupki() {
        return etapZakupki;
    }

    public void setetapZakupki(String NomerZaketapZakupkiupkiEIS) {
        this.etapZakupki = etapZakupki;
    }

    public String getsposobZakupki() {
        return sposobZakupki;
    }

    public void setsposobZakupki(String sposobZakupki) {
        this.sposobZakupki = sposobZakupki;
    }


    public String getNachalnayaMaxCenalota() {
        return nachalnayaMaxCenalota;
    }

    public void setNachalnayaMaxCenalota(String nachalnayaMaxCenalota) {
        this.nachalnayaMaxCenalota = nachalnayaMaxCenalota;
    }


}
