/**
 * Created by Alisa on 3/31/2017.
 */

import java.awt.Color;
import javax.swing.*;
import java.util.*;

public abstract class Piesa {

    protected ChessColor culoare;
    protected Camp camp;
    protected JLabel reprezentare = null;

    protected Piesa(ChessColor culoare, Camp camp)
    {
        this.culoare = culoare;
        this.camp = camp;
        setReprezentare();
    }

    public Coloane getColoana() {
        return camp.getColoana();
    }
    public Linii getLinia() {
        return camp.getLinia();
    }
    public void setColoana(Coloane coloana) {
        this.camp.setColoana(coloana);
    }
    public void setLinie(Linii linie) {
        this.camp.setLinia(linie);
    }
    public Camp getCamp() {
        return this.camp;
    }
    public void setCamp(Camp camp){
        this.camp = camp;
    }

    protected abstract void setWhiteImageIcon(String s);
    protected abstract ImageIcon getWhiteImageIcon();

    protected abstract ImageIcon getBlackImageIcon();
    protected abstract void setBlackImageIcon(String s);

    public ChessColor getCuloare(){
        return culoare;
    }
    public Color getPrintColor()
    {
        if (culoare == ChessColor.BLACK)
            return Color.BLACK;
        else
            return Color.WHITE;
    }

    protected void setReprezentare()
    {
        if (culoare == ChessColor.WHITE)
            reprezentare = new JLabel(getWhiteImageIcon());
        else
            reprezentare = new JLabel(getBlackImageIcon());
    }
    public JLabel getReprezentare() {
        return reprezentare;
    }

    public abstract List<Camp> getToatePosibilitatiMutare(Camp initial);
}
