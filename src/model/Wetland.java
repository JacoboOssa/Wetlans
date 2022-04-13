package model;

public class Wetland{

	private String name;
	private String type;
	private double area;
	private String urlPhoto;
	private String protectedArea;
	private String zoneName;
	public static final int MAX_EVENT = 80;
	private Event [] wetlandEvent;
	public static final int MAX_SPECIE = 80;
	private Specie [] wetlandSpecie;
	public static final int MAX_MPLAN = 80;
	private ManagePlan [] manageP;

	public Wetland(String name, String type, double area, String urlPhoto, String protectedArea, String zoneName){
		this.name = name;
		this.type = type;
		this.area = area;
		this.urlPhoto = urlPhoto;
		this.protectedArea = protectedArea;
		this.zoneName = zoneName;
		wetlandEvent = new Event[MAX_EVENT];
		wetlandSpecie = new Specie[MAX_SPECIE];
		manageP = new ManagePlan[MAX_MPLAN];
	}

	public int getEmptyPositionEvent(){
		int emptyPos=-1;
		boolean centinela = false;

		for (int i=0;i<MAX_EVENT && !centinela;i++) {
			if (wetlandEvent[i]==null) {
				emptyPos = i;
				centinela = true;	
			}	
		}

		return emptyPos;
	}

	public int getEmptyPositionSpecie(){
		int emptyPos=-1;
		boolean centinela = false;

		for (int i=0;i<MAX_SPECIE && !centinela;i++) {
			if (wetlandSpecie[i]==null) {
				emptyPos = i;
				centinela = true;	
			}	
		}

		return emptyPos;
	}

	public int getEmptyPositionManageP(){
		int emptyPos=-1;
		boolean centinela = false;

		for (int i=0;i<MAX_EVENT && !centinela;i++) {
			if (wetlandEvent[i]==null) {
				emptyPos = i;
				centinela = true;	
			}	
		}

		return emptyPos;
	}

	public String addEvent(String eType,String eEventOwner, double ePrice, String eDescription,Date eventDate){
		String out = "";
		int emptypos = getEmptyPositionEvent();
		if (emptypos==-1){
			out = "El arreglo está lleno";
		}else {
			wetlandEvent[emptypos] = new Event(eType,eEventOwner,ePrice,eDescription,eventDate);
			out = "Registro Exitoso";	
		}
		return out;
	}

	public String addSpecie(String sName, String sScName, String sMigratory, String sType){
		String out = "";
		int emptypos = getEmptyPositionSpecie();
		if (emptypos==-1){
			out = "El arreglo está lleno";
		}else {
			wetlandSpecie[emptypos] = new Specie(sName,sScName,sMigratory,sType);
			out = "Registro Exitoso";	
		}
		return out;
	}

	public String addManageP(String mpType,String mpPercentagePlan){
		String out = "";
		int emptypos = getEmptyPositionManageP();
		if (emptypos==-1){
			out= "El arreglo está lleno";
		}else{
			manageP[emptypos]= new ManagePlan(mpType,mpPercentagePlan);
			out = "Registro Exitoso";
		}	
		return out;
	}


	public boolean findSpecie(String specieNm){
        boolean search = false;
        for(int i=0;i<MAX_SPECIE && !search;i++){
            if(wetlandSpecie!=null && wetlandSpecie[i].getName().equals(specieNm)){
                search = true;
            }
        }
        return search;
    }

    public int countNumFlora(){
        int flora = 0;
        for(int i=0;i<MAX_SPECIE && wetlandSpecie[i]!=null;i++){
            if(wetlandSpecie[i].getType().equals("Flora Terrestre") || wetlandSpecie[i].getType().equals("Flora Acuatica")){
                flora++;
            }
        }
        return flora;
    }

    public int countNumAnimals(){
        int animal = 0;
        for(int i=0;i<MAX_SPECIE && wetlandSpecie[i]!=null;i++){
            if(wetlandSpecie[i].getType().equals("Ave") || wetlandSpecie[i].getType().equals("Mamifero") || wetlandSpecie[i].getType().equals("Acuatico")){
                animal++;
            }
        }
        return animal;
    }

	public String toString(){
		return "Nombre del Humedal: " + name + "\n" +
		"Zona del Humedal: " + zoneName + "\n" +
		"Tipo del Humedal: " + type + "\n" + 
		"Area del Humedal: " + area + " KM" + "\n" +
		"Url de la foto del Humedal: " + urlPhoto + "\n" + 
		"Area Protegida: " + protectedArea + "\n" +
		"**** INFORMACION ESPECIES **** " + "\n" + toStringSpecie() + "\n" +
		"**** INFORMACION PLAN MANEJO AMBIENTAL ****" + "\n" + toStringManagePlan();
	}

	public String toStringEvent(){
		String out = "";
        for(int i=0;i<MAX_EVENT && wetlandEvent[i]!=null;i++){
            out += "" +  wetlandEvent[i].toString();
        }
        return out;
    }

     public String toStringSpecie(){
        String out = "";
        for(int i=0;i<MAX_SPECIE && wetlandSpecie[i]!=null;i++){
            out += "" + wetlandSpecie[i].toString();
        }
        return out;
    }

    public String toStringManagePlan(){
        String out = "";
        for(int i=0;i<MAX_MPLAN && manageP[i]!=null;i++){
            out += "" + manageP[i].toString();
        }
        return out;
    }


	

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public Double getArea(){
		return area;
	}

	public void setArea(double area){
		this.area = area;
	}

	public String getUrlPhoto(){
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto){
		this.urlPhoto = urlPhoto;
	}

	public String getProtectedArea(){
		return protectedArea;
	}

	public void setProtectedArea(String protectedArea){
		this.protectedArea = protectedArea;
	}

	public String getZoneName(){
		return zoneName;
	}

	public void setZoneName(String zoneName){
		this.zoneName = zoneName;
	}
	
}