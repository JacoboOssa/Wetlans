package model;

public class Event{

	private String type;
	private String eventOwner;
	private double price;
	private String description;

	private Date dateEvent;


	public Event(String type, String eventOwner, double price, String description, Date dateEvent){
		this.type = type;
		this.eventOwner = eventOwner;
		this.price = price;
		this.description = description;
		this.dateEvent = dateEvent;
	}


	public String toString(){
		return "\n Tipo Evento " + type + 
		"\n Dueño del evento: " + eventOwner + 
		"\n Precio Evento: " + price + 
		"\n Descripcion: " + description + 
		"\n" + dateEvent.toString();
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

	public Date getDate(){
		return dateEvent;
	}

	public void setDate(Date dateEvent){
		this.dateEvent = dateEvent;
	}
}