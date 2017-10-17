/**
 * Created by Alisa on 4/5/2017.
 */
public enum Linii {
    LINIA_8 (1),
    LINIA_7 (2),
    LINIA_6 (3),
    LINIA_5 (4),
    LINIA_4 (5),
    LINIA_3 (6),
    LINIA_2 (7),
    LINIA_1 (8),
    LINIA_0 (9);

    private final int value;
    private Linii(int value) {
        this.value = value;
    }
    public int value()
    {
        return value;
    }

    public Linii next() {
        if (ordinal() + 1 < 8){
            return values()[ordinal() + 1];}
        else
            return null;
    }

    public Linii back() {
        if (ordinal() - 1 >= 0) {
            return values()[ordinal() - 1];
        }
        else
            return null;
    }

}
