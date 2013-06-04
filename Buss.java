/** Klasse som beskriver busser*/
public class Buss extends Kjoeretoey {
    
    /** Konstruktoer til "Buss", som tar imot regNr og verdi, og sender dette videre til superklassen(Kjoeretoey)*/
    public Buss(String regNr, int verdi) {
	super(regNr, verdi);
    }
    
    /** Konstruktoer til "Buss", som tar imot regNr og verdi og liste over mekanikerene
     * Sender dette videre til konstruktoeren til superklassen(Kjoeretoey).
     * Denne konstruktoeren blir ikke noedvendigvis brukt da mekanikere kan settes ved metodekall.
     */
    public Buss(String regNr, int verdi, SELLbeholder mekanikere) {
	super(regNr, verdi, mekanikere);
    }
    
    /** Konstruktoer til "Buss" som tar imot regNr, verdi, mekanikerliste, og eieren til bussen.
     * Sender dette videre til superklassens konstruktoer(Kjoeretoey)
     * Denne konstruktoereren blir ikke noedvendigvis brukt da eier/mekanikere kan settes ved metodekall.
     */
    public Buss(String regNr, int verdi, SELLbeholder mekanikere, Person eier) {
	super(regNr, verdi, mekanikere, eier);
    }
}
