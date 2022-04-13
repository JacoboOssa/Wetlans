package model;

public class ManagePlan{
	private String percentagePlan;
	private String type;


	public ManagePlan(String type ,String percentagePlan){
		this.type = type;
		this.percentagePlan = percentagePlan;
	}

	public String toString() {
        return "Tipo de Manejo Ambiental: " + type + "\n" +
        "Porcentaje del Plan: " + percentagePlan + " %";   
    }


	public String getPercentagePlan(){
		return percentagePlan;
	}

	public void setPercentagePlan(String percentagePlan){
		this.percentagePlan = percentagePlan;
	}

	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
}