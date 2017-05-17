package modelli;


/**
 * @author Miia Laurila
 * @version 6.4.2017
 *
 * Luokka ty�ntekij�n tietojen asettamiseksi.
 */	
public class Tyontekija {
 
	private int id;
	private String nimi;
	private String hetu;
	private String tyonimike;
	private String katuosoite;
	private int postinumero;
	private String postitoimipaikka;
	private String puhelinnumero;
	private Boolean tyosopimus;
	
	private static int tamanId = 1;
	
	/**
	 * Konstruktori
	 */
	public Tyontekija() {
	    // ei tarvitse alustaa
	}
	
	
	/**
	 * @return id ty�ntekij�n id.
	 * 
	 * Saadaan ty�ntekij�n id
	 */
	public int getId() {
		return id;
	}


	/**
	 * Asetetaan haluttu id
	 * @param i haluttu id
	 * @return id
	 */
	public int setId(int i){
		id = i;
		tamanId = i;
		tamanId++;
		return id;
	}

	
	/**
	 * Asetetaan ty�ntekij�lle id
	 * @return ty�ntekij�n id
	 */
	public int setId() {
		id = tamanId;
		tamanId++;
		return id;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n nimi
	 * @return nimi
	 */
	public String getNimi() {
		return nimi;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle nimi
	 * @param nimi ty�ntekij�n nimi
	 */
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n hetu
	 * @return hetu ty�ntekij�n hetu
	 */
	public String getHetu() {
		return hetu;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle hetu
	 * @param hetu ty�ntekij�n hetu
	 */
	public void setHetu(String hetu) {
		this.hetu = hetu;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n ty�nimike
	 * @return tyonimike ty�ntekij�n ty�nimike
	 */
	public String getTyonimike() {
		return tyonimike;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle ty�nimike
	 * @param tyonimike ty�ntekij�n nimike
	 */
	public void setTyonimike(String tyonimike) {
		this.tyonimike = tyonimike;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n katuosoite
	 * @return katuosoite ty�ntekij�n katuosoite
	 */
	public String getKatuosoite() {
		return katuosoite;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle katuosoite
	 * @param katuosoite ty�ntekij�n katuosoite
	 */
	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n postinumero
	 * @return postinumero ty�ntekij�n postinumero
	 */
	public int getPostinumero() {
		return postinumero;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle postinumero
	 * @param postinumero ty�ntekij�n postinumero
	 */
	public void setPostinumero(int postinumero) {
		this.postinumero = postinumero;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n postitoimipaikka.
	 * @return postitoimipaikka ty�ntekij�n postitoimipaikka
	 */
	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle postitoimipaikka
	 * @param postitoimipaikka ty�ntekij�n postitoimipaikka
	 */
	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n puhelinnumero
	 * @return puhelinnumero ty�ntekij� puhelinnumero
	 */
	public String getPuhelinnumero() {
		return puhelinnumero;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�lle puhelinnumero
	 * @param puhelinnumero ty�ntekij�n puhelinnumero
	 */
	public void setPuhelinnumero(String puhelinnumero) {
		this.puhelinnumero = puhelinnumero;
	}
	
	
	/**
	 * Saadaan ty�ntekij�n ty�sopimuksen voimassaolo (true/false)
	 * @return tyosopimus onko voimassa olevaa ty�sopimusta ty�ntekij�ll�
	 */
	public Boolean getTyosopimus() {
		return tyosopimus;
	}
	
	
	/**
	 * Asetetaan ty�ntekij�n ty�sompimus voimassa olevaksi (true) tai ei (false)
	 * @param tyosopimus onko voimassa olevaa ty�sopimusta ty�ntekij�ll�
	 */
	public void setTyosopimus(Boolean tyosopimus) {
		this.tyosopimus = tyosopimus;
	}


	/**
	 * Annetaan ty�ntekij�lle tiedot tiedostosta.
	 * @param rivi rivi, josta poimitaan ty�ntekij�n tiedot
	 */
	public void poimiTyontekijanTiedot(String rivi) {
		String[] splitattu = rivi.split("[|]");
		Boolean tyosopimuksenVoimassaolo = false;
		if(splitattu[8].equals("true")){
			tyosopimuksenVoimassaolo = true;
		}
		this.id = setId(Integer.parseInt(splitattu[0]));
		this.nimi = splitattu[1];
		this.hetu = splitattu[2];
		this.tyonimike = splitattu[3];
		this.katuosoite = splitattu[4];
		this.postinumero = Integer.parseInt(splitattu[5]);
		this.postitoimipaikka = splitattu[6];
		this.puhelinnumero = splitattu[7];
		this.tyosopimus = tyosopimuksenVoimassaolo;
	}


	/**
	 * Muodostetaan ty�ntekij�n tiedoista tulostettava rivi
	 * @return tulostettava rivi
	 */
	public String tulostuu() {
		String tulostus = this.id+"|"+this.nimi+"|"+this.hetu+"|"+this.tyonimike+"|"+this.katuosoite+"|"
				+this.postinumero+"|"+this.postitoimipaikka+"|"+this.puhelinnumero+"|"+this.tyosopimus+"|";
		return tulostus;
	}
}