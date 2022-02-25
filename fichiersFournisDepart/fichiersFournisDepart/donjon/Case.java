package donjon;
import physique.*;

public class Case {

	private Position casePosition; //référence à une position
	
	private boolean decouverte; //indique si la case a été découverte par le héros
	private boolean finNiveau; //indique si la case est la fin d'un niveau
	private boolean developpe; //indique si la case a été développée par l'algorithme du labyrinthe
	
	Case voisin[] = new Case[4]; //contient les références sur les voisins connectés
	
	//Constructeur avec paramètres
	public Case(Position p) //Reçoit une référence à une position
	{
		casePosition = new Position(p);
	}
	
	public Position getCopiePosition() //Obtient une copie de la position membre
	{
		Position copiePosition;
		
		copiePosition = new Position(casePosition);
		
		return copiePosition;
	}
	
	public boolean estDecouverte() //Indique si la case est découverte ou non
	{
		return decouverte;
	}

	public void setDecouverte(boolean decouverte) //Mutateur (écriture) de l'attribut découverte
	{
		this.decouverte = decouverte;
	}

	public boolean estFinNiveau() //Indique si c'est la fin du niveau
	{
		return finNiveau;
	}

	public void setFinNiveau(boolean finNiveau) //Mutateur (écriture) de l'attribut finNiveau
	{
		this.finNiveau = finNiveau;
	}

	public boolean estDeveloppe() //Indique si la case a été développée
	{
		return developpe;
	}

	public void setDeveloppe(boolean deAlgoLaby) //Mutateur (écriture) de l'attribut deAlgoLaby (si la case a été développée)
	{
		this.developpe = deAlgoLaby;
	}
	
	public void setVoisin(int direction) //Défini la position du voisin selon la position actuelle du joueur
	{
		Position voisinP = new Position(this.casePosition);
		
		voisinP.additionnerPos(Direction.directionAPosition(direction));
		
		voisin[direction].casePosition = voisinP;
		
	}
	
	public Case getVoisin(int direction) {
		return voisin[direction];
	}
	
	public String toString()
	{
		return "Position: [ "+this.casePosition.getI()+"] i"+"["+this.casePosition.getJ()+"] j"
				+"\nDécouverte par le Hero: "+this.estDecouverte()
				+"\nFin du niveau: "+this.estFinNiveau()
				+"\nDéveloppée par l'algorithme: "+this.estDeveloppe();
	}
	
}
