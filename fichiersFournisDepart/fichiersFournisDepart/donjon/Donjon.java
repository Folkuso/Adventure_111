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
		int i, compte = 0;
		Case aTester = new Case(p);
		Case voisin;
		Position copieVoisin;
		Configuration instance = Configuration.getInstance();
		
		
		//pour toutes les directions
		for(i= 0 ; i< 4;i++)
		{
			aTester.setVoisin(i);
			voisin = aTester.getVoisin(i);
			copieVoisin = aTester.getCopiePosition();
			if(copieVoisin.getI()>=0 && copieVoisin.getI()<instance.getConfig(Configuration.NB_LIGNES)
					&& copieVoisin.getJ() >= 0 && copieVoisin.getJ() < instance.getConfig(Configuration.NB_COLONNES))
			{
				if(!voisin.estDeveloppe())
				{
					compte++;
				}
			}
		}		
		return compte;
	}
	
	public Case getVoisinLibreAlea(Position p)
	{
		
		int i;
		boolean trouver = false;
		Case aTester = new Case(p);
		Case voisin = null;
		Position copieVoisin;
		Configuration instance = Configuration.getInstance();
		
		
		//pour toutes les directions
		for(i= 0 ; i< 4 && !trouver && this.getNbVoisinsNonDeveloppe(p) > 0;i++)
		{
			aTester.setVoisin(i);
			voisin = aTester.getVoisin(i);
			copieVoisin = aTester.getCopiePosition();
			if(copieVoisin.getI()>=0 && copieVoisin.getI()<instance.getConfig(Configuration.NB_LIGNES)
					&& copieVoisin.getJ() >= 0 && copieVoisin.getJ() < instance.getConfig(Configuration.NB_COLONNES))
			{
				if(!voisin.estDeveloppe())
				{
					trouver = true;					
				}
			}
		}		
		
		return voisin;		
	}
	
	
	public Case getVoisinAlea(Position p) {
		
		Configuration instance = Configuration.getInstance();
		Direction directionAlea = null;
		Position positionAlea;
		boolean valide = false;
		
		Case leVoisinAlea;
		
		int intDirection;

		do {
			
		intDirection = directionAlea.obtenirDirAlea();
		
		positionAlea = directionAlea.directionAPosition(intDirection);
		
		positionAlea.additionnerPos(p);
		
		if(positionAlea.getI()>=0 && positionAlea.getI()<instance.getConfig(Configuration.NB_LIGNES) && positionAlea.getJ() >= 0 && positionAlea.getJ() < instance.getConfig(Configuration.NB_COLONNES)) 
			valide = true;
		
		} while(!valide);
		
		leVoisinAlea = new Case(positionAlea);
		
		return leVoisinAlea;
	}
	
	
}
