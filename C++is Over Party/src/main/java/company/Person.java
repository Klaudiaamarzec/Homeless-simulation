package company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static company.GamePanel.*;

public class Person<a> extends JPanel implements ActionListener
{
    /**
     *Klasa Person zawiera informacje na temat ludzi w symulacji
     *@param name - imię postaci
     *@param gender - płeć
     *@param x
     *@param y - współrzędne postaci na planszy
     */

    public String name;
    public String gender;
    public int x, y;
    Random random = new Random();
    Timer timer;
    boolean running = false;

    public Person(String name, String gender)
    {
        this.name=name;
        this.gender=gender;
    }

    public void newPerson()
    {
        running = true;
        timer = new Timer(100,  this);
        timer.start();

        running = true;
        x = random.nextInt(SCREEN_WIDTH/UNIT_SIZE) * UNIT_SIZE;
        y = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }

    public void checkCollisons()
    {
        /**
         * Metoda checkCollisons(), która kontroluje poruszanie się obiektów po planszy
         * Jeśli koordynaty x,y wyjdą poza okno, to zmienia aktualne koordynaty obiektu na te w oknie
         */

        if (this.x <= 0) {
            this.x = UNIT_SIZE;
        }

        if (this.x >= SCREEN_HEIGHT) {
            this.x = SCREEN_WIDTH-UNIT_SIZE;
        }

        if (this.y <= 0) {
            this.y =UNIT_SIZE;
        }

        if (this.y >= SCREEN_HEIGHT) {
            this.y = SCREEN_WIDTH-UNIT_SIZE;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
