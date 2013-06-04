import java.util.*; 
import java.io.*;
/** @author henrihan <henrik.hansen@student.jus.uio.no>
 *  Dette programmet er obligatorisk oppgave nr 4 i INF1010. Dette programmet tar vare på kjoeretoey-objekter
 *  og personobjekter i sine respektive beholdere, som er implementasjoner av en selvskrevet
 * enkeltlistet beholder("SELLbeholder"). Alle oppgavene er satt sammen til et program
 * men klassene ligger i egne javafiler av hensyn til testing
 * foerste er det storste objektet i beholderene.
 * Dette programmet er skrevet for Gruppe 2 våren 2013.
 */

/**
 * Det eneste denne klassen gjoer er aa starte programmet, og kalle paa forskjellige metoder
 * i testklassen.
 */
class Oblig4 {
    public static void main(String[]args) {
	Testklasse t = new Testklasse();
	t.mekanikerListe();
	t.bilEierListe();
	t.personListe();
	t.eierSkap();
	t.reperasjoner();
	t.kjoeretoeyBeholder();
	t.repSjekk();
	t.lesData1();
	t.lesData2();
	t.repSjekk();
	t.test();
    }
}
