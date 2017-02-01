package MMC;

//Info-AG | David Ronschka

public class Koordinate
{
    private int X;
    private int Y;

    /**Speichert die Koordinaten mit X und Y gleich 0*/
    public Koordinate() 
    {
        this(0,0);
    }        
    /**Speichert die Koordinaten in einer "X" und "Y" Variable*/
    public Koordinate(int X, int Y) 
    {
        this.X = X;
        this.Y = Y;
    }
    /**Gibt die aktuelle X-Koordiante zurück*/
    public int gibXKoordinate() 
    {
        return X;
    }
    /**Gibt die aktuelle Y-Koordiante zurück*/
    public int gibYKoordinate() 
    {
        return Y;
    }
 
}