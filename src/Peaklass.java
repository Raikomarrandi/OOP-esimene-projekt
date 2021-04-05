import javax.swing.*;
import java.util.Random;

public class Peaklass {

    public static void main(String[] args) {
        String[][] seis = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

        Mäng.kuvaMängulaud(seis);

        Mäng.mängi();
    }
}
