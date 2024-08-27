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
    	
    	try {
			calculs(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    
    public static void calculs(int i) throws Exception {
    	
    	//Option1: la méthode gère sa propre exception
//    	try {
//    	System.out.println(10 / i);
//    	}catch(Exception e) {
//    		e.printStackTrace();
//    	}
    	
    	//Option2: faire une remontée d'exception -> lexception doit être gérée par les appelants de cette méthode
    	if(i != 0) {
    		System.out.println(10 / i);
    	}else {
    		
    		//throw permet de déclencher une exception
    		throw new Exception("Tentative de division par zéro.....");
    	}
    }

}
