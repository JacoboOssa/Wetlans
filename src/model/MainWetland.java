package model;

public class MainWetland{
	private String city;
	public static final int MAX_WETLAND = 10;
	private Wetland [] newWetland;

	public MainWetland(String city){
		this.city = city;
		newWetland = new Wetland[MAX_WETLAND];
	}



	public boolean hasSpace(){
		boolean emptyPosition = false;
		for (int i=0;i<MAX_WETLAND && !emptyPosition;i++ ) {

			if (newWetland[i]==null){
				emptyPosition = true;
			}
		}

		return emptyPosition;
	}

	public int getEmptyPosition(){
		int emptyPos=-1;
		boolean centinela = false;

		for (int i=0;i<MAX_WETLAND && !centinela;i++) {
			if (newWetland[i]==null) {
				emptyPos = i;
				centinela = true;	
			}	
		}

		return emptyPos;
	}

	 public int getEmptyPositionWetland(){
        boolean emptyPosition = false;
		int position = -1;
		for (int i=0; i<MAX_WETLAND && !emptyPosition; i++){
			if(newWetland[i] == null){
				emptyPosition = true;
				position = i;
			}
		}
		return position;
    }

	public boolean findWetland(String wName){
		boolean flag = false;

		for (int i=0;i<MAX_WETLAND && !flag;i++){
			if (newWetland[i]!=null && newWetland[i].getName().equals(wName)){
				flag = true;	
			}		
		}
		return flag;

	}

	public String addWetland(String nameW, int locationZoneW,String zoneNameW, String typeW, double areaW, String urlPhotoW, String protectedAreaW){
		String out = "";
		int emptypos = getEmptyPositionWetland();

		if(emptypos==-1){
			out = "El arreglo está lleno";
		}else {
			newWetland[emptypos]  = new Wetland(nameW,locationZoneW,typeW,areaW,urlPhotoW,protectedAreaW,zoneNameW);
			out = "Registro Exitoso del humedal " + nameW+"";
		}
		return out;
	}



	public String addWetlandEvent(String wName,String evType, String evEventOwner, double evPrice, String evDescription,String evDay, String evMonth, String evYear){
		String message = "";
		
		int emptypos = getEmptyPosition();
		boolean search= findWetland(wName);

		if (emptypos == -1) {
			message = "El arreglo esta lleno";		
		}else{
			if (search==true) {
				Date evDate = new Date(evDay,evMonth,evYear);
                newWetland[emptypos].addEvent(evType,evEventOwner,evPrice,evDescription,evDate);
				message = "Registro del evento en el humdal " + wName + " Exitoso";
			}else {
				message = "El humedal no existe";
			}
		}

		return message;
	}

	 public String toString(){
        String out = "";
        for(int i=0; i<MAX_WETLAND && newWetland[i]!=null;i++){
            out += "\n" + 
            "******************* \n" + newWetland[i].toString() + "\n*******************";
        }
        return out;
    }



}