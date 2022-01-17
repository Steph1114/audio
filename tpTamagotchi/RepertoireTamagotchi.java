package tpTamagotchi;

import java.util.Scanner;

public class RepertoireTamagotchi {
	
	//affectation et initialisation de variable
	String nomTama = "";
	String dormir = "";
	String jouer = "";
	String manger = "";
	static int energie = 10; //Pour acceder energie donc static
	static int poids = 1;
	
	static Scanner saisir = new Scanner(System.in);
//	Tamagotchi nouveauTama = new Tamagotchi(nomTama, energie, manger);
	
	public void saisieChoixTamagotchi() {
		Tamagotchi nouveauTama = new Tamagotchi("Baba", 1, 10);
		System.out.println("Veuillez saisir le nom de votre Tamagotchi: ");
		String choixNom = saisir.nextLine();
		nouveauTama.setNomTama(choixNom);
		System.out.println("Nom choisi : "+nouveauTama.getNomTama());
		
		etatDeBase(nouveauTama, energie, poids);
		activiteTama(nouveauTama);
	}
	
	public static void etatDeBase(Tamagotchi tamagotchi, int energie, int poids) {
		System.out.println("Votre tamagotchi nommé "+tamagotchi.getNomTama()+ " est a son niveau de base de "+tamagotchi.getEnergie()+ " et son poids de base de "+tamagotchi.getPoids()+ ".");		
	}
	
	public static void activiteTama(Tamagotchi tamagotchi) {

		boolean vie = false;
		
		do {
				System.out.println("Voulez-vous faire un peu d'activités ? (oui / non)");
				String reponse = saisir.nextLine();
			
				if (reponse.equals("oui")) {
					vie = true;	
				System.out.println("On va faire des activites qui sont : dormir ou jouer ou manger");
				System.out.println("Veuillez choisir entre une de ces 3 propositions");
				
				String choixActivite = saisir.nextLine();
		
					if(choixActivite.equals("dormir")) {
						
						if (tamagotchi.getEnergie() >= 10) {
							System.out.println(tamagotchi.getNomTama()+ "  est a son maximum d'energies. Faites autres choses");
						} else {
							choixDormir(tamagotchi);
						}
						
					} else if (choixActivite.equals("jouer")) {
						choixJouer(tamagotchi);
						if (tamagotchi.getEnergie() <= 0) {
							vie = false;
							System.out.println(tamagotchi.getNomTama()+ " n'a plus de force pour jouer");
							break;
						} 
//						else {
//							
//						}
						
					} else if (choixActivite.equals("manger")) {
						choixManger(tamagotchi);
						if (tamagotchi.getPoids() > 15) {
							System.out.println(tamagotchi.getNomTama()+ " a succombe a son poids. RIP");
							break;
						}
					}
					else {
						System.out.println("Votre reponse n'est pas valide, on recommence");
//						break;
					}
				} 
				else if (reponse.equals("non")) {
					vie = !vie;
					break;
				}
				else {
					vie = !vie;
					System.out.println("Votre reponse n'est pas valide, on recommence");
//					break; //ON
//					System.out.println("Merci et à bientot !");
				}
			
		} while (!vie || tamagotchi.getEnergie() > 0 || tamagotchi.getPoids() <= 15);
		
		System.out.println("Merci et à bientot !");
	}
	
	public static void choixJouer(Tamagotchi tamagotchi) {
		energie = tamagotchi.getEnergie() -5;
		tamagotchi.setEnergie(energie);
		System.out.println("L'energie de votre tamagotchi "+tamagotchi.getNomTama()+ " est tombé à " +tamagotchi.getEnergie());
		
		String rep = "";
		do {
			System.out.println("Voulez-vous rejouer ? (oui/non)");
			rep = saisir.nextLine();
			
			if (rep.equals("oui") && energie > 0) {
			System.out.println("Veuillez taper : jouer");
			saisir.nextLine();
			
			energie = tamagotchi.getEnergie() -5;
			tamagotchi.setEnergie(energie);
			System.out.println("L'energie de votre tamagotchi "+tamagotchi.getNomTama()+ " est tombé à " +tamagotchi.getEnergie());		
				
			} 
		
			else {
//				System.out.println(tamagotchi.getNomTama()+ " n'a plus de force pour jouer");
				break;
			}
		} while (rep.equals("oui"));
		
//		System.out.println("Choisissez d'autres activites");

	}
	
	
	
	public static void choixManger(Tamagotchi tamagotchi) {
		poids = tamagotchi.getPoids() + 5;
		tamagotchi.setPoids(poids);
		System.out.println("Le tamagotchi " +tamagotchi.getNomTama()+ " a pris du poids. Il pese desormais " +tamagotchi.getPoids()+ ".");
		
		String rep = "";
		do {
			
			System.out.println("Voulez-vous continuer a manger ? (oui/non)");
			rep = saisir.nextLine();
			
			if (rep.equals("oui") && tamagotchi.getPoids() <= 15) {
				System.out.println("Veuillez taper : manger");
				saisir.nextLine();
				
				poids = tamagotchi.getPoids() + 5;
				tamagotchi.setPoids(poids);
				System.out.println("Le tamagotchi " +tamagotchi.getNomTama()+ " a repris du poids. Il pese " +tamagotchi.getPoids()+ ".");				
			} 

			else {	
				break;
			}
		
		} while (rep.equals("oui"));

//		System.out.println("Choisissez d'autres activites");
//		
//		if (poids > 15) {
//			System.out.println(tamagotchi.getNomTama()+ " a succombe a son poids. RIP");
//			return;
//			
//		}

	}
	
	
	public static void choixDormir(Tamagotchi tamagotchi) {
//		energie = tamagotchi.getEnergie() +1;
		tamagotchi.setEnergie(energie);
//		System.out.println("Votre energie est "+tamagotchi.getEnergie());
		System.out.println("Votre tamagotchi "+tamagotchi.getNomTama()+ " a un niveau d'energie de "+tamagotchi.getEnergie());
//		System.out.println("Choisissez d'autres activites");
		String rep = "";
		do {
			
			System.out.println("Voulez-vous continuer a dormir ? (oui/non)");
			rep = saisir.nextLine();
			
			if (rep.equals("oui") && tamagotchi.getEnergie() < 10) {
				System.out.println("Veuillez taper : dormir");
				saisir.nextLine();
				
				energie = tamagotchi.getEnergie() +1;
				tamagotchi.setEnergie(energie);
				System.out.println("Votre tamagotchi "+tamagotchi.getNomTama()+ " est entrain de dormir et il aura un taux d'energie de "+tamagotchi.getEnergie()+" à son reveil");				
			} 
			
			else if (tamagotchi.getEnergie() >= 10) {
				System.out.println("L'energie de " +tamagotchi.getNomTama()+ " ne pourra pas changer car elle est a son niveau maximum");
			}

			else {	
				break;
			}
		
		} while (rep.equals("oui"));
	}
	
//	public static void statutEnergie(Tamagotchi tamagotchi) {
//		if (tamagotchi.getEnergie() < 10) {
//			choixDormir(tamagotchi);
//		} else if (tamagotchi.getEnergie() < 1) {
//			System.out.println("Mettez votre tama "+tamagotchi.getNomTama()+ " a dormir car il n'est pas bien");
////			etatTama(tamagotchi);
//		} else {
//			System.out.println("L'energie de " +tamagotchi.getNomTama()+ " ne pourra pas changer car elle est a son niveau maximum");
//			System.out.println("Choisissez d'autres activites");
//			activiteTama(tamagotchi);
//		}
//	}

	
	
	public static void etatTama(Tamagotchi tamagotchi) {
		System.out.println("Niveau energie : "+tamagotchi.getEnergie());
		System.out.println("Niveau jouer : " +tamagotchi.getJouer());
		System.out.println("Niveau manger : " +tamagotchi.getManger());
		System.out.println("Niveau poids : " +tamagotchi.getPoids());
	
	}
		

}
