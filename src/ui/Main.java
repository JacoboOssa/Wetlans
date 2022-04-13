package ui;

import java.util.Scanner;

import model.MainWetland;


public class Main{

	private MainWetland wetland;
	private Scanner sc;
	public Main(){
		sc= new Scanner(System.in);
	}
	public static void main(String[] args) {
		Main ppal = new Main();
		ppal.initApp();
		int userOption = 0;
		do{
			userOption =ppal.showMenu();
		    ppal.answerOption(userOption);
		}while (userOption !=0);
	}

	 public void initApp(){
        System.out.println("Cuidad");
        String wCity = sc.next();
        wetland = new MainWetland(wCity);
    }


	public int showMenu() {
		int input;
		System.out.println("\n MENU: \n"+ 
		                    "(1) Create Wetland\n" +
		                    "(2) Register a new species in the wetland\n" +
		                    "(3) Register an event in the wetland\n"+
		                    "(4) Amount of maintenance in a year\n"+
		                    "(5) Wetland with fewer species\n"+
		                    "(6) Find habitat of a species\n" + 
		                    "(7) Show wetland information\n" +
		                    "(8) Find a wetland with the largest number of animals\n" + 
		                    "(0) Para salir"
	
		);
		input = sc.nextInt();
		sc.nextLine();
		return input;
	}

	public void answerOption(int userOption) {
		switch(userOption){
		case 0:
			break;
		case 1:
			registerWetland();
			break;
		case 2:
			registerSpecie();
			break;
		case 3: 
			registrarEvent();
			break;
		case 4: 
			registerManageP();
			break;
		case 5:
			mynorFloraSpecie();
			break;
		case 6:
			findSpecieinWetland();
			break;
		case 7:
			showWetlandInfo();
			break;
		case 8:
			mayAnimals();
			break;
		}	
	}

	
	public void registrarEvent(){
		if (wetland.hasSpace()){
			System.out.println("Nombre del wetland");
        	String wetName = sc.nextLine();
        	boolean search = wetland.findWetland(wetName);
        
        	
        	if (search==true){
        		int optionT;
        		String typeEv = "";
				String eventOwnerEv;
				double priceEv;
				String descriptionEv;
				String dayEv;
				String monthEv;
				String yearEv;
        		System.out.println("Ingrese el tipo de evento" + "\n" + 
        			"(1) Mantenimiento" + "\n" +
        			"(2) Visita de Colegio" + "\n" +
        			"(3) Actividad de Mejoramiento" + "\n" + 
        			"(4) Celebracion"
        			);
				optionT= sc.nextInt();
				sc.nextLine();
				switch(optionT){
				case 1:
					typeEv = "Mantenimiento";
					break;
				case 2:
					typeEv = "Visita de Colegio";
					break;
				case 3:
					typeEv = "Actividad de Mejoramiento";
					break;
				case 4:
					typeEv = "Celebracion";
					break;
				}
				System.out.println("Ingrese el dueño del evento");
				eventOwnerEv = sc.nextLine();
				System.out.println("Ingrese el precio del evento");
				priceEv = sc.nextDouble();
				sc.nextLine();
				System.out.println("Ingrese la descripcion del evento");
				descriptionEv = sc.nextLine();
				System.out.println("Ingrese el dia del evento");
				dayEv = sc.nextLine();
				System.out.println("Ingrese el mes del evento");
				monthEv = sc.nextLine();
				System.out.println("Ingrese el año del evento");
				yearEv = sc.nextLine();
				System.out.println(wetland.addWetlandEvent(wetName,typeEv,eventOwnerEv,priceEv,descriptionEv,dayEv,monthEv,yearEv));
		
        	}else {
        		System.out.println("El humedal no existe");
        	}
        }
    }
    
    

    public void registerWetland(){
		if(wetland.hasSpace()){
			String nameWe;
			int locationZoneWe;
			String zoneNameWe = "";
			int optionT;
			String typeWe = "";
			double areaWe;
			String urlPhotoWe;
			int optionP;
			String protectedAreaWe="";
			System.out.println("Ingrese el nombre del humedal");
			nameWe = sc.nextLine();

			System.out.println("Ubicacion del humedal: " + "\n" + 
				"(1) Urbano" + "\n" +
				"(2) Rural"
				);
			locationZoneWe = sc.nextInt();
			sc.nextLine();
			switch(locationZoneWe){
			case 1:
				System.out.println("Nombre del Barrio");
				zoneNameWe = sc.nextLine();

				break;
			case 2:
				System.out.println("Nombre del Corregimiento");
				zoneNameWe = sc.nextLine();

				break;
			}
			System.out.println("Tipo: " + "\n" +
				"(1) Publico" + "\n" + 
				"(2) Privado"
				);
			optionT = sc.nextInt();
			sc.nextLine();
			switch(optionT){
			case 1:
				typeWe = "Publico";
				break;
			case 2:
				typeWe = "Privado";
				break;
			}
			System.out.println("Area del Humedal");
			areaWe = sc.nextDouble();
			sc.nextLine();
			System.out.println("URL de la foto");
			urlPhotoWe = sc.next();
			sc.nextLine();
			System.out.println("Area Protegida: " + "\n" + 
				"(1) Si" + "\n" + 
				"(2) No"
				);
			optionP = sc.nextInt();
			sc.nextLine();
			switch(optionP){
			case 1:
				protectedAreaWe = "Area Protegida";
				break;
			case 2:
				protectedAreaWe = "Area NO Protegida";
				break;
			}
			System.out.println(wetland.addWetland(nameWe,zoneNameWe,typeWe,areaWe,urlPhotoWe,protectedAreaWe));
		}else {
			System.out.println("No hay espacio");
		}
	}


	public void registerSpecie(){
		if (wetland.hasSpace()){
			System.out.println("Nombre del wetland");
        	String wetName = sc.nextLine();
        	boolean search = wetland.findWetland(wetName);

        	if (search==true){
        		String nameSp;
				String scNameSp;
				int optionM;
				String migratorySp = "";
				int optionT;
				String typeSp = "";

        		System.out.println("Nombre de la Especie");
				nameSp = sc.nextLine();

				System.out.println("Nombre Cientifico de la Especie");
				scNameSp = sc.nextLine();

				System.out.println("Especie Migratoria: " + "\n" +
					"(1) Si" + "\n" + 
					"(2) No"
					);
				optionM = sc.nextInt();
				sc.nextLine();
				switch(optionM){
				case 1:
					migratorySp = "Especie Migratoria";
					break;
				case 2:
					migratorySp = "Especie NO Migratoria";
					break;
				}
				System.out.println("Tipo de especie: " + "\n" +
					"(1) Flora Terrestre" + "\n" + 
					"(2) Flora Acuatica" + "\n" +
					"(3) Ave" + "\n" +
					"(4) Mamifero" + "\n" +
					"(5) Acuatico"
					);
				optionT = sc.nextInt();
				sc.nextLine();
				switch(optionT){
				case 1:
					typeSp = "Flora Terrestre";
					break;
				case 2:
					typeSp = "Flora Acuatica";
					break;
				case 3:
					typeSp = "Ave";
					break;
				case 4:
					typeSp = "Mamifero";
					break;
				case 5:
					typeSp = "Acuatico";
					break;
				}
				System.out.println("" + wetland.addWetlandSpecie(wetName, nameSp,scNameSp,migratorySp,typeSp));	
        	}else{
        		System.out.println("EL Humedal No existe");
        	}
        }
    }

    public void registerManageP(){
    	if (wetland.hasSpace()) {
    		System.out.println("Nombre del wetland");
        	String wetName = sc.nextLine();
        	boolean search = wetland.findWetland(wetName);

        	if (search==true){
        		int optionT;
        		String mpType = "";
        		String mpPercentageP;
        		System.out.println("Tipo de Manejo Ambiental " + "\n" +
        			"(1) Restauracion" + "\n" + 
        			"(2) Mantenimiento " + "\n" +
        			"(3) Conservacion " 
        			);
        		optionT = sc.nextInt();
        		sc.nextLine();
        		switch(optionT){
        		case 1:
        			mpType = "Restauracion";
        			break;
        		case 2:
        			mpType ="Mantenimiento";
        			break;
        		case 3:
        			mpType = "Conservacion";
        			break;
        		}
        		System.out.println("Ingrese el porcentaje de implementacion del plan Ambiental");
        		mpPercentageP = sc.nextLine();

        		System.out.println("" + wetland.addWetlandManageP(wetName,mpType,mpPercentageP));
        	}else{
        		System.out.println("El humedal no existe");
        	}
    	}
    }

    public void findSpecieinWetland(){
       System.out.println("Nombre de la Especie:");
       String specieName = sc.nextLine();
       System.out.println(wetland.specieInWetland(specieName));
    }

    public void mynorFloraSpecie(){
       System.out.println("**** El humedal con menos flora es: **** " + "\n" );
       System.out.println(wetland.mynorFlora());
    }
    public void mayAnimals(){
       System.out.println("**** El humedal con mas animales es: **** " + "\n" );
       System.out.println(wetland.maxAnimals());
    }
	


	 public void showWetlandInfo(){
        System.out.println("*****La informacion del humedal*****: " + "\n" + "");
        System.out.println(wetland.toString());
    }

}