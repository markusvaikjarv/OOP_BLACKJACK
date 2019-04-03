import java.util.Random;
import java.util.ArrayList;


public class Kaardipakk {

    private ArrayList<Kaart> kaardid; //Kaardipakis on List kaarte

    public Kaardipakk() {

        this.kaardid = new ArrayList<Kaart>();

    }

    //Pakis on 52 kaarti
    public void koostaTaisPakk() {
        //Lisan kõik võimalikud 52 mastide-arvude kombinatsiooni pakki
        for (Mast kaardiMast : Mast.values()) {
            for (Vaartus kaardiVaartus : Vaartus.values()) {
                this.kaardid.add(new Kaart(kaardiMast, kaardiVaartus));
            }
        }
    }


    //Segan pakki
    public void sega() {
        //Koostan ajutise kaardipaki, mis hiljem asendab hetkest pakki
        ArrayList<Kaart> ajutineKaardipakk = new ArrayList<Kaart>();

        Random suvaline = new Random();
        int suvaliseKaardiIndeks;
        int algneSuurus = this.kaardid.size();

        for (int i = 0; i < algneSuurus; i++) {
            suvaliseKaardiIndeks = suvaline.nextInt((this.kaardid.size() - 1 - 0) + 1) + 0;
            ajutineKaardipakk.add(this.kaardid.get(suvaliseKaardiIndeks));

            this.kaardid.remove(suvaliseKaardiIndeks);
        }
        this.kaardid = ajutineKaardipakk;
    }


    public void eemaldaKaart(int i) {
        this.kaardid.remove(i);
    }

    public Kaart getKaart(int i) {
        return this.kaardid.get(i);
    }


    //Võtab pakist kõige pealmise kaardi
    public void votaKaart(Kaardipakk tulev) {
        //Lisab võetavast pakist kõige esimse kaardi siia pakki
        this.kaardid.add(tulev.getKaart(0));
        //Eemaldab võetavast pakist kaardi, mis siia pakki asetati
        tulev.eemaldaKaart(0);
    }

    public void lisaKaart(Kaart lisaKaart) {
        this.kaardid.add(lisaKaart);
    }


    //Kalkuleerib paki arvulise väärtuse
    public int kaardiVaartus() {

        int arvulineVaartus = 0;

        int assad = 0; // ässade arv

        for (Kaart kaart : this.kaardid) {
            switch (kaart.getVaartus()) {
                case KAKS:
                    arvulineVaartus += 2;
                    break;
                case KOLM:
                    arvulineVaartus += 3;
                    break;
                case NELI:
                    arvulineVaartus += 4;
                    break;
                case VIIS:
                    arvulineVaartus += 5;
                    break;
                case KUUS:
                    arvulineVaartus += 6;
                    break;
                case SEITSE:
                    arvulineVaartus += 7;
                    break;
                case KAHEKSA:
                    arvulineVaartus += 8;
                    break;
                case ÜHEKSA:
                    arvulineVaartus += 9;
                    break;
                case KÜMME:
                    arvulineVaartus += 10;
                    break;
                case POISS:
                    arvulineVaartus += 10;
                    break;
                case EMAND:
                    arvulineVaartus += 10;
                    break;
                case KUNINGAS:
                    arvulineVaartus += 10;
                    break;
                case ÄSS:
                    assad += 1;
                    break;
            }
        }

        //Ässad on olenevalt olukorrast kas 1 või 11
        for (int i = 0; i < assad; i++) {
            //Ässa väärtus on 1, kui teiste kaartide väärtuste summa on 11 või üle selle
            if (arvulineVaartus > 10) {
                arvulineVaartus += 1;
            } else { //Ässa väärtus on 11, kui teiste kaartide väärtuste summa on 10 või alla selle
                arvulineVaartus += 11;
            }
        }

        return arvulineVaartus;

    }


    public String toString() {
        String kaardiValjund = "";
        for (Kaart kaart : this.kaardid) {
            kaardiValjund += "\n" + kaart.toString();
        }

        return kaardiValjund;

    }

    public void paneKoikPakki(Kaardipakk sihtpunkt) {
        int pakiSuurus = this.kaardid.size();
        //paneb kaardid sihtpunkti pakki
        for (int i = 0; i < pakiSuurus; i++) {
            sihtpunkt.lisaKaart(this.getKaart(i));
        }

        //eemaldab kaardid siinsest pakist
        for (int i = 0; i < pakiSuurus; i++) {
            this.eemaldaKaart(0);
        }
    }

    public int pakiSuurus() {
        return this.kaardid.size();
    }


}