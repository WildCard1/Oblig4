/** Klasse som beskriver personbiler(som er kjoeretoey)*/
public class PersonBil extends Kjoeretoey {
    
/** Konstruktoer til personbiler. Faar inn regNr og verdi
 * og sender dette videre til superklassen(kjoeretoey) sin konstruktoer
 */
    public PersonBil(String regNr, int verdi) {
	super(regNr, verdi);
    }
    
    /** Konstruktoer til personbiler. Faar inn regN, verdi og en liste
     * over alle mekanikerene. Sender dette videre til superklassens konstruktoer*/
    public PersonBil(String regNr, int verdi, SELLbeholder mekanikere) {
	super(regNr, verdi, mekanikere);
    }
    
    /** Konstruktoer til personbiler. Faar inn regNr, verdi og en liste over alle mekanikere
     * samt en peker til hvem som er eieren av kjoeretoeyet.
     * Sender dette videre til superklassens passende konstruktoer
     */
    public PersonBil(String regNr, int verdi, SELLbeholder mekanikere, Person eier) {
	super(regNr, verdi, mekanikere, eier);
    }

    /** Metode for aa beregne skatten til bilen*/
    public double beregnSkatt() {	
	boolean harMeks = (mekanikere != null);
    	reparert = !reperatoerer.isEmpty(); // Altsaa er den true hvis den er reparert                                      
      	double antallMek = 0; // Antall mekanikere som har reparert bilen
	if(reparert) {
	    for(Person p: reperatoerer) {
		if(harMeks) {
		    if(mekanikere.inneholder(p.hentNr())) 
			antallMek++;
		}			
	    }
	    if ((antallMek / reperatoerer.antall()) > 0.5)
		avgift = Math.ceil(verdi * 0.075);
	    else
		avgift = Math.ceil(verdi * 0.1);
	}else {
	    avgift = Math.ceil(verdi * 0.05);
	}
	return avgift;
    }
}
