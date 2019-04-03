public class Kaart {

    private Mast mast;
    private Vaartus vaartus;

    public Kaart(Mast mast, Vaartus vaartus) {
        this.mast = mast;
        this.vaartus = vaartus;
    }


    public Vaartus getVaartus() {
        return this.vaartus;
    }

    public String toString() {
        return this.mast.toString() + "-" + this.vaartus.toString();
    }


}
