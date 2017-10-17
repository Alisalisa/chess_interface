/**
 * Created by Alisa on 4/5/2017.
 */
public class Camp {
    private Coloane coloana;
    private Linii linia;

    public Camp(Linii linia, Coloane coloana)
    {
        this.coloana = coloana;
        this.linia = linia;
    }
    public Coloane getColoana()
    {
        return coloana;
    }
    public Linii getLinia()
    {
        return linia;
    }
    public void setColoana(Coloane coloana)
    {
        this.coloana = coloana;
    }
    public void setLinia(Linii linia)
    {
        this.linia = linia;
    }

}
