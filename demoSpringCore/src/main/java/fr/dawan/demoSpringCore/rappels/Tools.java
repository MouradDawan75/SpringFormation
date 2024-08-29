package fr.dawan.demoSpringCore.rappels;

import java.beans.XMLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Tools {
	
	// variable de classe, pas besoin de l'initialiser car elle possède une valeur par défaut
	/*
	 * Types numériques: par défaut = 0
	 * Type boolean: par défaut = false
	 * Type complèxe (objet) par défaut = null
	 */
	int x;
	
	public void instanceMethode() {
		//y variable locale qui doit être initialisée
		int y = 10;
		
	}
	
    public static void classeMethode() {
		
	}
    
    public static void main(String[] args) throws Exception {
		
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
    	
    	String s1 = "test";
    	
    	String s = "test";
    	s.toUpperCase();
    	
    	Animal a = new Animal();
    	a.setNom("a");
    	a.setAge(5);
    	a.emettreSon();
    
    	
    	
    	Chat c = new Chat();
    	c.setNom("c");
    	c.setAge(3);
    	c.emettreSon();
    	c.dormir();
    	
    	//Une classe mère définie une sorte de structure de base pour les classes filles. Elle contient les
    	//éléments communs aux classes filles
    	
    	//La classe fille récupère grace à l'héritage tous les éléments publiques de la classe mère
    	/*
    	 * En plus des attributs définis dans la classe mère, elle peut avoir des attributs qui lui sont spécifiques
    	 * En plus des méthodes définies dans la classe mère, elle peut avoir des méthodes qui lui sont spécifiques
    	 * Elle peut surcharger (modifier) les méthodes défnies dans la classe mère en cas de besoin
    	 * 
    	 */
    	
    	Animal a1 = new Animal();
    	Animal a2 = new Chat();
    	Animal a3 = new Chien();
    	
    	//Polymorphisme: c'est le fait qu'un objet puisse prendre plusieurs formes.
    	/*
    	 * C'est une conséquence de l'héritage, c'est le fait que l'objet parent puisse prendre la forme de tous les
    	 * objets enfants.
    	 */
    	
    	List<String> chaines = new ArrayList<>();
    	chaines.add("s");
    	chaines.add("s1");
    	
    	//Collection polymorphique
    	List<Animal> animaux = new ArrayList<>();
    	animaux.add(new Animal());
    	animaux.add(new Chat());
    	animaux.add(new Chien());
    	animaux.add(new Giraffe());
    	
    	son(new Animal());
    	son(new Chat());
    	son(new Chien());
    	son(new Giraffe());
    	
    	ICalcul cal = new CalculDatabase();
    	
    	cal.add(10, 20);
    	cal.add(10, 20);
    	cal.add(10, 20);
    	cal.add(10, 20);
    	cal.add(10, 20);
    	
    	traitement(new CalculFichier(), 10, 25);
    	traitement(new CalculDatabase(), 45, 22);
    	
    	ICalcul iccc = (x,y) -> x * y; //expression lambda -> méthode anonyme
    	
    	ICalcul iii = ClasseService::classeMethode; //réference vers une méthode de classe
    	iii.add(10, 25);
    	
    	ClasseService cs = new ClasseService();
    	
    	ICalcul iiiii = cs::instanceMethode; //réference vers une méthode d'instance
    	
    	//Lambda et méthodes réference: syntaxe utilisée dans l'API Stream
    	
    	//Classe anonyme: syntaxe très utilisée dans Android et dans les Thread
    	ICalcul dd = new ICalcul() {
			
			@Override
			public int add(int x, int y) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
    	
	}
    
    
    public static void son(Animal a) {
    	a.emettreSon();
    }
    
    public static int traitement(ICalcul ic, int x, int y) {
    	return ic.add(x, y);
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
    
    // (x,y) -> x+y;
    
    public int somme(int x, int y) {
    	if(isPositif(x) && isPositif(y)) {
    		return x + y;
    	}
    	return 0;
    }
    
    private boolean isPositif(int i) {
    	return i > 0;
    }

}
