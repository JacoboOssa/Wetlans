package model;

public class Wetland{

	private String name;
	private int locationZone;
	private int type;
	private double area;
	private String urlPhoto;
	private boolean protectedArea;
	private String zoneName;
	public static final int MAX_EVENT = 10;
	private Event [] wetlandEvent;
	private Specie [] newSpecie;

	public Wetland(String name, int locationZone, int type, double area, String urlPhoto, boolean protectedArea, String zoneName){
		this.name = name;
		this.locationZone = locationZone;
		this.type = type;
		this.area = area;
		this.urlPhoto = urlPhoto;
		this.protectedArea = protectedArea;
		this.zoneName = zoneName;
		wetlandEvent = new Event[MAX_EVENT];
	}

	public boolean hasSpace(){
		boolean emptyPosition = false;
		for (int i=0;i<MAX_EVENT && !emptyPosition;i++ ) {

			if (wetlandEvent[i]==null){
				emptyPosition = true;
			}
		}

		return emptyPosition;
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
			wetlandEvent[emptypos] = new Event(eType,eEventOwner,ePrice,eDescription,wetlandEvent[i].addDate());
			out = "Registro Exitoso";	
		}
		return out;
	}

	public String toStringEvent(){
		String out = "";
		for (int i=0;i<MAX_EVENT;i++){
			if (wetlandEvent[i]!=null){
				out+= "" + wetlandEvent[i];
			}
		}
		return out;
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

	public int getType(){
		return type;
	}

	public void setType(int type){
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

	public boolean getProtectedArea(){
		return protectedArea;
	}

	public void setProtectedArea(boolean protectedArea){
		this.protectedArea = protectedArea;
	}

	public String getZoneName(){
		return zoneName;
	}

	public void setZoneName(String zoneName){
		this.zoneName = zoneName;
	}
	
}