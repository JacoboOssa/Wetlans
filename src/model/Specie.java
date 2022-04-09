package model;

public class Specie{
	private String name;
	private String scName;
	private int migratory;
	private Type type;

	public Specie(String name, String scName, int migratory){
		this.name = name;
		this.scName = scName;
		this.migratory = migratory;
	}

	public String toString(){
		return "\n Nombre Especie:" + name + "\n Nombre Cientifico: " + scName + "\n Migracion: " + migratory + "Tipo:" + type;
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

	public int getMigratory(){
		return migratory;
	}

	public void setMigratory(int migratory){
		this.migratory = migratory;
	}

	
}