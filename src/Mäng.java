import javax.swing.*;
import java.util.Random;

public class Mäng {
    private String[][] seis;
    Mängija mängija1;
    Mängija mängija2;

    public static void mängi() {
        int[] tulemused = {0, 0};

        String nimi1 = JOptionPane.showInputDialog(null, "Mängime mängu trips-traps-trull", "1. mängija nimi");
        String nimi2 = JOptionPane.showInputDialog(null, "Mängime mängu trips-traps-trull", "2. mängija nimi");

        Mängija mängija1 = new Mängija(nimi1, "X");
        Mängija mängija2 = new Mängija(nimi2, "O");
        Mängija[] mängijad = {mängija1, mängija2};

        while (true) {
            String[][] seis = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
            Random r = new Random();
            Mängija alustaja = mängijad[r.nextInt(2)];
            if (alustaja == mängija1) {
                Mängija teine = mängija2;
            } else {
                Mängija teine = mängija1;
            }


            käik(seis, alustaja.getSümbol());
            käik(seis, alustaja.getSümbol());

           /* System.out.println("\nMÄNG LÄBI!");
            System.out.println("Võitis " + võitja.getNimi());
            System.out.println();
            */

            String[] options = {"JAH", "EI"};
            int valik = JOptionPane.showOptionDialog(null, "Uus mäng?",
                    "Click a button",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (valik == 1) {
                break;
            }
        }
    }


    public static void käik(String[][] seis, String käijasümbol) {
        kuvaMängulaud(seis);
        String valik = JOptionPane.showInputDialog(null, "Millise numbriga tähistatud ruudule soovid käia?", "");
        return;
    }

    public static void kuvaMängulaud(String[][] seis) {
        System.out.println("\nSeis: ");
        System.out.println(" " + seis[0][0] + " | " + seis[0][1] + " | " + seis[0][2]);
        System.out.println("-----------");
        System.out.println(" " + seis[1][0] + " | " + seis[1][1] + " | " + seis[1][2]);
        System.out.println("-----------");
        System.out.println(" " + seis[2][0] + " | " + seis[2][1] + " | " + seis[2][2]);
    }

    private Mängija kasKeegiVõitis(String[][] seis) {
        for (int i = 0; i < 3; i++) {
            if ((seis[i][0].equals(seis[i][1]) && seis[i][0].equals(seis[i][2]))
                    || (seis[0][i].equals(seis[1][i]) && seis[0][i].equals(seis[2][i]))
                    || (seis[0][0].equals(seis[1][1]) && seis[0][0].equals(seis[2][2]))
                    || (seis[0][2].equals(seis[1][1]) && seis[0][2].equals(seis[2][0]))) {

                if (seis[0][0].equals(mängija1.getSümbol())) {
                    mängija1.lisaPunkt();
                    return mängija1;
                }

                if (seis[0][0].equals(mängija2.getSümbol())) {
                    mängija2.lisaPunkt();
                    return mängija2;
                }
            }
        }
        return null;
    }
}