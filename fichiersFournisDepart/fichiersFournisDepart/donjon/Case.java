package donjon;

import physique.*;

public class Case {

	private Position casePosition;
	
	private boolean decouverte;
	private boolean finNiveau;
	private boolean deAlgoLaby;
	
	Case voisin[] = new Case[4];
	
	
	public Case(Position p) {
		
		casePosition = new Position(p);
		
		
		
		
	}
	
	public Position getCopiePosition() {
		
		Position copiePosition;
		
		copiePosition = new Position(casePosition);
		
		return copiePosition;
	}

	public boolean estDecouverte() {
		return decouverte;
	}

	public void setDecouverte(boolean decouverte) {
		this.decouverte = decouverte;
	}

	public boolean estFinNiveau() {
		return finNiveau;
	}

	public void setFinNiveau(boolean finNiveau) {
		this.finNiveau = finNiveau;
	}

	public boolean estDeAlgoLaby() {
		return deAlgoLaby;
	}

	public void setDeAlgoLaby(boolean deAlgoLaby) {
		this.deAlgoLaby = deAlgoLaby;
	}
	
	public void setVoisin(int direction) {
		
		
		Position voisinP = new Position(this.casePosition);
		
		voisinP.additionnerPos(Direction.directionAPosition(direction));
		
		voisin[direction].casePosition = voisinP;
		
	}
	
	
}
