package model;

public class Specie{
	private String name;
	private String scName;
	private String migratory;
	private String type;

	public Specie(String name, String scName, String migratory,String type){
		this.name = name;
		this.scName = scName;
		this.migratory = migratory;
		this.type = type;
	}

	public String toString(){
		return "Nombre Especie: " + name + "\n" +
		 "Nombre Cientifico: " + scName + "\n" +
		 "Migracion: " + migratory + "\n" +
		 "Tipo: " + type;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getScName(){
		return scName;
	}

	public void setScName(String scName){
		this.scName = scName;
	}

	public String getMigratory(){
		return migratory;
	}

	public void setMigratory(String migratory){
		this.migratory = migratory;
	}

	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}

	
}