package company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static company.GamePanel.*;

public class Policeman extends Person implements People
{
    /**
     *Klasa Policeman zawiera informacje dotyczące policjanta, dziedziczy po klasie Person oraz implementuje interfejs People
     */

    public int a;
    Random random = new Random();
    Timer timer;
    boolean running = false;

    public Policeman(String name, String gender)
    {
        super(name, gender);
    }

    public void move()
    {
        ++this.a;
        int z = Math.round((float)this.random.nextInt(4));
        if ((this.a % 7) == 0) {
            switch (z) {
                case 0:
                    this.x += 2*UNIT_SIZE;
                    break;
                case 1:
                    this.x -=2*UNIT_SIZE;
                    break;
                case 2:
                    this.y +=UNIT_SIZE;
                    break;
                case 3:
                    this.y -= UNIT_SIZE;
                    break;
            }
        }
    }

    public void draw(Graphics p)
    {
        p.setColor(Color.blue);
        p.fillRect(this.x, this.y, UNIT_SIZE, UNIT_SIZE);
    }
}
