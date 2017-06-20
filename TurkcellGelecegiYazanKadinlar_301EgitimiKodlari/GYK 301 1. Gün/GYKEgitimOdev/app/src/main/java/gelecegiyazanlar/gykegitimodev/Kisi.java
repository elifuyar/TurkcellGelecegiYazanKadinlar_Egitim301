package gelecegiyazanlar.gykegitimodev;

/**
 * Created by User on 11.6.2017.
 */

public class Kisi {

    private  String isim;
    private String soyisim;
    private String  yas;
    private boolean kadinMi;


    public Kisi(String isim, String soyisim, String yas, boolean kadinMi) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.yas = yas;
        this.kadinMi = kadinMi;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", yas='" + yas + '\'' +
                ", kadinMi=" + kadinMi +
                '}';
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public boolean isKadinMi() {
        return kadinMi;
    }

    public void setKadinMi(boolean kadinMi) {
        this.kadinMi = kadinMi;
    }
}
