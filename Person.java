/** Dette er "superklassen" Person. Den implementerer PersonInterface, og beskriver en generell Person
 * @param navn Navnet til vedkommende
 * @param noekkel Identifikator til denne personen; oftest det samme som navnet, men ikke noedvendigvis
 * @param kjoeretoey Liste over kjoeretoey vedkommende eier
 */
public class Person implements PersonInterface {
    protected String navn;
    protected String noekkel;
    protected SELLbeholder<String, Kjoeretoey> kjoeretoey = new SELLbeholder<String, Kjoeretoey>();
    
    /** Returnerer identifikatoren til denne personen*/
    public String nr() {
	return noekkel;
    }

    /** Konstruktoer som legger inn navn og noekkel(identifikator) til vedkommende*/
    public Person(String navn, String noekkel) {
	this.navn = navn;
	this.noekkel = noekkel;
    }

    /** Returnerer noekkelen(identifikatoren)*/
    public String hentNr() {
    	return noekkel;	    
    }

    /** Returnerer navnet til vedkommende*/
    public String hentNavn() {
    	return navn;	    
    }

    /** Det som returneres naar personobjekter kalles paa(navnet)*/
    public String toString() {
	return hentNavn();
    }
}
