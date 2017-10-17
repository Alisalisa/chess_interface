/**
 * Created by Alisa on 3/24/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Afisare extends JFrame implements MouseListener, MouseMotionListener {

    private Dimension size = new Dimension(600, 600);
    private JLayeredPane layeredPane;
    private Board board;
    private int xAdj;
    private int yAdj;
    private Piesa piesa;
    private JPanel square;
    private JLabel reprezentare;

    public Afisare(){
        board = new Board(size, this);
        layeredPane = board.getLayeredPane();
    }

    public void mousePressed(MouseEvent e) {

        // aici se citeste pozitia mouseului : getX si getY
        // trebuie convertita aceasta pozitie intr-un camp
        // apoi din tabla trebuie preluata piesa de pe campul respectiv
        // deci piesa trebuie sa fie un obiect de tipul Piesa
        // apoi putem genera campurile cu mutarile posibile

        Camp camp;
        java.util.List<Camp> mutariPosibile = new ArrayList<Camp>();
        JPanel[] mutari = new JPanel[2];
        int indexMutare = 0;
        Camp campVerificare;

        reprezentare = null;
        piesa = null;
        square = null;
        int x = e.getX();
        int y = e.getY();
        camp = board.getCampFromPosition(x, y);

        for (int i = 0; i < 16; i++) {
            campVerificare = board.pieseAlbe[i].getCamp();
            if (camp.getLinia() == campVerificare.getLinia() && camp.getColoana() == campVerificare.getColoana()){
                piesa = board.pieseAlbe[i];
                mutariPosibile = piesa.getToatePosibilitatiMutare(camp);
                for (Camp mutare : mutariPosibile){

                    mutari[indexMutare] = board.getSquareFromCamp(mutare);
                    mutari[indexMutare].setBackground(Color.blue);
                }
            }
        }

        for (int i = 0; i < 16; i++) {
            campVerificare = board.pieseNegre[i].getCamp();
            if (camp.getLinia() == campVerificare.getLinia() && camp.getColoana() == campVerificare.getColoana()){
                piesa = board.pieseNegre[i];
                mutariPosibile = piesa.getToatePosibilitatiMutare(camp);
                for (Camp mutare : mutariPosibile){
                    mutari[indexMutare] = board.getSquareFromCamp(mutare);
                    mutari[indexMutare].setBackground(Color.blue);
                }
            }
        }

        if (piesa instanceof Piesa) {
            camp = piesa.getCamp();
            square = board.getSquareFromCamp(camp);
            square.setBackground(Color.CYAN);
            reprezentare = piesa.getReprezentare();
            Point location = square.getLocation();
            xAdj = location.x - x;
            yAdj = location.y - y;
            reprezentare.setLocation(x + xAdj, y + yAdj);
            reprezentare.setSize(reprezentare.getWidth(), reprezentare.getHeight());
            layeredPane.add(reprezentare, JLayeredPane.DRAG_LAYER);
        }
    }

    public void mouseDragged(MouseEvent e){
        if (reprezentare == null)
            return;
        reprezentare.setLocation(e.getX() + xAdj, e.getY() + yAdj);
    }

    public void mouseReleased(MouseEvent e){
        Camp campVerificare;
        Camp camp;
        Piesa piesaIntalnita = null;
        JLabel reprezentareIntalnita;

        int x = e.getX();
        int y = e.getY();

        camp = board.getCampFromPosition(x, y);
        if (reprezentare == null)
            return;

        for (int i = 0; i < 16; i++) {
            campVerificare = board.pieseAlbe[i].getCamp();
            if (camp.getLinia() == campVerificare.getLinia() && camp.getColoana() == campVerificare.getColoana()){
                piesaIntalnita = board.pieseAlbe[i];
            }
        }
        for (int i = 0; i < 16; i++) {
            campVerificare = board.pieseNegre[i].getCamp();
            if (camp.getLinia() == campVerificare.getLinia() && camp.getColoana() == campVerificare.getColoana()){
                piesaIntalnita = board.pieseNegre[i];
            }
        }

        reprezentare.setVisible(false);

         if (piesaIntalnita != null){
                camp = piesaIntalnita.getCamp();
                reprezentareIntalnita = piesaIntalnita.getReprezentare();
                square = board.getSquareFromCamp(camp);

                Camp campFictiv = new Camp(Linii.LINIA_0, Coloane.COLOANA_I);
                piesaIntalnita.setCamp(campFictiv);
                square.remove(reprezentareIntalnita);
                square.revalidate();
                square.repaint();
                square.add(reprezentare);
        }
        else if (piesaIntalnita == null){
            square = board.getSquareFromCamp(camp);
            square.add(reprezentare);
        }
        reprezentare.setVisible(true);
        camp = board.getCampFromPosition(x, y);
        piesa.setCamp(camp);
        board.refacereBoard();
        square.setBackground(Color.DARK_GRAY);
    }

    public void mouseMoved(MouseEvent e){

    }

    public void mouseClicked(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public static void main(String[] args){
        JFrame afisare = new Afisare();
        afisare.setVisible(true);
        afisare.pack();
        afisare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
