package ui;

import java.util.Scanner;

import model.Wetland;


public class Main{

	private Wetland wetland;
	private Scanner sc;
	public Main(){
		sc= new Scanner(System.in);
	}
	public static void main(String[] args) {
		Main ppal = new Main();
		int option = 0;
		do{
			option =ppal.showMenu();
		    ppal.answerOption(option);
		}while (option !=0);
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
			break;
		case 8:
			break;
		}	
	}

	public void registrarEvent(){
		if (wetland.hasSpace()){
			String evType;
			String evEventOwner;
			double evPrice;
			String evDescription;
			String evDate;
			System.out.println("Ingrese el tipo de evento");
			evType= sc.next();
			sc.nextLine();
			System.out.println("Ingrese el dueño del evento");
			evEventOwner = sc.next();
			sc.nextLine();
			System.out.println("Ingrese el precio del evento");
			evPrice = sc.nextDouble();
			sc.nextLine();
			System.out.println("Ingrese la descripcion del evento");
			evDescription = sc.next();
			sc.nextLine();
			System.out.println("Ingrese la Fecha del evento");
			evDate = sc.next();
			sc.nextLine();


			System.out.println(wetland.addEvent(evType,evEventOwner,evPrice,evDescription,evDate));
		}else{
			System.out.println("No hay espacio");
		}

	}


}