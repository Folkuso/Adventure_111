package physique;

public class Exercice {
	public static void main(String args[])
	{
		Position p = new Position();
		p.setI(1);
		p.setJ(2);
		
		System.out.print(p.getI() + " ");
		System.out.println(p.getJ());
		
		Position p1 = new Position(3,4);
		System.out.println("p1 pas cloné : " + p1);
		p1.clone(p);
		System.out.println("p1 cloné : " + p1);
		
		if (p1.equals(p))
			System.out.println("C'est égal");
		else
			System.out.println("C'est pas égal");
	}
}
