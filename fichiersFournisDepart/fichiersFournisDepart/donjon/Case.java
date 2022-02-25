package donjon;
import physique.*;

public class Case {

	private Position casePosition; //r�f�rence � une position
	
	private boolean decouverte; //indique si la case a �t� d�couverte par le h�ros
	private boolean finNiveau; //indique si la case est la fin d'un niveau
	private boolean developpe; //indique si la case a �t� d�velopp�e par l'algorithme du labyrinthe
	
	Case voisin[] = new Case[4]; //contient les r�f�rences sur les voisins connect�s
	
	//Constructeur avec param�tres
	public Case(Position p) //Re�oit une r�f�rence � une position
	{
		casePosition = new Position(p);
	}
	
	public Position getCopiePosition() //Obtient une copie de la position membre
	{
		Position copiePosition;
		
		copiePosition = new Position(casePosition);
		
		return copiePosition;
	}
	
	public boolean estDecouverte() //Indique si la case est d�couverte ou non
	{
		return decouverte;
	}

	public void setDecouverte(boolean decouverte) //Mutateur (�criture) de l'attribut d�couverte
	{
		this.decouverte = decouverte;
	}

	public boolean estFinNiveau() //Indique si c'est la fin du niveau
	{
		return finNiveau;
	}

	public void setFinNiveau(boolean finNiveau) //Mutateur (�criture) de l'attribut finNiveau
	{
		this.finNiveau = finNiveau;
	}

	public boolean estDeveloppe() //Indique si la case a �t� d�velopp�e
	{
		return developpe;
	}

	public void setDeveloppe(boolean deAlgoLaby) //Mutateur (�criture) de l'attribut deAlgoLaby (si la case a �t� d�velopp�e)
	{
		this.developpe = deAlgoLaby;
	}
	
	public void setVoisin(int direction) //D�fini la position du voisin selon la position actuelle du joueur
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
				+"\nD�couverte par le Hero: "+this.estDecouverte()
				+"\nFin du niveau: "+this.estFinNiveau()
				+"\nD�velopp�e par l'algorithme: "+this.estDeveloppe();
	}
	
}
