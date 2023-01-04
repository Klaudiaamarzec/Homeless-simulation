package company;

import java.awt.*;

import static company.GamePanel.UNIT_SIZE;

public class Tin extends Things
{
    /**
     *Klasa Tin dziedziczy po klasie Things
     */

    public Tin(double money)
    {
        super(money);
    }

    public void draw(Graphics p)
    {
        /**
         *Metoda draw(Graphics p), która rysuje obiekty na planszy
         */

        p.setColor(Color.orange);
        p.fillOval(this.x, this.y, UNIT_SIZE, UNIT_SIZE);
    }
}
