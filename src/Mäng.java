import javax.swing.*;

public class Mäng {
    String[] seis = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    Mängija mängija1 = new Mängija("", "X");
    Mängija mängija2 = new Mängija("", "O");


    public void mängi() {
        int[] tulemused = {0, 0};

        //küsime kasutajate käest jOptionPane kasutades nimed
        String nimi1 = JOptionPane.showInputDialog(null, "Mängime mängu trips-traps-trull. \nSisesta 1. mängija nimi:", "");
        String nimi2 = JOptionPane.showInputDialog(null, "Mängime mängu trips-traps-trull. \nSisesta 2. mängija nimi:", "");

        mängija1.setNimi(nimi1);
        mängija2.setNimi(nimi2);
        mängija1.setSümbol("X");
        mängija2.setSümbol("O");

        System.out.println(mängija1.getNimi() + ", sina oled " + mängija1.getSümbol());
        System.out.println(mängija2.getNimi() + ", sina oled " + mängija2.getSümbol());


        while (true) {
            seis = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};//iga tsükli alguses kirjutame seisu "tühjaks" üle
            int alustaja = (int) ( Math.random() * 2 + 1);//valib võrdse tõenäosusega, kas alustab 1. või 2. mängija

            //kui alustaja == 1, siis alustab teine mängija
            if (alustaja == 1) {
                käik(seis, mängija2);
            }

            //for-tsükkel, kus tehakse käik ja seejärel kontrollitakse, kas mäng on lõppenud
            for (int i = 0; i < 5; i++) {
                //esimese mängija käik
                käik(seis, mängija1);
                if (kasKeegiVõitis(seis))
                    break;//kui mäng on läbi, siis lõppeb tsükkel

                //teise mängija käik
                käik(seis, mängija2);
                if (kasKeegiVõitis(seis))
                    break;//kui mäng on läbi, siis lõppeb tsükkel
            }

            System.out.println("Tulemused: ");
            System.out.println(mängija1.getNimi() + ": " + mängija1.getPunktid() + " puntki");
            System.out.println(mängija2.getNimi() + ": " + mängija2.getPunktid() + " puntki");

            String[] options = {"JAH", "EI"};
            int valik = JOptionPane.showOptionDialog(null, "Uus mäng?",
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (valik == 1) {
                break;
            }
        }
    }


    public void käik(String[] seis, Mängija mängija) {
        kuvaMängulaud(seis);
        while (true){
        String valik = JOptionPane.showInputDialog(null, mängija.getNimi() + ", millise numbriga tähistatud ruudule soovid käia?", "");
        if (!seis[(Integer.parseInt(valik)) - 1].equals("X") && !seis[(Integer.parseInt(valik)) - 1].equals("O")) {
            seis[(Integer.parseInt(valik)) - 1] = mängija.getSümbol();
            break;
        }
        else
            System.out.println("Sinna ruutu ei saa, proovi uuesti!");

        }
    }

    public void kuvaMängulaud(String[] seis) {
        System.out.println("\nSeis: ");
        System.out.println(" " + seis[0] + " | " + seis[1] + " | " + seis[2]);
        System.out.println("-----------");
        System.out.println(" " + seis[3] + " | " + seis[4] + " | " + seis[5]);
        System.out.println("-----------");
        System.out.println(" " + seis[6] + " | " + seis[7] + " | " + seis[8]);
    }

    private boolean kasKeegiVõitis(String[] seis) {
        for (int i = 0; i < 3; i++) {
            //kontrollime üle read ja veerud
            if ((seis[3*i].equals(seis[3*i + 1]) && seis[3*i].equals(seis[3*i + 2]))
                    || (seis[i].equals(seis[i + 3]) && seis[i].equals(seis[i + 6]))) {
                //kui keegi võitis, siis läheme võit meetodisse ja tagastame true
                võit(seis[i]);
                return true;
            }
        }
        //kontrollime diagonaalid
        if ((seis[0].equals(seis[4]) && seis[0].equals(seis[8]))
                || (seis[2].equals(seis[4]) && seis[2].equals(seis[6]))) {

            //kui keegi võitis, siis läheme võit meetodisse ja tagastame true
            võit(seis[4]);
            return true;
        }

        //kontrollime, kas kõik käigud on tehtud
        //kui enne seda ei tulnud võitu, siis järelikult on tegemist viigiga
        boolean viik = true;
        for (String sümb : seis) {
            //vaatame iga ruudu kohta, kas see on veel "tühi" ja kui on, siis ei saa veel viik olla
            if (!sümb.equals("X") && !sümb.equals("O")) {
                viik = false;
                break;
            }
        }
        if (viik){
            //kuvame seisu mängulaual
            kuvaMängulaud(seis);
            //väljastame teated mängu lõpu kohta
            System.out.println("MÄNG LÄBI!");
            System.out.println("Mäng jäi viiki");
            return true;
        }
        //kui ükski lõputingimustest veel ei kehti, siis tagastame false
        return false;
    }

    private void võit(String sümbol) {
        //juhul, kui üks mängija võitis
        if (sümbol.equals(mängija1.getSümbol())){
            //kui võitis esimene mängija
            mängija1.lisaPunkt();//lisame talle tabelisse punkti

            //kuvame seisu mängulaual
            kuvaMängulaud(seis);
            //väljastame teated mängu lõpu kohta
            System.out.println("MÄNG LÄBI!");
            System.out.println("Võitis " + mängija1.getNimi());
        }else if (sümbol.equals(mängija2.getSümbol())){
            //kui võitis teine mängija
            mängija2.lisaPunkt();

            //kuvame seisu mängulaual
            kuvaMängulaud(seis);
            //väljastame teated mängu lõpu kohta
            System.out.println("\nMÄNG LÄBI!");
            System.out.println("Võitis " + mängija2.getNimi());
        }
    }
}