package TEST.Wiederholung.faktors;

import java.util.Arrays;


public class Spieler {
    final private int Wurfel_zahl = 3;
    public Wurfel[] wurfel = new Wurfel[Wurfel_zahl];

    public Spieler() {

    }

    public void roll_wurfel() {
        int EVEN = 2;
        int EVEN_CHECK = 0;

        for (int i = 0; i < Wurfel_zahl; i++) {
            wurfel[i] = new Wurfel();
            if (wurfel[i].bekommwurflNum() % EVEN != EVEN_CHECK) {
                break;
            }
        }
    }

    }



