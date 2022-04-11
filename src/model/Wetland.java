package model;

public class Wetland{

	private String name;
	private int locationZone;
	private String type;
	private double area;
	private String urlPhoto;
	private String protectedArea;
	private String zoneName;
	public static final int MAX_EVENT = 10;
	private Event [] wetlandEvent;

	public Wetland(String name, int locationZone, String type, double area, String urlPhoto, String protectedArea, String zoneName){
		this.name = name;
		this.locationZone = locationZone;
		this.type = type;
		this.area = area;
		this.urlPhoto = urlPhoto;
		this.protectedArea = protectedArea;
		this.zoneName = zoneName;
		wetlandEvent = new Event[MAX_EVENT];
	}

	public int getEmptyPosition(){
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
		int emptypos = getEmptyPosition();
		if (emptypos==-1){
			out = "El arreglo está lleno";
		}else {
			wetlandEvent[emptypos] = new Event(eType,eEventOwner,ePrice,eDescription,eventDate);
			out = "Registro Exitoso";	
		}
		return out;
	}

	public String toString(){
		return "Nombre del Humedal: " + name + "\n" +
		"Zona del Humedal: " + zoneName + "\n" +
		"Tipo del Humedal: " + type + "\n" + 
		"Area (Km) del Humedal: " + area + "\n" +
		"Url de la foto del Humedal: " + urlPhoto + "\n" + 
		"Area Protegida: " + protectedArea; 
	}


	

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getLocationZone(){
		return locationZone;
	}

	public void setLocationZone(int locationZone){
		this.locationZone = locationZone;
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