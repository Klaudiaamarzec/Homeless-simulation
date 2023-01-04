//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * GamePanel to klasa, która tworzy całą symulację- zawiera parametry planszy, odpowiada za poruszanie się obiektów
 * oraz zachodzące między nimi interakcje
 */

public class GamePanel<a> extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 900;
    static final int UNIT_SIZE = 60; //45 było
    static final int GAME_UNITS = 18000; //18000
    static final int DELAY = 300;
    int krok=0;
    double hajs=0;
    double money=0;
    int a;

    ArrayList<Tin> tin = new ArrayList<>();
    ArrayList<Homeless> homeless = new ArrayList<>();
    ArrayList<Citizen> citizen = new ArrayList<>();
    ArrayList<Policeman> policeman = new ArrayList<>();
    ArrayList<Beer> beer = new ArrayList<>();

    Homeless hom1 = new Homeless("Zenon", "man");
    Homeless hom2 = new Homeless("Igor", "man");
    Tin tin1 = new Tin(0.05);
    Tin tin2 = new Tin(0.02);
    Tin tin3 = new Tin(0.03);
    Tin tin4 = new Tin(0.04);
    Tin tin5 = new Tin(0.02);
    Tin tin6 = new Tin(0.07);
    Tin tin7 = new Tin(0.11);
    Tin tin8 = new Tin(0.14);
    Tin tin9 = new Tin(0.51);
    Tin tin10 = new Tin(1.32);
    Policeman pol1 = new Policeman("Mariusz", "man");
    Policeman pol2 = new Policeman("Jan", "man");
    Citizen cit1 = new Citizen("Iwona", "woman", 15);
    Citizen cit2 = new Citizen("Leszek", "man", 33);
    Citizen cit3 = new Citizen("Krystyna", "woman", 8);
    Beer beer1 = new Beer(3);
    Beer beer2 = new Beer(1.32);
    Beer beer3 = new Beer(1.32);
    Beer beer4 = new Beer(1.32);
    Beer beer5 = new Beer(1.32);
    Beer beer6 = new Beer(1.32);
    Beer beer7 = new Beer(1.32);
    Beer beer8 = new Beer(1.32);
    Beer beer9 = new Beer(1.32);
    Beer beer10 = new Beer(1.32);
    Beer beer11 = new Beer(1.32);
    Beer beer12 = new Beer(1.32);

    Random random = new Random();
    Timer timer;
    boolean running = false;

    GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.startGame();
    }

    public void startGame() {

        /**
         *Metoda startGame() dodaje utworzone obiekty do listy, a następnie za pomocą pętli wywołuje
         *konstruktor newPerson() w celu utworzenia nowych obiektów na planszy
         */

        tin.add(tin1);
        tin.add(tin2);
        tin.add(tin3);
        tin.add(tin4);
        tin.add(tin5);
        tin.add(tin6);
        tin.add(tin7);
        tin.add(tin8);
        tin.add(tin9);
        tin.add(tin10);
        homeless.add(hom1);
        homeless.add(hom2);
        citizen.add(cit1);
        citizen.add(cit2);
        citizen.add(cit3);
        policeman.add(pol1);
        policeman.add(pol2);
        beer.add(beer1);
        beer.add(beer2);
        beer.add(beer3);
        beer.add(beer4);
        beer.add(beer5);
        beer.add(beer6);
        beer.add(beer7);
        beer.add(beer8);
        beer.add(beer9);
        beer.add(beer10);
        beer.add(beer11);
        beer.add(beer12);

        for(Homeless i : homeless)
        {
            i.newPerson();
        }

        for(Citizen i : citizen)
        {
            i.newPerson();
        }

        for(Policeman i : policeman)
        {
            i.newPerson();
        }

        for(Tin i : tin)
        {
            i.newThings();
        }

        this.running = true;
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    public void paintComponent(Graphics p) {
        super.paintComponent(p);
        this.draw(p);
    }
    public void checkCollisons() {

        /**
         *Metoda checkCollisons() wywołuje dla każdego obiektu na planszy metodę
         *z klasy Person- checkCollisons() i sprawdza ich położenie
         */

        for(Homeless i :  homeless)
        {
            i.checkCollisons();
        }

        for(Citizen i :  citizen)
        {
            i.checkCollisons();
        }

        for(Policeman i :  policeman)
        {
            i.checkCollisons();
        }
    }

    public void draw(Graphics p){
        if (this.running) {

            /**
             *Metoda draw(Graphics p) służy do rysowania poszczególnych elementów na planszy takich jak:
             */

            for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; ++i) {
                p.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                p.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }

            /**
             *Rysowanie utworzonych obiektów
             */

            for(Homeless i : homeless)
            {
                i.draw(p);
            }

            for(Citizen i : citizen)
            {
                i.draw(p);
            }

            for(Policeman i : policeman)
            {
                i.draw(p);
            }

            for(Tin i : tin)
            {
                i.draw(p);
            }

            /**
             *Rysowanie napisów na górze planszy- dla obu bezdomnych odpowiednio: ilość uzbieranych pieniędzy,
             *puszek, zakupione piwa oraz numer kroku symulacji
             */

            p.setFont(new Font("Ink Free", 11, 20));
            FontMetrics metrics = this.getFontMetrics(p.getFont());
            krok++;
            p.setColor(Color.lightGray);
            int y=20;

            p.drawString("Hom1" ,(100 - metrics.stringWidth("Score: ")) / 2,y);
            p.drawString("Hom2 " + hajs,(100 - metrics.stringWidth("Score: ")) / 2,y+25);

            for(Homeless i : homeless)
            {

                p.drawString("Krok: "+krok ,(850 - metrics.stringWidth("krok")), y);
                p.drawString("Puszki: " + i.uzbierane_puszki, (900) / 2,y);
                p.drawString("Pieniądze: " + (i.money=Math.round(i.money*100.0)/100.0) + "zł", (300) / 2, y);
                p.drawString("Piwa: " + (i.beer), (1300 - metrics.stringWidth("Score: ")) / 2, y);
                y=y+25;
                if(krok==200){
                    try {
                        FileWriter plik = new FileWriter("plik.txt", true);
                        int k=1;
                            plik.write(homeless.indexOf(i) + " Piwa " + i.beer + " Pieniadze " + i.money + " Uzbierane puszki " + i.uzbierane_puszki + "\r\n");
                            plik.close();
                            running = false;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                }
            }
        }



    public void check() {

        /**
         *Metoda check() zawiera w sobie funkcje, które sprawdzają, jakie interakcje zachodzą
         *między poszczególnymi obiektami na planszy w momencie spotkania w tym samym miejscu (te same współrzędne), bądź
         *po spełnieniu pewnego warunku (wartość pieniędzy >=10 )
         */

        /**
         *Gdy bezdomny znajdzie puszkę:
         *Licznik puszek zwiększa się o 1
         *Licznik pieniędzy zwiększa sie o wartość danej puszki
         */

        for(Homeless i : homeless)
        {
            for(Tin j : tin)
            {
                if(i.x == j.x && i.y == j.y)
                {
                    i.uzbierane_puszki++;
                    i.money=i.money+j.money;
                    i.money=Math.round(i.money*100.0)/100.0;
                    j.newThings();
                }
            }
        }

        /**
         *Spotkanie bezdomnego z policjantem:
         *Policjant zabiera bezdomnemu piwo, jeśli jakiekolwiek posiada
         */

        for(Homeless i : homeless)
        {
            for(Policeman j : policeman)
            {
                if(i.x==j.x && i.y==j.y && i.beer>0)
                {
                    i.beer--;
                }
            }
        }

        /**
         *Spotkanie cywila z bezdomnym:
         *Prośba o drobne, wywołanie metody giveMoney() w celu wylosowania odpowiedniej kwoty
         */

        for(Homeless i: homeless)
        {
            for(Citizen j: citizen)
            {
                if(i.x==j.x && i.y==j.y)
                {
                    i.money=i.money+j.giveMoney();
                    i.money=Math.round(i.money*100.0)/100.0;
                }
            }
        }

        /**
         * Po uzbieraniu pewnej kwoty (10zł) bezdomny może kupić sobie piwo
         */

        for(Homeless i : homeless)
        {
            if(i.money>=10)
            {
                i.beer++;

                /**
                 *Losowanie piwa, które bezdomny kupi z listy
                 */

                Random rand = new Random();
                int number = rand.nextInt()*12;

                i.money=beer.get(number).money;
            }
        }

    }


    public void actionPerformed(ActionEvent e) {
        if (this.running) {
            this.move();
            this.check();
            this.checkCollisons();
        }

        this.repaint();
    }

    public void move() {

        for(Homeless i :  homeless)
        {
            i.move();
        }

        for(Citizen i :  citizen)
        {
            i.move();
        }

        for(Policeman i : policeman)
        {
            i.move();
        }
    }
}