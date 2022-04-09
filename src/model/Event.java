package model;

public class Event{

	private String type;
	private String eventOwner;
	private double price;
	private String description;
	public static final int MAX_DATE = 10;

	private Date [] dateEvent;


	public Event(String type, String eventOwner, double price, String description){
		this.type = type;
		this.eventOwner = eventOwner;
		this.price = price;
		this.description = description;
		dateEvent = new Date[MAX_DATE];
	}

	public String addDate(String eDay, String eMonth, String eYear){
		String out = "";
		int emptypos = getEmptyPosition();
		if (emptypos==-1){
			out = "El arreglo está lleno";
		}else {
			dateEvent[emptypos] = new Date(eDay,eMonth,eYear);
			out = "Registro Exitoso";	
		}
		return out;
	}

	public boolean hasSpace(){
		boolean emptyPosition = false;
		for (int i=0;i<MAX_DATE && !emptyPosition;i++ ) {

			if (dateEvent[i]==null){
				emptyPosition = true;
			}
		}

		return emptyPosition;
	}

	public int getEmptyPosition(){
		int emptyPos=-1;
		boolean centinela = false;

		for (int i=0;i<MAX_DATE && !centinela;i++) {
			if (dateEvent[i]==null) {
				emptyPos = i;
				centinela = true;	
			}	
		}

		return emptyPos;
	}

	public String toStringDate(){
		String out = "";
		for (int i=0;i<MAX_DATE;i++){
			if (dateEvent[i]!=null){
				out+= "" + dateEvent[i];
			}
		}
		return out;
	}



	public String toString(){
		return "\n Tipo Evento " + type + "\n Dueño del evento: " + eventOwner + "\n Precio Evento: " + price + "\n Descripcion: " + description + "\n" + toStringDate();
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getEventOwner(){
		return eventOwner;
	}

	public void setEventOwner(String eventOwner){
		this.eventOwner = eventOwner;
	}

	public Double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}
}