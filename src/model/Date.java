package model;

public class Date{
	//Atributos
	private String day;
	private String month;
	private String year;

	public Date(String day, String month, String year){
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String toString(){
		return "La fecha del evento:" + day + "/" + month + "/" +year;
	}

	public String getDay(){
		return day;
	}
	public void setDay(String day){
		this.day = day;
	}

	public String getMonth(){
		return month;
	}

	public void setMonth(String month){
		this.month = month;
	}

	public String getyear(){
		return year;
	}

	public void setyear(String year){
		this.year = year;
	}

}