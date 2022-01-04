package boucles;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.println("utilisateur 1: Choisir pierre, feuille, ciseaux:");
		String player1 = scan.next().toLowerCase();
		System.out.println("utilisateur 2: Choisir pierre, feuille, ciseaux:");
		String player2 = scan.next().toLowerCase();
		scan.close();
		if (player1.equals(player2)) {
		System.out.println("match nul, egalité");
		
		} else if (player1.equals("pierre")) {
			if (player2.equals("ciseaux")) {
				System.out.println("utilisateur 1 gagne");
				
		} else if (player2.equals("feuille")) {
			System.out.println("utilisateur 2 gagne");
		}
		} else if (player1.equals("feuille")) {

			if (player2.equals("pierre")) {
		System.out.println("utilisateur 1 gagne");
		} else if (player2.equals("ciseaux")) {
		System.out.println("player 2 gagne");
		}
		} else if (player1.equals("ciseaux")) {

		if (player2.equals("feuille")) {
		System.out.println("utilisateur 1 gagne");
		} else if (player2.equals("pierre")) {
		System.out.println("utilisateur 2 gagne");
		}
	}
	}
}
