package donjon;
import physique.*;

import java.util.Random;

public class Donjon {
	
	Case caseDepart;
	Case caseFin;
	Case[][] casesJeu;
	
	Random aleatoire = new Random();
	
	
	
	
	public Donjon() {
		//reference aux configurations
		Configuration instance = Configuration.getInstance();
		//initialise le tableau 2D a l'aide des dimensions provenant des configurations
		casesJeu =  new Case[instance.getConfig(Configuration.NB_LIGNES)][instance.getConfig(Configuration.NB_COLONNES)];
	
		//case depart choisie au hasard, 2 aleatoire 1 pour i et 1 pour j
		caseDepart = new Case(getPositionAlea());
		
	}
	
	public Case[] getCaseDebutetFin() {
		Case tab[] = new Case[2];
	
		tab[0] = this.caseDepart;
		tab[1] = this.caseFin;
		
		return tab;
	}
	
	public Case[][] getCasesJeu(){
		return this.casesJeu;
	}
	
	public Position getPositionAlea() {
		Configuration instance = Configuration.getInstance();		
		return new Position(aleatoire.nextInt(instance.getConfig(Configuration.NB_LIGNES)), aleatoire.nextInt(instance.getConfig(Configuration.NB_COLONNES)));
	}
	
	
	public int getNbVoisinsNonDeveloppe(Position p) {
		int compte = 0;
		
		//pour toutes les directions
		//for
			
		
		return compte;
	}
}
