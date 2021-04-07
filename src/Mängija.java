public class Mängija {

    private String nimi;
    private String sümbol;
    private int punktid = 0;

    //konstruktor
    public Mängija(String nimi, String sümbol) {
        this.nimi = nimi;
    }

    //getterid
    public String getNimi() {
        return nimi;
    }

    public String getSümbol() {
        return sümbol;
    }

    public int getPunktid() {
        return punktid;
    }

    //setterid
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setSümbol(String sümbol) {
        this.sümbol = sümbol;
    }

    public void setPunktid(int punktid) {
        this.punktid = punktid;
    }

    public void lisaPunkt() {
        punktid++;
    }
}
