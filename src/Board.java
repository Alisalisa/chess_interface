import javax.swing.*;
import java.awt.*;

/**
 * Created by Alisa on 3/31/2017.
 */
public class Board {

    private JLayeredPane layeredPane;
    private int dimensiuneLinie = 0;
    private int dimensiuneColoana = 0;
    protected JPanel b;
    private JPanel[][] square;
    protected Piesa[] pieseAlbe;
    protected Piesa[] pieseNegre;

    public JLayeredPane getLayeredPane()
    {
        return layeredPane;
    }

    public Camp getCampFromPosition(int x, int y)
    {
        // returneaza un camp de la o pozitie absoluta
        int x0 = b.getX();
        int y0 = b.getY();

        int difx = x - x0;
        int coloana = difx / dimensiuneColoana;
        int dify = y - y0;
        int linia = dify / dimensiuneLinie;

        Camp result = new Camp(Linii.values()[linia], Coloane.values()[coloana]);
        return result;
    }

    public JPanel getSquareFromCamp(Camp camp) {
        return square[camp.getLinia().value() -1][camp.getColoana().value() -1];
    }

    public Board(Dimension size, Afisare frame) {
        dimensiuneLinie = size.height / 8;
        dimensiuneColoana = size.width / 8;

        layeredPane = new JLayeredPane();
        frame.getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(size);
        layeredPane.addMouseListener(frame);
        layeredPane.addMouseMotionListener(frame);


        b = new JPanel();
        b.setLayout(new GridLayout(8, 8));
        b.setPreferredSize(size);
        b.setBounds(0, 0, size.width, size.height);
        square = new JPanel[8][8];
        createBoard();
        populateBoardPozitieInitiala();

        layeredPane.add(b, JLayeredPane.DEFAULT_LAYER);

    }

    private void createBoard() {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                square[i][j] = new JPanel();
                if ((i + j) % 2 == 0){
                    square[i][j].setBackground(Color.red);
                }
                else{
                    square[i][j].setBackground(Color.white);
                }
                b.add(square[i][j]);
            }
        }
    }

    private void populateBoardPozitieInitiala() {
        pieseAlbe = new Piesa[16];
        pieseAlbe[0] = new Turn(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_A));
        pieseAlbe[1] = new Cal(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_B));
        pieseAlbe[2] = new Nebun(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_C));
        pieseAlbe[3] = new Regina(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_D));
        pieseAlbe[4] = new Rege(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_E));
        pieseAlbe[5] = new Nebun(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_F));
        pieseAlbe[6] = new Cal(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_G));
        pieseAlbe[7] = new Turn(ChessColor.WHITE, new Camp(Linii.LINIA_1, Coloane.COLOANA_H));
        pieseAlbe[8] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_A));
        pieseAlbe[9] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_B));
        pieseAlbe[10] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_C));
        pieseAlbe[11] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_D));
        pieseAlbe[12] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_E));
        pieseAlbe[13] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_F));
        pieseAlbe[14] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_G));
        pieseAlbe[15] = new Pion(ChessColor.WHITE, new Camp(Linii.LINIA_2, Coloane.COLOANA_H));

        for (int i = 0; i < 16; i++){
            Camp camp = pieseAlbe[i].getCamp();
            JLabel reprezentare = pieseAlbe[i].getReprezentare();
            JPanel theSquare = getSquareFromCamp(camp);
            theSquare.add(reprezentare);
        }

        pieseNegre = new Piesa[16];
        pieseNegre[0] = new Turn(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_A));
        pieseNegre[1] = new Cal(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_B));
        pieseNegre[2] = new Nebun(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_C));
        pieseNegre[3] = new Rege(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_D));
        pieseNegre[4] = new Regina(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_E));
        pieseNegre[5] = new Nebun(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_F));
        pieseNegre[6] = new Cal(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_G));
        pieseNegre[7] = new Turn(ChessColor.BLACK, new Camp(Linii.LINIA_8, Coloane.COLOANA_H));
        pieseNegre[8] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_A));
        pieseNegre[9] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_B));
        pieseNegre[10] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_C));
        pieseNegre[11] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_D));
        pieseNegre[12] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_E));
        pieseNegre[13] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_F));
        pieseNegre[14] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_G));
        pieseNegre[15] = new Pion(ChessColor.BLACK, new Camp(Linii.LINIA_7, Coloane.COLOANA_H));

        for (int i = 0; i < 16; i++){
            getSquareFromCamp(pieseNegre[i].getCamp()).add(pieseNegre[i].getReprezentare());
        }
    }

    void refacereBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i + j) % 2 == 0){
                    square[i][j].setBackground(Color.red);
                }
                else {
                    square[i][j].setBackground(Color.white);
                }
            }
        }
    }
}
