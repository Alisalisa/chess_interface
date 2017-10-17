import javax.swing.*;
import java.util.*;

/**
 * Created by Alisa on 3/31/2017.
 */
public class Pion extends Piesa {

    protected static ImageIcon whiteImg;
    protected static ImageIcon blackImg;
    static {
        whiteImg = new ImageIcon("pionalb.png");
        blackImg = new ImageIcon("pionnegru.png");
    }
    protected void setWhiteImageIcon(String s)
    {
        whiteImg = new ImageIcon(s);
    }
    protected ImageIcon getWhiteImageIcon()
    {
        return whiteImg;
    }

    protected ImageIcon getBlackImageIcon()
    {
        return blackImg;
    }
    protected void setBlackImageIcon(String s)
    {
        blackImg = new ImageIcon(s);
    }


    public Pion(ChessColor c, Camp camp) {
        super(c, camp);
    }

    public List<Camp> getToatePosibilitatiMutare(Camp initial) {
        List<Camp> posibilitati = new ArrayList<Camp>();
        Coloane col = initial.getColoana();
        Linii lin = initial.getLinia();
        Camp current;

        if (this.culoare == ChessColor.BLACK) {
            current = new Camp(lin, col);
            if (current.getLinia().next() != null) {
                Camp urmator = new Camp(current.getLinia().next(), current.getColoana());
                posibilitati.add(urmator);
                current = urmator;

                if (current.getLinia().next() != null) {
                    urmator = new Camp(current.getLinia().next(), current.getColoana());
                    posibilitati.add(urmator);
                }
            }
        }
        else if (this.culoare == ChessColor.WHITE) {
            current = new Camp(lin, col);
            if (current.getLinia().back() != null) {
                Camp urmator = new Camp(current.getLinia().back(), current.getColoana());
                posibilitati.add(urmator);
                current = urmator;

                if (current.getLinia().back() != null) {
                    urmator = new Camp(current.getLinia().back(), current.getColoana());
                    posibilitati.add(urmator);
                }
            }
        }
        return posibilitati;
    }
}