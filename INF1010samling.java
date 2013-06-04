public interface INF1010samling<N extends Comparable<N>, V> extends Iterable<V> {
    /**
     * Legger inn et objekt/element i beholderen
     * @param  n  nokkelen som er knyttet til objektet v
     * @param  v  peker til objektet som skal inn i beholderen
     */
    public void leggInn(N n, V v);
    
    /**
     * Returnerer antall objekter i beholderen.
     * @return antall objekter i beholderen
     */ 
    public int antall();
    
    /**
     * Henter objektet knyttet til nokkelen.
     * @param  n  nokkelen 
     * @return objektet assosiert med nokkel n
     */
    public V hent(N n);
    
    /**
     * Henter et objekt med et spesifikt nummer.
     * Forutsetter at objektene er ordnet i en rekkefolge i beholderen
     * @param  nr  nummeret til objektet som skal returneres
     * @return objekt nummer nr dersom nr er storre enn 0 og
     *         mindre enn antall(), ellers null
     */
    public V hent(int nr);
    
    /**
     * Hent objektet med den minste nokkelen i beholderen.
     * @return objektet med den minste nokkelen
     */
    public V hentMinste();
    
    /**
     * Hent objektet med den storste nokkelen i beholderen.
     * @return objektet med den storste nokkelen
     */
    public V hentStorste();
    
    /**
     * Returnerer sant dersom beholderen inneholder et objekt
     * knyttet til nokkelen n.
     * @param  n  nokkelen som identifiserer objektet
     * @return true hvis det finnes et objekt med nokkel nkl i
     *         beholderen slik at nkl.compareTo(n) == 0
     */
    public boolean inneholder(N n);
    
    /**
     * Fjerner objektet knyttet til nokkelen n dersom det finnes.
     * @param  n  en nokkel som identifiserer objektet som skal
     *            fjernes 
     * @return true hvis elementet fjernes
     */
    public boolean fjernElement(N n);
    
    /**
     * Fjerner alle objektene lagret i beholderen.
     */
    public void fjernAlle();
    
    /**
     * Fyller en array med alle objektene i beholderen,
     * i samme rekkefolge som de ligger i beholderen
     * @param  a  peker til en array av typen V
     * @return en array med objektene i samme rekkefolge
     */
    public V[] tilArray(V[] a);
}
