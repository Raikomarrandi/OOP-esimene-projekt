import javax.swing.*;
import java.util.Random;
// TODO: võiks teha nii, et sa ei saa lisada sinna, kus juba on X või O pandud. Et kui üritad sinna panna siis tuleb mingi "sinna ei saa panna, vali uus koht" vms
// TODO: praegu on viigi puhul veits jama, selle kohta peaks minig eraldi teade ja värki olema
// TODO: praegu kui üks võidab, siis teine saab veel käia, selle peaks ära fixima
// probs on veel mingeid probleeme, pole eriti testinud veel ja optimeerida saab ka veel korralikult ma arvan
public class Mäng {
    String[] seis = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    Mängija mängija1 = new Mängija("", "X");
    Mängija mängija2 = new Mängija("", "O");


    public void mängi() {
        int[] tulemused = {0, 0};

        String nimi1 = JOptionPane.showInputDialog(null, "Mängime mängu trips-traps-trull", "1. mängija nimi");
        String nimi2 = JOptionPane.showInputDialog(null, "Mängime mängu trips-traps-trull", "2. mängija nimi");

        mängija1.setNimi(nimi1);
        mängija2.setNimi(nimi2);
        mängija1.setSümbol("X");
        mängija2.setSümbol("O");

        System.out.println(mängija1.getNimi() + ", sina oled " + mängija1.getSümbol());
        System.out.println(mängija2.getNimi() + ", sina oled " + mängija2.getSümbol());


        while (true) {
            Random r = new Random();
            int alustaja = r.nextInt(2);

            if (alustaja == 1) {
                käik(seis, mängija2);
            }

            for (int i = 0; i < 5; i++) {
                käik(seis, mängija1);
                if (kasKeegiVõitis(seis) == mängija1) {
                    kuvaMängulaud(seis);
                    System.out.println("MÄNG LÄBI!");
                    System.out.println("Võitis" + mängija1.getNimi());
                    break;
                }
                käik(seis, mängija2);
                if (kasKeegiVõitis(seis) == mängija2) {
                    kuvaMängulaud(seis);
                    System.out.println("MÄNG LÄBI!");
                    System.out.println("Võitis" + mängija2.getNimi());
                    break;
                }

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
        String valik = JOptionPane.showInputDialog(null, mängija.getNimi() + ", millise numbriga tähistatud ruudule soovid käia?", "");
        seis[(Integer.parseInt(valik)) - 1] = mängija.getSümbol();
    }

    public void kuvaMängulaud(String[] seis) {
        System.out.println("\nSeis: ");
        System.out.println(" " + seis[0] + " | " + seis[1] + " | " + seis[2]);
        System.out.println("-----------");
        System.out.println(" " + seis[3] + " | " + seis[4] + " | " + seis[5]);
        System.out.println("-----------");
        System.out.println(" " + seis[6] + " | " + seis[7] + " | " + seis[8]);
    }

    private Mängija kasKeegiVõitis(String[] seis) {
        for (int i = 0; i < 3; i++) {
            if ((seis[i].equals(seis[i + 1]) && seis[i].equals(seis[i + 2]))
                    || (seis[i].equals(seis[i + 3]) && seis[i].equals(seis[i + 6]))
                    || (seis[0].equals(seis[4]) && seis[0].equals(seis[8]))
                    || (seis[2].equals(seis[4]) && seis[2].equals(seis[6]))) {


                //TODO: Praegu on see getsümboli asi vale. Tahaks leida, mis sümbol siis võitis ja sellele mängija punkt juurde
                if (seis[0].equals(mängija1.getSümbol())) {
                    mängija1.lisaPunkt();
                    return mängija1;
                }

                if (seis[1].equals(mängija2.getSümbol())) {
                    mängija2.lisaPunkt();
                    return mängija2;
                }
            }
        }
        return null;
    }
}