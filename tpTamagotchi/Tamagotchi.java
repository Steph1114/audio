package tpTamagotchi;

public class Tamagotchi {
	//attributs
	private String nomTama;
	private String dormir;
	private String jouer;
	private String manger;
	private int energie;
	private int poids;
	
	

	public String getNomTama() {
		return nomTama;
	}
	public void setNomTama(String n) {
		nomTama = n.toUpperCase();
	}
	
	
	public String getDormir() {
		return dormir;
	}
	public void setDormir(String dormir) {
		this.dormir = dormir;
	}
	
	
	public String getJouer() {
		return jouer;
	}
	public void setJouer(String jouer) {
		this.jouer = jouer;
	}
	
	
	public String getManger() {
		return manger;
	}
	public void setManger(String manger) {
		this.manger = manger;
	}
	
	
	public int getEnergie() {
		return energie;
	}
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	
	
	public Tamagotchi(String nomTama, String dormir, String jouer, String manger, int energie, int poids) {
		this.setNomTama(nomTama);
		this.setDormir(dormir);
		this.setJouer(jouer);
		this.setManger(manger);
		this.setEnergie(energie);
		this.setPoids(poids);
	}
	
	//Fait reference a : Il récupère de l’énergie à chaque fois qu'il dort
	public Tamagotchi(int energie, String dormir) {
		this.setEnergie(energie);
		this.setDormir(dormir);
	}
	
	//Fait reference a : il prend du poids à chaque fois qu'il mange
		public Tamagotchi(String nomTama, int poids, int energie) {
			this.setNomTama(nomTama);
			this.setPoids(poids);
			this.setEnergie(energie);
		}
	
	
	//Fait reference a : Le Tamagotchi a 10 d'énergie, il en perd à chaque activité(dormir, jouer, manger)
	public Tamagotchi(int energie, String dormir, String jouer, String manger) {
		this.setEnergie(energie);
		this.setDormir(dormir);
		this.setJouer(jouer);
		this.setManger(manger);
	}
	
	
}
