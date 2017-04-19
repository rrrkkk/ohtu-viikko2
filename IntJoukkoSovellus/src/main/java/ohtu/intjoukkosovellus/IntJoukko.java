
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioidenLkm on nolla. 

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        tarkastaKapasiteetti(kapasiteetti);
        if (kasvatuskoko <= 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla <= 0");
        }
        alkiot = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (! kuuluu(luku)) {
            lisaaKasvattaenJosTarpeen(luku);
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        return loytyyPaikasta(luku)!=-1;
    }


    private int loytyyPaikasta(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return i;
            }
        }
        return -1;
    }    
    
    public boolean poista(int luku) {        
        if (kuuluu(luku)) {
            poistaKuuluva(luku);
            return true;
        }
        return false;
    }
 
    private void poistaKuuluva(int luku) {
        int paikka = loytyyPaikasta(luku);
        alkioidenLkm --;
        for (int i = paikka; i < alkioidenLkm; i ++) {
            alkiot[i] = alkiot[i + 1];
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + alkiot[0] + "}";
        } else {
            return toStringMonta();
        }
    }

    private String toStringMonta() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += alkiot[i] + ", ";
        }
        tuotos += alkiot[alkioidenLkm - 1] + "}";
        return tuotos;
    }
        
   public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = alkiot[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        x.lisaaJoukko(a);
        x.lisaaJoukko(b);
        return x;
    }

    private void lisaaJoukko(IntJoukko j) {
        int[] jTaulu = j.toIntArray();
        for (int i = 0; i < jTaulu.length; i++) {
            lisaa(jTaulu[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i]))
                y.lisaa(aTaulu[i]);
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        z.lisaaJoukko(a);
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
        return z;
    }

    private void tarkastaKapasiteetti(int kapasiteetti) {
	if (kapasiteetti <= 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla <= 0"); 
        }
    }

    private void lisaaKasvattaenJosTarpeen(int luku) {
	if (alkioidenLkm >= alkiot.length) {
	    int[] uudetAlkiot = new int[alkiot.length + kasvatuskoko];
	    kopioiTaulukko(alkiot, uudetAlkiot);
	    alkiot = uudetAlkiot;
	}
	alkiot[alkioidenLkm] = luku;
	alkioidenLkm ++;
    }

}
