package donjon;
import physique.*;

import java.util.Random;

public class Donjon {
	
	Case caseDepart;
	Case caseFin;
	Case[][] casesJeu;
	
	Random aleatoire = new Random();
	
	public Donjon() //Constructeur sans param�tres
	{
		//reference aux configurations
		Configuration instance = Configuration.getInstance();
		//initialise le tableau 2D a l'aide des dimensions provenant des configurations
		casesJeu =  new Case[instance.getConfig(Configuration.NB_LIGNES)][instance.getConfig(Configuration.NB_COLONNES)];
	
		//case depart choisie au hasard, 2 aleatoire 1 pour i et 1 pour j
		caseDepart = new Case(getPositionAlea());
		
		// produit le labyrinthe
		this.produireLabyrinthe();
		// assigne la fin
		this.caseFin.setFinNiveau(true);
	}
	
	public Case[] getCaseDebutetFin() //informatrice pour case de d�part et case de fin
	{
		Case tab[] = new Case[2];
	
		tab[0] = this.caseDepart;
		tab[1] = this.caseFin;
		
		return tab;
	}
	
	public Case[][] getCasesJeu() //informatrice pour obtenir une r�f�rence sur le tableau 2D
	{
		return this.casesJeu;
	}
	
	public Position getPositionAlea() //retourne une une position, choisie al�atoirement � l�int�rieur du donjon
	{
		Configuration instance = Configuration.getInstance();		
		return new Position(aleatoire.nextInt(instance.getConfig(Configuration.NB_LIGNES)), aleatoire.nextInt(instance.getConfig(Configuration.NB_COLONNES)));
	}
	
	
	public int getNbVoisinsNonDeveloppe(Position p) //retourne le nombre de voisins pas d�velopp� autour de la case p
	{
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
	
	public Case getVoisinLibreAlea(Position p) //retourne al�atoirement un voisin libre de la case p
	{
		
		int i;
		boolean trouver = false;
		Case aTester = new Case(p);
		Case voisin = null;
		Position copieVoisin;
		Configuration instance = Configuration.getInstance();		
		
		//pour toutes les directions
		i = Direction.obtenirDirAlea();
		while (!trouver && this.getNbVoisinsNonDeveloppe(p) > 0)
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
			
			else
			{
				i = Direction.obtenirDirAlea();
			}
		}
		
		return voisin;		
	}
	
	
	public Case getVoisinAlea(Position p) //retourne un voisin choisi al�atoirement (que le voisin soit d�velopp� ou pas)
	{		
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
	
	public void produireLabyrinthe() //cr�e le labyrinthe
	{		
		// d�veloppe le labyrinthe � partir de la case d�part
		// l'empile
		PileSChainee p = new PileSChainee();
		p.empiler(this.caseDepart);
		
		//tant que la pile n'est pas vide, continue
		while (!p.estVide())
		{
			// prend la case du haut de la pile sans l�enlever
			Case ccase = (Case)p.regarder();
			
			// obtient sa position
			Position cposition = ccase.getCopiePosition();
			
			// indique que cette case est maintenant d�velopp�e
			ccase.setDecouverte(true);
			
			// v�rifie si cette case a un voisin non d�velopp�
			if (getNbVoisinsNonDeveloppe(cposition) >= 1)
			{
				// oui, choisit une case non d�velopp�e voisine au hasard
				Case cvoisin = getVoisinLibreAlea(cposition);
				
				// obtient la position du voisin
				cvoisin.getCopiePosition();
			
				// calcul la direction du voisin
				// position voisin moins position case courante
				// -> position � direction
			
			
				// ajoute � la case, comme voisin r�ciproque
				// appel � setVoisin pour les deux cases
				// note: la droite d'une case est la gauche de l'autre,
				// utiliser directionOpposee
			
			
				// ajoute le voisin � la pile
			
			
				// d�finit la fin comme �tant la derni�re case d�velopp�e
				this.fin = (Case)pile.regarder();
			}
			
			else
			{
				//sinon
				// il s'agit d'un cul-de-sac, d�pile une case
			}
		}
		
	}
}
