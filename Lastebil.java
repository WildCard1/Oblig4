/** Lastebil-klasse som beskriver kjoeretoey som er lastebiler*/
public class Lastebil extends Kjoeretoey {
    
    /** Konstruktoer til lastebiler, som faar inn regnr og verdi som parametre*/
    public Lastebil(String regNr, int verdi) {
	super(regNr, verdi);
    }
    /** Konstruktoer som faar inn regnr, verdi og liste over mekanikere som parametre*/
    public Lastebil(String regNr, int verdi, SELLbeholder mekanikere) {
	super(regNr, verdi, mekanikere);
    }
    
    /** Konstruktoer som faar inn regNr, verdi, liste over mekanikere og eier som parametre*/
    public Lastebil(String regNr, int verdi, SELLbeholder mekanikere, Person eier) {
	super(regNr, verdi, mekanikere, eier);
    }
}
