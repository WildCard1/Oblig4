import java.util.*; 
import java.io.*;

/** Testklasse til Oblig4. Starter med aa opprette noen mekaniker-, bileier-, beholder-, og kjoeretoeyobjekter*/
public class Testklasse {
    private Mekaniker tore = new Mekaniker("Tore", "Tore");
    private Mekaniker espen = new Mekaniker("Espen", "Espen");
    private Mekaniker henrik = new Mekaniker("Henrik", "Henrik");
    private Mekaniker truls = new Mekaniker("Truls", "Truls");
    private BilEier pia = new BilEier("Pia", "Pia");
    private BilEier preben = new BilEier("Preben", "Preben");
    private BilEier jonas = new BilEier("Jonas", "Jonas");
    private SELLbeholder<String, Person> bilEiere = new SELLbeholder<String, Person>();
    private SELLbeholder<String, Mekaniker> mekanikere = new SELLbeholder<String, Mekaniker>(); 
    private SELLbeholder<String, Person> allePersonene = new SELLbeholder<String, Person>();
    private SELLbeholder<String, Kjoeretoey> alleKjoeretoey = new SELLbeholder<String, Kjoeretoey>();
    private PersonBil ferrariEnzo = new PersonBil("RH51204", 3000000, mekanikere);
    private PersonBil toyotaCarina = new PersonBil("RH91232", 30000, mekanikere);
    private PersonBil miniCooper = new PersonBil("RH71438", 100000, mekanikere);
    private Buss volvo9700 = new Buss("RJ12512", 500000, mekanikere);
    private Buss volvo8700 = new Buss("RJ91241", 750000, mekanikere);
    private Lastebil scaniaP380 = new Lastebil("RJ12542", 800000, mekanikere);
    private Lastebil scaniaR580 = new Lastebil("RK95124", 350000, mekanikere);

    /** Legger inn mekanikerne i liste over mekanikere*/    
    public void mekanikerListe() {	
     	mekanikere.leggInn("Tore", tore);
	mekanikere.leggInn("Espen", espen);
	mekanikere.leggInn("Henrik", henrik);
	mekanikere.leggInn("Truls", truls);
    }

    /** Legger inn bileiere i egen liste*/
    public void bilEierListe() {
  	bilEiere.leggInn("Pia", pia); 
  	bilEiere.leggInn("Preben", preben);
  	bilEiere.leggInn("Jonas", jonas);
  	bilEiere.leggInn("Tore", tore);
  	bilEiere.leggInn("Espen", espen);
  	bilEiere.leggInn("Henrik", henrik);
  	/**Truls eier ikke bil*/
    }

    /** Legger inn alle personene i en liste*/    
    public void personListe() {	     
     	allePersonene.leggInn("Pia", pia);
     	allePersonene.leggInn("Jonas", jonas);
     	allePersonene.leggInn("Preben", preben);
  	allePersonene.leggInn("Tore", tore);
  	allePersonene.leggInn("Espen", espen);
  	allePersonene.leggInn("Henrik", henrik);
  	allePersonene.leggInn("Truls", truls);
    }

    /** Legger inn alle kjoeretoey i en beholder*/
    public void kjoeretoeyBeholder() {
     	alleKjoeretoey.leggInn("RH71438", miniCooper);
     	alleKjoeretoey.leggInn("RH91232", toyotaCarina);
     	alleKjoeretoey.leggInn("RH51204", ferrariEnzo);
     	alleKjoeretoey.leggInn("RJ12542", scaniaP380);
     	alleKjoeretoey.leggInn("RK95124", scaniaR580);
     	alleKjoeretoey.leggInn("RJ91241", volvo8700);
     	alleKjoeretoey.leggInn("RJ12512", volvo9700);
    }   

    /** Legger inn reperasjoner i kjoeretoeyenes egne beholdere*/
    public void reperasjoner() {
    	miniCooper.reperatoerer.leggInn("Tore", tore);
     	// Ev kan det skrives saann men jeg synes det ble litt tungvingt. Men det funker... : alleKjoeretoey.hent("RJ12512").reperatoerer.leggInn("Tore", tore);
     	miniCooper.reperatoerer.leggInn("Pia", pia);
     	miniCooper.reperatoerer.leggInn("Henrik", henrik);
     	toyotaCarina.reperatoerer.leggInn("Tore", tore);
     	toyotaCarina.reperatoerer.leggInn("Espen", espen);
     	toyotaCarina.reperatoerer.leggInn("Pia", pia);
     	toyotaCarina.reperatoerer.leggInn("Preben", preben);
     	toyotaCarina.reperatoerer.leggInn("Jonas", jonas);   
     	volvo8700.reperatoerer.leggInn("Espen", espen);
     	volvo8700.reperatoerer.leggInn("Pia", pia);
     	volvo8700.reperatoerer.leggInn("Henrik", henrik);
    }

    /** Sjekker om rep er gjennomfoert lovlig*/
    public void repSjekk() {
	for(Kjoeretoey k: alleKjoeretoey) { // itererer over alle kjoeretoey
	    if(!k.reperatoerer.isEmpty()) { // hvis det finnes reperatoerer paa bilen
		for(Person p: k.reperatoerer) { // itererer over alle reperatoerene paa kjoeretoeyet.
		    if(k.hentEier() != null) { // hvis bilen har eier
			if (p.hentNavn().equals(k.hentEier().hentNavn())) { // hvis det er samme eier som rep.
			    if(!mekanikere.inneholder(p.hentNr())) { // hvis eieren ikke er mekaniker
				    System.out.print("Da " + p.hentNavn() + " har reparert sin bil selv ");
				    System.out.println("vil bilen naa bli avskiltet");
				    k.settEier(null);
		     
			    }
			}
		    }	
		}		
	    }  
	}
    }

    /**Legger til kjoeretoeyenes eierskap*/
     public void eierSkap() {
     	pia.kjoeretoey.leggInn("RH71438", miniCooper);
     	miniCooper = new PersonBil("RH71438", 100000, mekanikere, pia); 
     	// Slik at objektet vet hvem som eier seg, slik at den kan gi feilmelding hvis eieren proever aa reparerer bilen.
     	jonas.kjoeretoey.leggInn("RH91232", toyotaCarina);
     	toyotaCarina = new PersonBil("RH91232", 30000, mekanikere, jonas);
     	henrik.kjoeretoey.leggInn("RH51204", ferrariEnzo);
     	ferrariEnzo = new PersonBil("RH51204", 3000000, mekanikere, henrik);
     	preben.kjoeretoey.leggInn("RJ12542", scaniaP380);
     	scaniaP380 = new Lastebil("RJ12542", 800000, mekanikere, preben);
     	tore.kjoeretoey.leggInn("RJ91241", volvo8700);
     	volvo8700 = new Buss("RJ91241", 750000, mekanikere, tore);
     	espen.kjoeretoey.leggInn("RJ12512", volvo9700);
     	volvo9700 = new Buss("RJ12512", 500000, mekanikere, espen);
     	
    }
	
    /** Leser data fra "nyeData" og legger det inn der det skal*/
    public void lesData1() {
		alleKjoeretoey.fjernAlle();
		try{
			File file = new File("nyeData");
			Scanner testdata = new Scanner(file);
			testdata.nextLine();
			int teller = testdata.nextInt();
			allePersonene.fjernAlle(); // Fjerner det som ble lakt inn tidligere i lista
			
			for(int i = 0; i <= teller; i++) {
				String navn = testdata.nextLine();
				Person p = new Person(navn, navn);
				allePersonene.leggInn(navn, p); // Legger inn personen i allePersonene
			}	
	    
			testdata.nextLine(); // Skippe over linja "MEKANIKERE"
			teller = testdata.nextInt(); // teller saa vi vet hvor lenge vi skal lese inn
			mekanikere.fjernAlle(); // Fjerner det som ble lakt inn tidligere i lista
	
			for(int i = 0; i <= teller; i++)  {
				String navn = testdata.nextLine();
				Mekaniker m = new Mekaniker(navn, navn);
				mekanikere.leggInn(navn, m); // legger inn i mekanikerlista
				if(!allePersonene.inneholder(navn))
				    allePersonene.leggInn(navn, m); // Legger inn i personlista
			}	
			testdata.nextLine();
			teller = testdata.nextInt();
			
			for(int i = 0; i < teller; i++) {
				String regNr = testdata.next();
				int verdi = testdata.nextInt();
				PersonBil pb = new PersonBil(regNr, verdi, mekanikere);
				alleKjoeretoey.leggInn(regNr, pb); //legger inn i alleKjoeretoeylista
			}	
	
			testdata.next();
			teller = testdata.nextInt();
				
			for(int i = 0; i < teller; i++) {
				String regNr = testdata.next();
				int verdi = testdata.nextInt();
				Lastebil l = new Lastebil(regNr, verdi, mekanikere);
				alleKjoeretoey.leggInn(regNr, l); // legger inn i alleKjoeretoey-lista
			}	
	
			testdata.next();
			teller = testdata.nextInt();
			
			for(int i = 0; i < teller && testdata.hasNext(); i++) {
				String regNr = testdata.next();
				int verdi = testdata.nextInt();
				Buss b = new Buss(regNr, verdi, mekanikere);
				alleKjoeretoey.leggInn(regNr, b); // legger inn i alleKjoeretoey-lista
			}
		}	
		catch(FileNotFoundException e) { //  Hvis filen ikke finnes.
			System.out.println("Denne filen finnes ikke. Vennligst bruk rett fil. Programmet avslutter");
			System.exit(0);
		}
		catch(NoSuchElementException e) { // Hvis du leser inn feil paa en eller annen maate.
			System.out.println("Elementet du proever aa lese inn fra filen er i feil. Feks proever du aa lese ");
			System.out.println("inn en 'String' naar neste element er en 'Integer'."); 
			System.out.println("Programmet ga feilmeldingen: " + "\"" + e.getMessage() + "\"");
			System.out.println("Bruk en fil med samme oppsett som oppgaven spesifiserer. Programmet avslutter");
			System.exit(0);
		}
    }
    
    void lesData2() { // les den andre datafilen, "eierOgRepData.txt"
		try {
			File file2 = new File("eierOgRepData");
			Scanner testdata2 = new Scanner(file2);
			
			testdata2.nextLine();
			int teller = testdata2.nextInt();
			
			for(int i = 0; i < teller; i++) {
				String regNr = testdata2.next();
				regNr = regNr.trim();
				String eier = testdata2.nextLine();
				eier = eier.trim();
				Kjoeretoey tmp = alleKjoeretoey.hent(regNr);
				Person p = allePersonene.hent(eier);
				if(p != null) {
					tmp.settEier(p);
					p.kjoeretoey.leggInn(regNr, tmp);
				}
			}
			
			testdata2.nextLine();
			teller =  testdata2.nextInt();
			
			for(int i = 0; i < teller; i++) {
				String regNr = testdata2.next();
				regNr = regNr.trim();
				String rep = testdata2.nextLine();
				rep = rep.trim();
				Kjoeretoey tmp = alleKjoeretoey.hent(regNr);
				Person p = allePersonene.hent(rep); // 
				if(p != null) { // Hvis personen faktisk finnes.
				    tmp.settRep(p); // sett inn reperatoer for bilen.
				    p.kjoeretoey.leggInn(regNr, tmp); // legg inn person for kjoeretoeyet.
				}
			}
			
		}
			
		catch(FileNotFoundException e) { 
			System.out.println("Denne filen finnes ikke. Vennligst bruk rett fil. Programmet avslutter");
			System.exit(0);
		}
		catch(NoSuchElementException e) {
			System.out.println("Elementet du proever aa lese inn fra filen er i feil. Feks proever du aa lese ");
			System.out.println("inn en 'String' naar neste element er en 'Integer'."); 
			System.out.println("Programmet ga feilmeldingen: " + "\"" + e.getMessage() + "\"");
			System.out.println("Bruk en fil med samme oppsett som oppgaven spesifiserer. Programmet avslutter");
			System.exit(0);
		}
	}
    void test() {
	System.out.println("\nTEST AV ALLE KJOERETOEY, JF KRAV OM AA TESTE BEHOLDEREN: \n");
	System.out.print("Stoerste i kjoeretoeybeholderen er: ");
	System.out.println(alleKjoeretoey.hentStorste());
	System.out.print("Minste i kjoeretoeybeholderen er: ");
	System.out.println(alleKjoeretoey.hentMinste());
	if(alleKjoeretoey.isEmpty())
	    System.out.println("Ops, noe gikk galt. Denne beholderen er visst tom");
	else 
	    System.out.println("Denne kjoeretoeybeholderen er ikke tom. Yey.");
	System.out.print("Indeks nummer 1 i beholderen er: ");
	System.out.println(alleKjoeretoey.hent(1));
	System.out.println("Dette skjer naar listen inneholder elementet: ");
	System.out.println(alleKjoeretoey.inneholder("HK17575"));
	System.out.println("Dette skjer naar listen IKKE inneholder elementet: ");
	System.out.println(alleKjoeretoey.inneholder("asdf"));
	for(Kjoeretoey k: alleKjoeretoey) {	    
	    k.beregnSkatt();
	    if(k.hentEier() != null)
		//System.out.println(k.hentEier());
		//Uncomment for aa skrive ut eierne(paa de bilene som har eiere)
	    if(k.mekanikere != null)
		//Uncomment for aa skrive ut den foerste mekanikeren(paa de bilene som har blitt rep.)
		//System.out.println(k.mekanikere.hent(1));
	    if(k.hentAvgift() != 0){
		//System.out.println(k.hentAvgift());
		//Uncomment hvis du vil skrive ut alle avgifter
	    }
	    for(Person p: allePersonene) {
		//System.out.println(p.hentNr());
		//Uncomment for aa skrive ut alle personene.
		//System.out.println(p.hentNavn());
		// I denne konteksten det samme som hentNr(); Uncomment for aa skrive ut.
		
	    }
	}	
    }
    /** Resten av metodene er testet ellers her i testprogrammet*/
}
