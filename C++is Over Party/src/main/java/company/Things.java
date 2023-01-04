package company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static company.GamePanel.*;

public class Things<a> extends JPanel implements ActionListener
{
    /**
     *Klasa Things zawiera informacje na temat przedmiotów w symulacji
     *@param x
     *@param y - współrzędne przedmiotu na planszy
     *@param money - cena, jaką posiadają dane przedmioty
     */

    public int x, y;
    public double money;
    Random random = new Random();
    Timer timer;
    boolean running = false;

    public Things(double money)
    {
        this.money=money;
    }

    public void newThings()
    {
        running = true;
        timer = new Timer(100, this);
        timer.start();

        running = true;
        x = random.nextInt(SCREEN_WIDTH/UNIT_SIZE) * UNIT_SIZE;
        y = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}