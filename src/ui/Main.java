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
			break;
		case 3: 
			registrarEvent();
			break;
		case 4: 
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			showWetlandInfo();
			break;
		case 8:
			break;
		}	
	}

	public void registrarEvent(){
		if (wetland.hasSpace()){
			String typeEv;
			String eventOwnerEv;
			double priceEv;
			String descriptionEv;
			String dayEv;
			String monthEv;
			String yearEv;
			System.out.println("Nombre del wetland");
        	String wName = sc.nextLine();
        	boolean conf = wetland.findWetland(wName);

			System.out.println("Ingrese el tipo de evento");
			typeEv= sc.next();
			sc.nextLine();
			System.out.println("Ingrese el dueño del evento");
			eventOwnerEv = sc.next();
			sc.nextLine();
			System.out.println("Ingrese el precio del evento");
			priceEv = sc.nextDouble();
			sc.nextLine();
			System.out.println("Ingrese la descripcion del evento");
			descriptionEv = sc.next();
			sc.nextLine();
			System.out.println("Ingrese el dia del evento");
			dayEv = sc.next();
			sc.nextLine();
			System.out.println("Ingrese el mes del evento");
			monthEv = sc.next();
			sc.nextLine();
			System.out.println("Ingrese el año del evento");
			yearEv = sc.next();
			sc.nextLine();


			System.out.println(wetland.addWetlandEvent(wName,typeEv,eventOwnerEv,priceEv,descriptionEv,dayEv,monthEv,yearEv));
		}else{
			System.out.println("No hay espacio");
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
			sc.nextLine();
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
				sc.nextLine();
				break;
			case 2:
				System.out.println("Nombre del Corregimiento");
				zoneNameWe = sc.nextLine();
				sc.nextLine();
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
			System.out.println(wetland.addWetland(nameWe,locationZoneWe,zoneNameWe,typeWe,areaWe,urlPhotoWe,protectedAreaWe));
		}else {
			System.out.println("No hay espacio");
		}
	}

	 public void showWetlandInfo(){
        System.out.println("*****La informacion del humedal*****: " + "\n" + "");
        System.out.println(wetland.toString());
    }


}