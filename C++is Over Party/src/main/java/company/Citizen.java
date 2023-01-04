package company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static company.GamePanel.*;

public class Citizen extends Person implements People
{
    /**
     *Klasa Citizen zawiera informacje dotyczące cywila, dziedziczy po klasie Person oraz implementuje interfejs People
     *@param money - ilość pieniędzy, jaką posiada przy sobie mieszkaniec miasta i którą może dać bezdomnemu
     */

    public double money;
    public int a;
    Random random = new Random();
    Timer timer;
    boolean running = false;

    public Citizen(String name, String gender, double money)
    {
        super(name, gender);
        this.money=money;
    }

    public void move()
    {
        /**
         * Cywil ma się poruszać co 7 przejść bezdomnego, działanie ruchu według switcha,
         * Losujemy 1 z 4 kierunków
         * W zależności jaki wylosuje, tam się porusza
        */

        ++this.a;
        int z = Math.round((float)this.random.nextInt(4));
        if ((this.a & 7) == 0) {
            switch (z) {
                case 0:
                    this.x += UNIT_SIZE;
                    break;
                case 1:
                    this.x -= UNIT_SIZE;
                    break;
                case 2:
                    this.y += UNIT_SIZE;
                    break;
                case 3:
                    this.y -= UNIT_SIZE;
            }
        }
    }

    public void draw(Graphics p)
    {
        p.setColor(Color.red);
        p.fillRect(this.x, this.y, UNIT_SIZE,UNIT_SIZE);
    }

    public double giveMoney()
    {
        /**
         *Metoda giveMoney() określa, jaką kwotę posiadanych pieniędzy cywil może dać bezdomnemu
         *Polega ona na losowaniu liczby z przedziału od 0 do money, czyli maksymalnej kwoty posiadanych pieniędzy
         *Zwraca wylosowaną liczbę number
         */

        Random rand = new Random();
        double number = rand.nextDouble()*money;
        money=money-number;
        number=Math.round(number);
        return number;
    }
}