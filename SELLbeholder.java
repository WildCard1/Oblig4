import java.util.*; 
import java.io.*;
/** Dette er en beholder som er enkellenket. Foerste er det stoerste objektet
 * @param antall Antall objekter i beholderen.
 * @param foerste Det stoerste objektet i beholderen.
 */

public class SELLbeholder<N extends Comparable<N>, V> implements INF1010samling<N,V> { 
    private int antall = 0;
    private Node foerste;
    
    /** Node-/listeelementklasse. Dette er en nøstet klasse, da vi faar tilgang til SELLbeholders variable etc.
     * @param neste Peker paa neste element i lista
     * @param verdi Peker paa verdiobjektet, altsaa det noekkelen refererer til
     * @param noekkel Peker paa et noekkelobj; gjerne et String-objekt. 
     */
    class Node {
	private Node neste;
	private V verdi;
	private N noekkel;
    	
	/** Konstruktoer til node-klassen som legger verdiobjektet og noekkelobjektet i objektvariabler*/
	public Node(N noekkel, V verdi) { 
	    this.noekkel = noekkel;
	    this.verdi = verdi;
	}
    }
    
    /** Metode som returnerer et verdiobj som har en noekkel assosiert med 'n'*/
    public V hent(N n) { 
	Node node = foerste;
	while(node != null) {
	    if (node.noekkel.compareTo(n) == 0) // Hvis funnet.
		return node.verdi;
	    node = node.neste;
 	}
	return null; // Hvis ikke funnet
    }
    
    /** Metode for aa legge objekter inn i lista. Egen metode for sortering.
     * iLista er en boolean som er true hvis det finnes et obj i lista med noekkel tilsvarende 'n'
     */
    public void leggInn(N n, V v) {
	boolean iLista = inneholder(n);
	Node node = new Node(n,v); // Lager et nytt temporært nodeobjekt.
	if(!iLista) { 
	    antall++;
	    if (foerste == null) { // Spesialtilfelle hvis lista er tom.
		foerste = new Node(n, v);
	    }else{ // Hvis lista ikke er tom.
		node.noekkel = n;
		node.verdi = v;
		node.neste = foerste;
		foerste = node;
	    }
	}else { // Hvis det allerede finnes et obj i lista med noekkel tilsvarende 'n'.
	    //System.out.println("Denne personen er allerede i lista, og kan ikke legges til paa nytt!");
	    //Gidder ikke aa skrive ut alle duplikater fordi det ble saa mange, men fjern kommentaren over hvis du alikevel vil gjoere det.
	}
	sorter();
    }
    
    /** Metoden jeg har valgt for aa sortere lista. Kalles paa hver gang det legges inn et nytt obj i lista*/
    public void sorter() {
	/**@param denne peker paa objektet som det naa jobbes med*/
	Node denne = foerste;
	/**@param neste peker paa neste objekt i lista*/
	Node neste = denne.neste;
	/**@param forrige peker paa forrige objekt i lista*/
	Node forrige = null;
	/**@param byttet peker paa en boolean som sier noe om det faktisk ble gjort byttinger under sorteringen.
	 * den er altsaa false hvis denne.neste peker paa null(gikk igjennom lista uten "avbrytelser")*/
	boolean byttet = (denne.neste != null);
	while(byttet) {
	    byttet = false;
	    while(neste != null) { // Saa lenge det er mer obj igjen i lista.
		if(denne.noekkel.compareTo(neste.noekkel) < 0) {
		    if(denne == foerste) { // Spesialtilfelle hvis det er stoerste/foerste obj
			foerste = neste;
			Node tmp = neste.neste; // Temp variabel for aa kunne gjoere det rette forandringer.
			neste.neste = denne;
			denne.neste = tmp;
			denne = foerste;
		    }else { // Hvis det ikke er stoerste/foerste obj.
			forrige.neste = denne.neste;
			denne.neste = neste.neste;
			neste.neste = denne;
			denne = neste;
		    }	
		}
		forrige = denne;
		denne = denne.neste;
		neste = denne.neste;
	    }
	}			
    }
    
    /** Returnerer antall objekter i lista*/
    public int antall() {
	return antall;
    }
    
    /** Henter obj som er assosiert med noekkel ("nr") */
    public V hent(int nr) {
	/**@param n midlertidig nodeobjekt*/
	Node n = foerste;
	if(nr > antall) { // Invariant tilstandspaastand.
	    System.out.println("Du har valgt et nummer som er stoerre enn antall objekter i denne lista; velg et gyldig nummer!");
	    System.out.println("(Metoden returnerer naa null)");
	    return null;
	}
	if(nr < 1) { // Invariant tilstandspaastand.
	    System.out.println("Du har valgt et nummer som er mindre enn 0; velg et gyldig nummer!");
	    System.out.println("(Metoden returnerer naa null)");
	    return null;
	}
	for(int i = 1; i <= nr-1; i++) {
	    n = n.neste;
	}
	return n.verdi;
    }
    
    /** Metode for aa hente minste obj, basert paa compareTo()*/
    public V hentMinste() {
	/**@param n Midlertidig nodeelement-peker som trengs for aa gaa igjennom lista*/
	Node n = foerste;
	if(n == null) {
	    System.out.println("Du kan ikke hente minsteelement naar lista er tom!");
	    return null; 
	}
	while(n.neste != null)
	    n = n.neste;
	return n.verdi;
    }
    
    /** Metode for aa hente stoerste element i lista.*/ 
    public V hentStorste() {
	if (foerste == null) {
	    System.out.println("Du kan ikke hente stoerste element naar lista er tom!");
	    return null;
	}
	return foerste.verdi;
    }
    
    /** Metode for aa sjekke om lista allerede inneholder et obj assosiert med 'n'*/
    public boolean inneholder(N n) {
	/** @param node Et temporært nodeobj som trengs for aa gaa igjennom lista*/
	Node node = foerste;
	while(node != null) {
	    if (node.noekkel.compareTo(n) == 0) 
		return true;
	    node = node.neste;
	}
	return false;
    }
    
    /** Fjerner et obj fra lista, hvis det faktisk finnes i lista*/
    public boolean fjernElement(N n) {
	/** @param forrige Peker til forrige nodeobj*/
	Node forrige = null;
	/** @param denne Peker til naavarende nodeobj*/
	Node denne = foerste;
	while(denne != null) {
	    if(denne.noekkel.compareTo(n) == 0) {
		System.out.println(denne.verdi + " er naa fjernet fra listen");
		denne = denne.neste;
		if(forrige == null)
		    foerste = foerste.neste; 
		else 
		    forrige.neste = denne;
		antall--;
		return true;
	    }else {
		forrige = denne;
		denne = denne.neste;
	    }
	}
	System.out.println("Finner ingen elementer assosiert med noekkel " + n);
	return false;
    }
    
    /** Metode som fjerner alle elementene fra lista*/
    public void fjernAlle() {
	foerste = null;
	antall = 0;
    }
    
    /** Metode som returnerer sortert lista som array*/
    public V[] tilArray(V[] a) {
	Node n = foerste;
	for(int i = 0; i < antall; i++) {
	    a[i] = n.verdi;
	    n = n.neste;
	}
	return a;
    }
    
    /** Metode for aa skrive ut alle elementene i lista*/    
    public void skrivAlle() {
	Node n = foerste;
	while (n != null) {
	    System.out.println(n.verdi);
	    n = n.neste;
	}
    }

    /** Initaterer egendefinert iterator-klasse*/
    public Iterator<V> iterator() {
	return new nyKlasse1();
    }

    /** Egendefinert Iteratorklasse. Trengs for aa kunne "iterere" over lista. Implementerer Iterator<V>
     * @param harBlittKaltPaa boolean for aa saa om next har blitt kalt paa. Hvis ikke, er vi paa foerste.
     * @param denne Peker paa naavarende nodeobj
     * @param antall Antall ganger next har blitt kalt paa, og dermed sier hvor vi er i lista
     */
    class nyKlasse1 implements Iterator<V> {
	private boolean harBlittKaltPaa = false;
	private Node denne = foerste;
	private int antall1 = 0;

	/** Metode for aa se om det finnes mer obj i lista*/	
	public boolean hasNext() {
	    return denne.neste != null;	    
	}
	
	/** Metode for aa gaa til neste obj i lista*/
	public V next() {
	    if(denne.neste != null && hasNext()) // Slik at den kun oeker naar det finnes et nesteelement.
		// og lista har flere elementer.
		antall1++;
	    if(!harBlittKaltPaa) { // Hvis next() ikke har blitt kalt paa foer.
		harBlittKaltPaa = true;
		return foerste.verdi;
	    } else { // Hvis next() har blitt kalt paa foer.
		if (hasNext()) { // Hvis neste obj i lista ikke er null, altsaa der er mer igjen i lista*/
		    denne = denne.neste;
		    return denne.verdi;
		} else { // Hvis neste obj er null; vi er ved enden av lista*/
		    System.out.println("Listen er ved enden. Returnerer null.");
		}
	    }
	    return null;
	}
	
	/** Fjerner et element fra lista, ved hjelp av fjernElement(N n)*/
	public void remove() { 
	    Node n = foerste;
	    
	    for(int i = 1; i <= antall1-1; i++) {
		n = n.neste;
	    }
	    fjernElement(n.noekkel);
	}
    }

    /** Metode som returnerer null hvis lista er tom. Grei aa ha med for aa sjekke om lista er tom*/
    public boolean isEmpty() {
	return foerste == null;	
    }
}
