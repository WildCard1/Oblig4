/** "Superklasse" kjoeretoey. Implementerer "kjoeretoeyInterface", og maa dermed inneholde metodene
 *  double beregnSkatt(); og String toString();
 * abstract da det ikke er lov aa lage objekter som bare er kjoeretoey.
 * @param regNr Registreringsnummeret til kjoeretoeyet.
 * @param verdi verdien/prisen paa kjoeretoeyet.
 * @param avgift avgiften til kjoeretoey, beregnet utifra verdien og hvem som har reparert kjoeretoey.
 * @param eier Naavarende eier til bilen
 * @param reparert Boolean som er true hvis bilen har vaert reparert.
 * @param reperatoerer Liste over alle reperatoerene bilen har hatt
 * @param mekanikere Liste over hvem som er mekanikere. Trengs for aa regne ut avgiften.
 * Merknader: Eier og rep kan settes baade med egen metode, eller som parameter til konstruktoeren, alt etter eget oenske
 */
@SuppressWarnings("unchecked")
    public abstract class Kjoeretoey implements kjoeretoeyInterface {
	protected String regNr;
	protected double verdi, avgift;
	protected Person eier;
	protected boolean reparert;  // Altsaa er den true hvis den ikke er reparert. 
	protected SELLbeholder<String, Person> reperatoerer = new SELLbeholder<String, Person>();
	SELLbeholder<String, Mekaniker> mekanikere;
	
	/** Konstruktoer som legger registreringsnummeret og verdien til kjoeretoey i variabler*/
	public Kjoeretoey(String regNr, int verdi) {
	    this.regNr = regNr;
	    this.verdi = verdi;
	}
	
	/** Konstruktoer som tar imot regNr, verdi og liste over mekanikere, for senere bruk*/
	public Kjoeretoey(String regNr, int verdi, SELLbeholder mekanikere) {
	    this.regNr = regNr;
	    this.verdi = verdi;
	    this.mekanikere = mekanikere;
	}
	
	/** Konstruktoer som tar imot regNr, verdi, liste over mekanikere og hvem som er eier.*/    
	public Kjoeretoey(String regNr, int verdi, SELLbeholder mekanikere, Person eier) {
	    this.regNr = regNr;
	    this.verdi = verdi;
	    this.mekanikere = mekanikere;
	    this.eier = eier;
	}
	
	/** Metode for aa hente registreringsnummeret til kjoeretoeyet*/
	public String hentRegnr() {
	    return regNr;	    
	}
	
	/** Metode for aa hente verdien til kjoeretoeyet*/
	public double hentVerdi() {
	    return verdi;	    
	}
	
	/**Metode som returnere avgiften til kjoeretoey*/
	public double hentAvgift() {
	    return avgift;
	}
	
	/**Metode for aa hente eieren til kjoeretoeyet*/    
	public Person hentEier() {
	    if(eier != null)
		return eier;
	    else {
		//System.out.println("Dette kjoeretoeyet har ingen eier. Metoden returnerer null");
		//Uncomment for feilmelding paa alle som ikke har eier.
		return null;
	    }	
	}
	
	/**Metode for aa sette ny eier til kjoeretoeyet(kan ogsaa gjoeres ved konstruktoerkall)*/
	public void settEier(Person eier) {
	    this.eier = eier;
	}
	
	/**Metode for aa tilfoere en reperasjon til bilen. Legger det inn i rep-lista*/
	public void settRep(Person p) {
	    reperatoerer.leggInn(p.hentNavn(), p);
	}
	
	/** Kalles objektet paa, vil registreringsnummeret skrives ut.*/
	public String toString() {
    	    return " Reg.nr: " + hentRegnr();	    
	}
	
	/** Metode for aa beregne skatten til kjoeretoeyet. Denne brukes baade for busser og lastebiler.*/    
	public double beregnSkatt() {
	    boolean harMeks = (mekanikere != null);
	    reparert = !reperatoerer.isEmpty(); // Altsaa er den true hvis den er reparert                                  
	    if(reparert) {
		for(Person p: reperatoerer) {
		    if(harMeks) {
			if(!mekanikere.inneholder(p.hentNr())){ 
			    avgift = Math.ceil(verdi *  0.12); // Staten er slu og regner oppover...
			} else
			    avgift =Math.ceil(verdi * 0.034); 
		    }
		}
	    }else {
		avgift = Math.ceil(verdi * 0.034);
	    }
	    return avgift;
	}
    }
