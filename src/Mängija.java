public class Mängija {

    private String nimi;
    private String sümbol;
    private int punktid = 0;

    public Mängija(String nimi, String sümbol) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public String getSümbol() {
        return sümbol;
    }

    public int getPunktid() {
        return punktid;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setSümbol(String sümbol) {
        this.sümbol = sümbol;
    }

    public void setPunktid(int punktid) {
        this.punktid = punktid;
    }


    @Override
    public String toString() {
        return "Mängija{" +
                "nimi='" + nimi + '\'' +
                ", punktid=" + punktid +
                '}';
    }

    public void lisaPunkt() {
        punktid++;
    }
}
