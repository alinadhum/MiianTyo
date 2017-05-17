package modelli;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Miia Laurila
 * @version 2.2.2017
 * 
 * Luokka lis�koulutuksien muodostamiseksi.
 **/
public class Lisakoulutus {
	
	private SimpleStringProperty koulutus;
	private SimpleStringProperty suoritusPvm;
	private SimpleStringProperty voimassaolo;
	private int id;
	private int monesko;
	
	private static int tamanId = 1;
	
	
	/**
	 * Konstruktori
	 */
	public Lisakoulutus() {
		// Ei tarvitse alustaa.
	}
	
	
	/**
	 * Asetetaan id tietyksi.
	 * @param i asetettava id
	 * @return id
	 */
	public int setId(int i){
		monesko = i;
		tamanId = i;
		tamanId++;
		return monesko;
	}
	
	
	/**
	 * Asetetaan id.
	 * @return id
	 */
	public int setId(){
		monesko = tamanId;
		tamanId++;
		return monesko;
	}
	
	/**
	 * Saadaan id
	 * @return id
	 */
	public int getId(){
		return monesko;
	}
	
	/**
	 * Asetetaan lis�koulutukselle ty�ntekij�n id.
	 * @param i ty�ntekij�n id.
	 * @return ty�ntekij�n id.
	 */
	public int setTyontekijanId(int i) {
		id = i;
		return id;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n id
	 * @return id ty�ntekij�n id, jonka lis�koulutus k�sitelt�v� lis�koulutus on.
	 */
	public int getTyontekijanId(){
		return id;
	}
	
	/**
	 * Saadaan koulutus
	 * @return koulutus lis�koulutus
	 */
	public StringProperty getKoulutus() {
        return koulutus;
    }

	
	/**
	 * Asetetaan koulutus.
	 * @param koulutusStr lis�koulutus
	 */
    public void setKoulutus(String koulutusStr) {
        SimpleStringProperty lisakoulutus = new SimpleStringProperty(koulutusStr);
        this.koulutus = lisakoulutus;
    }
    
    
    /**
     * Saadaan lis�koulutuksen suoritusp�iv�m��r�.
     * @return suoritusPvm suoritusp�iv�m��r�
     */
    public StringProperty getSuoritusPvm() {
        return suoritusPvm;
    }

    
    /**
     * Asetetaan lis�koulutuksen suoritusp�iv�m��r�
     * @param suoritusPvm suoritusp�iv�m��r�
     */
    public void setSuoritusPvm(String suoritusPvm) {
        SimpleStringProperty suoritus = new SimpleStringProperty(suoritusPvm);
        this.suoritusPvm = suoritus;
    }


    /**
     * Saadaan lis�koulutuksen voimassaolop�iv�m��r�
     * @return voimassaolo voimassaolop�iv�m��r�
     */
    public StringProperty getVoimassaolo() {
        return voimassaolo;
    }

    
    /**
     * Asetetaan lis�koulutuksen voimassaolop�iv�m��r�
     * @param voimassaolo voimassaolop�iv�m��r�
     */
    public void setVoimassaolo(String voimassaolo) {
        SimpleStringProperty voimassa = new SimpleStringProperty(voimassaolo);
        this.voimassaolo = voimassa;
    }


	/**
	 * Muodostetaan lis�koulutus tiedoston rivist�.
	 * @param rivi josta lis�koulutus poimitaan.
	 */
	public void poimiLisakoulutus(String rivi) {
		String[] splitattu = rivi.split("[|]");
		this.setKoulutus(splitattu[2]);
		this.setSuoritusPvm(splitattu[3]);
		this.setVoimassaolo(splitattu[4]);
		this.setId(Integer.parseInt(splitattu[0]));
		this.setTyontekijanId(Integer.parseInt(splitattu[1]));
	}


	/**
	 * @return koulutuksen tiedot String -tyyppisen�.
	 */
	public String tulostuu() {
		String tulostus = this.getId()+"|"+this.getTyontekijanId()+"|"+this.getKoulutus().getValue()+"|"+this.getSuoritusPvm().getValue()+"|"+this.getVoimassaolo().getValue()+"|";
		return tulostus;
	}
}