package fr.dawan.demoSpringCore.rappels;

public class CalculFichier implements ICalcul{

	@Override
	public int add(int x, int y) {
		//Lecture de x et y à partir d'un fichier
		return x + y;
	}

}
