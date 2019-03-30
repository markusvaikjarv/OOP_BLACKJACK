import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kaardipakk {



    // 2. Klassis peaks olema privaatne isendiväli kaartidest:
    // List või arraylist, mis koosnevad "Kaart" tüüpi objektidest (List<Kaart> näiteks)
    private List<Kaart> kaardid = new ArrayList<>();


    // 3. Konstruktor, milles sellele isendiväljale luuakse siis List vs arraylist kaartides
    // ( nt. this.kaardid = new ArrayList<Kaart>() )
    public Kaardipakk(List<Kaart> kaardid) {
        this.kaardid = kaardid;
    }


    // 4. Public meetodid, mis ei tagasta midagi ( void ) nimega koostaPakk ja kaardiVäärtus
    // - nende funktsioonide sisu ma teen pärast ise
    public void koostaPakk(){

    }

    public void kaardiVäärtus(){

    }
// 5. Public meetod pakiSuurus mis tagastab int-i. See siis tagastab mitu liiget
// loodud kaardipaki Listis (ül 2) on
    public int pakiSuurus(){
        return kaardid.size();
    }
// 6. toString meetod, mis prindib 2. ülesandes loodud listi välja
    @Override
    public String toString() {
        return "Kaardipaki sisu on järgmine: " + kaardid;
    }
// 7. Public lisaKaart meetod, mis ei tagasta midagi aga parameetrik võtab Kaart tüüpi objekti.
// See siis peaks lisama parameetrina saadud kaardi 2. ülesandes tehtud listi
    public void lisaKaart(Kaart kaart){
        kaardid.add(kaart);
    }
// 8. Public getKaart, mis tagastab Kaardi ja võtab parameetrina indeksi (int).
// Tagastab kaardi sellest 2. ülesande listist antud indeksil
    public Kaart getKaart(int kaardiAsukoht){
        return kaardid.get(kaardiAsukoht);
    }
// 9. Public eemaldaKaart, mis ei tagasta midagi, parameetrik võtab indeksi ja kustutab kaardi 2.
// ülesande listist antud indeksil
    public void eemaldaKaart(int kaardiAsukoht){
        kaardid.remove(kaardiAsukoht);
    }
// 10. Public segaPakk, mis ei tagasta midagi ja ei võta parameetreid.
// See muudab 2. ülesandes loodud listi niimoodi, et segab seal listis loodud kaardid
    public void segaPakk(){
        Collections.shuffle(kaardid);
    }
}
