package modelli;

import java.io.File;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Palvelutalo-luokka, joka huolehtii n�kym�ss� tapahtuvien muutosten siirtymisest� ty�ntekij�t ja
 * lis�koulutukset luokkiin.
 *
 * @author Miia Laurila
 * @version 6.6.2017
 */
public class Palvelutalo {
	
    private Lisakoulutukset lisakoulutukset = new Lisakoulutukset();

    private static Tyontekijat tyontekijat = new Tyontekijat(); 
    private static OikeellisuusTarkistus oikeellisuusTarkistus = new OikeellisuusTarkistus();
    
    
    /**
     * Palauttaa ty�ntekij�iden lukum��r�n rekisteriss�
     * @return ty�ntekij�iden m��r�n
     */
    public int getTyontekija() {
        return tyontekijat.getLkm();
    }
    
    
    /**
     * Palauttaa lis�koulutuksien kokonaism��r�n rekisteriss�.
     * @return lis�koulutuksien m��r�n
     */
    public int getLisakoulutus() {
    	return lisakoulutukset.getLkm();
    }
    
    
    /**
     * Lis�� uuden ty�ntekij�n ty�ntekij� taulukkoon ja sen lis�koulutukset lis�koulutus taulukkoon.
     * @param tyontekija lis�tt�v� ty�ntekij�
     * @param uudenLisakoulutukset lis�tt�v�t lis�koulutukset
     * @return ty�ntekij�n lis�koulutukset
     */
    public Lisakoulutus[] lisaa(Tyontekija tyontekija, Lisakoulutus[] uudenLisakoulutukset) {
    	Lisakoulutus lisakoulutusLista[] = lisakoulutukset.lisaa(uudenLisakoulutukset);
        tyontekijat.lisaa(tyontekija);
        return lisakoulutusLista;
    }


    /**
     * Palauttaa i:nnen ty�ntekij�n taulukosta.
     * @param i indeksi
     * @return i:nnen ty�ntekij�n
     */
    public Tyontekija annaTyontekija(int i) {
        return tyontekijat.anna(i);
    }
    
    
    /**
     * Palauttaa i:nnen lis�koulutuksen taulukosta.
     * @param i indeksi
     * @return i:nnen lis�koulutuksen.
     */
    public Lisakoulutus annaLisakoulutus(int i){
    	return lisakoulutukset.anna(i);
    }


    /**
     * Muokkaus-n�kym�ss� lis�ttyjen lis�koulutuksien lis��minen lis�koulutus taulukkoon
     * @param tyontekijanLisakoulutukset lis�koulutukset, jotka lis�t��n lis�koulutus taulukkoon.
     * @return lis�koulutukset, jotka on lis�tty lis�koulutus taulukkoon.
     */
	public Lisakoulutus[] lisaa(Lisakoulutus[] tyontekijanLisakoulutukset) {
		Lisakoulutus koulutusLista[] = lisakoulutukset.lisaa(tyontekijanLisakoulutukset);
        return koulutusLista;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle id.
	 * @param tyontekija ty�ntekij�, jolle id annetaan
	 */
	public void asetaTyontekijalleId(Tyontekija tyontekija){
		tyontekijat.laitaId(tyontekija);
	}
	
	
	/**
	 * Asetaan koulutuksille oma id ja ty�ntekij�n id.
	 * @param tyontekija ty�ntekij�, jonka lis�koulutuksia k�sitell��n
	 * @param tyontekijanLisakoulutukset ty�ntekij�n lis�koulutukset.
	 */
	public void asetaKoulutuksilleId(Tyontekija tyontekija, Lisakoulutus[] tyontekijanLisakoulutukset){
		lisakoulutukset.laitaId(tyontekija, tyontekijanLisakoulutukset);
	}
	
	
	/**
	 * Asetetaan k�ytett�v�t tiedostot
	 * @param rekisteri rekisterin nimi
	 * @param tyontekija ty�ntekij�it� k�sittelev� tiedosto
	 * @param lisakoulutus lis�koulutuksia k�sittelev� tiedosto
	 */
	public void setTiedosto(String rekisteri, String tyontekija, String lisakoulutus){ 
	    File dir = new File(rekisteri);
        dir.mkdirs();
        tyontekijat.setTiedostonPerusNimi(rekisteri+"/"+tyontekija);
        lisakoulutukset.setTiedostonPerusNimi(rekisteri+"/"+lisakoulutus);
    }
	
	
    /**
     * Luetaan tiedostoissa olevat ty�ntekij�t ja niiden lis�koulutukset
     * @param rekisteri rekisterin nimi
     * @param tyontekija ty�ntekij�it� k�sittelev� tiedosto
     * @param lisakoulutus lis�koulutuksia k�sittele�v tiedosto
     */
    public void lueTiedostosta(String rekisteri, String tyontekija, String lisakoulutus) {
        tyontekijat = new Tyontekijat();
        lisakoulutukset = new Lisakoulutukset();
        setTiedosto(rekisteri, tyontekija, lisakoulutus);
        tyontekijat.lueTiedostosta();
        lisakoulutukset.lueTiedostosta();
    }

    
	/**
	 * Lis�t��n tiedostoon ty�ntekij�t
	 */
	public void lisaaTiedostoon() {
		tyontekijat.lisaaMuokkauksetTiedostoon();
	}

	
	/**
	 * Lis�t��n tiedostoon lis�koulutukset.
	 */
	public void lisaaLisakoulutus() {
		lisakoulutukset.lisaaTiedostoon();
	}
	

	/**
	 * Poistetaan poistettavan ty�ntekij�n tiedot tiedostoista ja taulukoista.
	 * @param poistettava poistettavan ty�ntekij�n id.
	 */
	public void poista(int poistettava) {
		lisakoulutukset.poistaTiedostosta(poistettava);
		lisakoulutukset.poistaTaulukosta(poistettava);
		tyontekijat.poistaTiedostosta(poistettava);
		tyontekijat.poistaTaulukosta(poistettava);
	}

	
	/**
	 * Palautetaan ty�ntekij� id:n avulla
	 * @param id ty�ntekij�n id
	 * @return ty�ntekij�, jolla on haluttu id.
	 */
	public Tyontekija annaTyontekijaIdnAvulla(int id) {
		return tyontekijat.annaTyontekijaId(id);
	}

	
	/**
	 * Muokataan i:nnes lis�koulutus
	 * @param i indeksi
	 * @param lisakoulutus muokattu lis�koulutus
	 */
	public void muokkaaLisakoulutus(int i, Lisakoulutus lisakoulutus) {
		lisakoulutukset.muokkaaLisakoulutus(i, lisakoulutus);
	}

	
	/**
	 * Muokataan lis�koulutus, jolla on tietty id.
	 * @param id lis�koulutuksen id
	 * @param koulutus lis�koulutuksen nimi
	 * @param suoritus lis�koulutuksen suoritusp�iv�m��r�
	 * @param voimassa lis�koulutuksen voimassaolop�iv�m��r�
	 */
	public void muokkaaLisakoulutus(int id, String koulutus, String suoritus, String voimassa) {
		lisakoulutukset.muokkaaLisakoulutus(id, koulutus, suoritus, voimassa);
	}

	
	/**
	 * Tarkistetaan kenttien oikeellisuus
	 * @param nimi nimen tekstikentt�
	 * @param hetu hetun tekstikentt�
	 * @param tyonimike ty�nimikkeen tekstikentt�
	 * @param katuosoite katuosoitteen tekstikentt�
	 * @param postinumero postinumeron tekstikentt�
	 * @param postitoimipaikka postitoimipaikan tekstikentt�
	 * @param puhelinnumero puhelinnumeron tekstikentt�
	 * @param id ty�ntekij�n id
	 * @return jos ei ole virheit� true, jos on false
	 */
	public Boolean tarkistaKentat(TextField nimi, TextField hetu, TextField tyonimike, TextField katuosoite, TextField postinumero, TextField postitoimipaikka, TextField puhelinnumero, int id) {
		return oikeellisuusTarkistus.tarkistus(nimi, hetu, tyonimike, katuosoite, postinumero, postitoimipaikka, puhelinnumero, id);
	}


    /**
     * Tarkistetaan koulutuksen tiedot.
     * @param lisakoulutus koulutuksen nimi
     * @param suoritus suorituspvm
     * @param voimassa voimassapvm
     * @param plus onko painettu plus-napista
     * @return true, jos ei virheit�, false jos on.
     */
    public Boolean tarkistaLisakoulutus(ComboBox<String> lisakoulutus, TextField suoritus, TextField voimassa, Boolean plus) {
        return oikeellisuusTarkistus.tarkistaLisa(lisakoulutus, suoritus, voimassa, plus);
    }


    /**
     * Poistetaan yksitt�inen lis�koulutus taulukosta.
     * @param id lis�koulutuksen id
     */
    public void poistaLisakoulutus(int id) {
        lisakoulutukset.poistaKoulutusTiedostosta(id);
        lisakoulutukset.poistaKoulutusTaulukosta(id);
    }


    /**
     * Luodaan uusi rekisteri.
     * @param rekisteri rekisterin nimi
     * @param tyontekija tyontekijat.dat
     * @param lisakoulutus lisakoulutukset.dat
     */
    public void luoTiedosto(String rekisteri, String tyontekija, String lisakoulutus) {
        File dir = new File(rekisteri);
        dir.mkdirs();
        tyontekijat.luoTiedosto(rekisteri+"/"+tyontekija);
        lisakoulutukset.luoTiedosto(rekisteri+"/"+lisakoulutus);
        setTiedosto(rekisteri, tyontekija, lisakoulutus);
    }
}