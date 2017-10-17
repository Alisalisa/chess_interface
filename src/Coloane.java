/**
 * Created by Alisa on 4/5/2017.
 */
public enum Coloane {
    COLOANA_A (1),
    COLOANA_B (2),
    COLOANA_C (3),
    COLOANA_D (4),
    COLOANA_E (5),
    COLOANA_F (6),
    COLOANA_G (7),
    COLOANA_H (8),
    COLOANA_I (9);

    private final int value;
    private Coloane(int value) {
        this.value = value;
    }
    public int value()
    {
        return value;
    }

    public Coloane next() {
        if (ordinal() + 1 <= 7)
            return values()[ordinal() + 1];
        else
            return null;
    }

    public Coloane back() {
        if (ordinal() - 1 >= 0) {
            return values()[ordinal() - 1];
        }
        else
            return null;
    }
}
