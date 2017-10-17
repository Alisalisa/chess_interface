import javax.swing.*;
import java.util.*;

/**
 * Created by Alisa on 4/4/2017.
 */
public class Rege extends Piesa {

    protected static ImageIcon whiteImg;
    protected static ImageIcon blackImg;

    static {
        whiteImg = new ImageIcon("regealb.png");
        blackImg = new ImageIcon("regenegru.png");
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


    public Rege(ChessColor c, Camp camp) {
        super(c, camp);
    }

    public List<Camp> getToatePosibilitatiMutare(Camp initial){
        List<Camp> posibilitati = new ArrayList<Camp>();
        Coloane col = initial.getColoana();
        Linii lin = initial.getLinia();
        Camp current;

        current = new Camp(lin, col);
        if (current.getLinia().back() != null) {
            Camp urmator = new Camp(current.getLinia().back(), current.getColoana());
            posibilitati.add(urmator);
        }

        current = new Camp(lin, col);
        if (initial.getLinia().next() != null) {
            Camp urmator = new Camp(current.getLinia().next(), current.getColoana());
            posibilitati.add(urmator);
        }

        current = new Camp(lin, col);
        if (initial.getColoana().back() != null) {
            Camp urmator = new Camp(current.getLinia(), current.getColoana().back());
            posibilitati.add(urmator);
        }

        current = new Camp(lin, col);
        if (initial.getColoana().next() != null) {
            Camp urmator = new Camp(current.getLinia(), current.getColoana().next());
            posibilitati.add(urmator);
        }

        current = new Camp(lin, col);
        if (initial.getColoana().next() != null && initial.getLinia().next() != null) {
            Camp urmator = new Camp(current.getLinia().next(), current.getColoana().next());
            posibilitati.add(urmator);
        }

        current = new Camp(lin, col);
        if (initial.getColoana().back() != null && initial.getLinia().back() != null) {
            Camp urmator = new Camp(current.getLinia().back(), current.getColoana().back());
            posibilitati.add(urmator);
        }

        current = new Camp(lin, col);
        if (initial.getColoana().next() != null && initial.getLinia().back() != null) {
            Camp urmator = new Camp(current.getLinia().back(), current.getColoana().next());
            posibilitati.add(urmator);
        }

        current = new Camp(lin, col);
        if (initial.getColoana().back() != null && initial.getLinia().next() != null) {
            Camp urmator = new Camp(current.getLinia().next(), current.getColoana().back());
            posibilitati.add(urmator);
        }

        return posibilitati;
    }
}
