package fr.dawan.demoSpringCore.rappels;

public class Tools {
	
	// variable de classe, pas besoin de l'initialiser car elle possède une valeur par défaut
	int x;
	
	public void instanceMethode() {
		//y variable locale qui doit être initialisée
		int y = 10;
		
	}
	
    public static void classeMethode() {
		
	}
    
    public static void main(String[] args) {
		
    	Tools.classeMethode();
    	
    	Tools t = new Tools();
    	t.instanceMethode();
    	
    	//Constructeur son rôle est d'instancier: créer un objet à partir de la classe (initialiser les attributs de l'objet)
    	Produit p = new Produit();
    	
    	/*
    	 * id: 0
    	 * nom: null
    	 * dispo: false
    	 */
    	
    	ISlf4j myLog = new Logbak();
    	myLog.log("log1......");
    	myLog.log("log2......");
    	myLog.log("log3......");
    	myLog.log("log4......");
    	
	}

}
