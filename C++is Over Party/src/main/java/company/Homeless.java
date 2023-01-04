package company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static company.GamePanel.*;

public class Homeless extends Person implements People
{
    /**
     *Klasa Homeless zawiera informacje dotyczące bezdomnego, dziedziczy po klasie Person oraz implementuje interfejs People
     *
     *@param uzbierane_puszki - licznik uzbieranych puszek przez bezdomnego w trakcie symulacji
     *@param money=0 - licznik pieniądzy, które bezdomny zbiera w trakcie trwania symulacji
     *@param beer=0 - licznik piw, które bezdomny kupuje w trakcie trwania symulacji
     */

    public int a;
    public int uzbierane_puszki=0;
    public double money=0;
    int beer=0;
    Random random = new Random();
    Timer timer;
    boolean running = false;

    public Homeless(String name, String gender)
    {
        super(name, gender);
    }

    public void move()
    {
        ++this.a;
        int z = Math.round((float)this.random.nextInt(4));
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

    public void draw(Graphics p)
    {
        p.setColor(Color.white);
        p.fillRect(this.x, this.y, UNIT_SIZE, UNIT_SIZE);
    }
}
