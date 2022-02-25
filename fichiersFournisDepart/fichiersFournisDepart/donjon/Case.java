package donjon;

import physique.*;

public class Case {

	private Position casePosition;
	
	private boolean decouverte;
	private boolean finNiveau;
	private boolean deAlgoLaby;
	
	int voisin[] = new int[4];
	
	
	public Case(Position p) {
		
		casePosition = new Position(p);
		
		
		
	}
	
	public Position getCopiePosition() {
		
		Position copiePosition;
		
		copiePosition = new Position(casePosition);
		
		return copiePosition;
	}
	
}
