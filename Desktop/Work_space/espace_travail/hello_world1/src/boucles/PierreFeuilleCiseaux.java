package boucles;
import java.util.Scanner;

public class PierreFeuilleCiseaux {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Commencer scanner pour pouvoir taper dans le clavier grace a nextLine()
		Scanner scan = new Scanner(System.in);
		System.out.println("Vous allez jouer à pierre-feuille-ciseaux !");
		boolean test = true;
		int score = 0;	
		System.out.println("A vous de jouer, faites votre choix, entrez pierre, feuille ou ciseaux :");
		
		//Tant que le test est vrai, on arrete le boucle par break (de preference quand l'utilisateur choisit de ne plus continuer a jouer
		while (test) {
			
			//Pouvoir taper dans le clavier a la ligne
			String monChoix = scan.nextLine();
			
			//Si l'utilisateur a rentre le bon choix parmis ceux qui sont proposes
			if(!monChoix.equals("pierre") && !monChoix.equals("feuille") && !monChoix.equals("ciseaux")) {
				System.out.println("Votre choix n'est pas valid");
			} else {
				
				//On a 3 choix et on le convertit en int donc 0, 1 ou 2
				int rand = (int)(Math.random()*3);
				
				//Comme les choix sont en String, on lie les int de random avec les choix possibles 
				String choixAdversaire = "";
				if(rand == 0) {
					choixAdversaire = "pierre";
				} else if(rand == 1) {
					choixAdversaire = "feuille";
				} else {
					choixAdversaire = "ciseaux";
				}
//				System.out.println("choix de l'adversaire: " + choixAdversaire);
				
				//Le jeu : gagne, perd, egalite
				if (monChoix.equals(choixAdversaire)) {
					System.out.println("Match nul, egalité");
					
					//Si l'utilisateur veut rejouer
					System.out.println("Voulez-vous rejouer ? oui ou non");
					String choixRejouer = scan.nextLine();
					
					if (choixRejouer.equals("oui")) {
						
//						System.out.println("toto");
						System.out.println("A vous de jouer, faites votre choix, entrez pierre, feuille ou ciseaux : ");
					} else if (choixRejouer.equals("non")) {
						
						//si il choisit d'arreter, on lui donne son score final
						System.out.println("Merci d'avoir joué !");
						System.out.println("Vous avez un total de " + score + " points");
						break;
					} else {
						System.out.println("Vous n'avez pas bien repondu !");
					}
					
				} else if ((monChoix.equals("pierre") && choixAdversaire.equals("ciseaux")) || (monChoix.equals("ciseaux") && choixAdversaire.equals("feuille")) || (monChoix.equals("feuille") && choixAdversaire.equals("pierre"))) {
						
						System.out.println("Vous avez gagné, Bravo !");
						
						//Incrementation du score
						score+=2;
						System.out.println(score);
						System.out.println("Vous avez " + score + " points");
						
						//Si l'utilisateur veut rejouer
						System.out.println("Voulez-vous rejouer ? oui ou non");
						String choixRejouer = scan.nextLine();
						if (choixRejouer.equals("oui")) {
							
//							System.out.println("toto");
							System.out.println("A vous de jouer, faites votre choix, entrez pierre, feuille ou ciseaux : ");
						} else if (choixRejouer.equals("non")) {
							
							//si il choisit d'arreter, on lui donne son score final
							System.out.println("Merci d'avoir joué !");
							System.out.println("Vous avez un total de " + score + " points");
							break;
						} else {
							System.out.println("Vous n'avez pas bien repondu !");
						}
					}
				else {
					System.out.println("Vous avez perdu.");
					
					//Si l'utilisateur veut rejouer
					System.out.println("Voulez-vous rejouer ? oui ou non");
					String choixRejouer = scan.nextLine();
					if (choixRejouer.equals("oui")) {
						
//						System.out.println("toto");
						System.out.println("A vous de jouer, faites votre choix, entrez pierre, feuille ou ciseaux : ");
					} else if (choixRejouer.equals("non")) {
						
						//si il choisit d'arreter, on lui donne son score final
						System.out.println("Merci d'avoir joué !");
						System.out.println("Vous avez un total de " + score + " points");
						break;
					} else {
						System.out.println("Vous n'avez pas bien repondu !");
					}
//					System.out.println("A vous de jouer, faites votre choix, entrez pierre, feuille ou ciseaux :");
				}
			}
			
		}
		scan.close();
	}
}
