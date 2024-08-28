package fr.dawan.demoSpringCore.rappels;

public class CalculDatabase implements ICalcul{

	@Override
	public int add(int x, int y) {
		//Lecture de x et y depuis une BD
		return x + y;
	}

}
