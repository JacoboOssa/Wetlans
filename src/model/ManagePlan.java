package model;

public class ManagePlan{
	private String percentagePlan;

	public ManagePlan(String percentagePlan){
		this.percentagePlan = percentagePlan;
	}

	public String toStringManagePlan(){
		return "\n El porcentaje del Plan es: " + percentagePlan + "%";
	}	

	public String getPercentagePlan(){
		return percentagePlan;
	}

	public void setPercentagePlan(String percentagePlan){
		this.percentagePlan = percentagePlan;
	}
}