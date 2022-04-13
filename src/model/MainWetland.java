package model;

public class MainWetland{
	private String city;
	public static final int MAX_WETLAND = 80;
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

	public int getEmptyPositionEvent(){
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

    public int getEmptyPositionSpecie(){
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

    public int getEmptyPositionManageP(){
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

	public String addWetland(String nameW, String zoneNameW, String typeW, double areaW, String urlPhotoW, String protectedAreaW){
		String message = "";
		int emptypos = getEmptyPositionWetland();

		if(emptypos==-1){
			message = "El arreglo está lleno";
		}else {
			newWetland[emptypos]  = new Wetland(nameW,typeW,areaW,urlPhotoW,protectedAreaW,zoneNameW);
			message = "Registro Exitoso del humedal " + nameW+"";
		}
		return message;
	}



	public String addWetlandEvent(String wName,String evType, String evEventOwner, double evPrice, String evDescription,String evDay, String evMonth, String evYear){
		String message = "";
		boolean search = false;
		for (int i=0;i<MAX_WETLAND && !search;i++){
			if (newWetland[i].getName().equals(wName)){
				search = true;
				Date eventDate = new Date(evDay,evMonth,evYear);
				newWetland[i].addEvent(evType,evEventOwner,evPrice,evDescription,eventDate);
				message = "El evento fue registrado exitosamente en " + wName;
			}else{
				message = "No existen humedal(es) con el nombre " +wName;
			}	
		}
		return message;
	}


	public String addWetlandSpecie(String wName, String spName, String spScName, String spMigratory, String spType){
        String message = "";
        boolean search = false;
        for(int i = 0; i<MAX_WETLAND && !search;i++){
            if(newWetland[i].getName().equals(wName)){
                search = true;
                newWetland[i].addSpecie(spName,spScName,spMigratory,spType);
                message = "La especie " + spName + " fue guardada en " + wName;
            }else{
                message = "No existen humedal(es) con el nombre: " + wName;
            }
        }
        return message;
    }

    public String addWetlandManageP(String wName,String mType, String mPercentageMp){
        String message = "";
        boolean search = false;
        for(int i = 0; i<MAX_WETLAND && !search;i++){
            if(newWetland[i].getName().equals(wName)){
                search = true;
                newWetland[i].addManageP(mType,mPercentageMp);
                message = "Ha sido guardado en el humedal " + wName;
            }else{
                message = "No existen humedal(es) con el nombre: " + wName;
            }
        }
        return message;
    }

   	public String specieInWetland(String speName){
        boolean search = false;
        String message = "";
        for (int i=0; i<MAX_WETLAND && !search;i++){
            if (newWetland!=null && newWetland[i].findSpecie(speName)){
            	search = true;
            }
            if(search==true){
                message += "La especie " + speName + " se encuentra en el humedal " + newWetland[i].getName();
            }else{
                message = "La especie " + speName + "no esta registrada en ningun humedal" ;
            }
        }
        return message;
    }

    public String mynorFlora(){
    	String message = "";
    	if (newWetland[0]!=null){
    		int minFlora = newWetland[0].countNumFlora();
    		int nameWetland=0;
    		for (int i=0;i<MAX_WETLAND && newWetland[i]!=null;i++){
    			if (minFlora>newWetland[i].countNumFlora()){
    				minFlora= newWetland[i].countNumFlora();
    				nameWetland=i;
    			}
    		}
    		message = "" + newWetland[nameWetland].getName();		
    	}else{
    		message = "No hay ningun humedal registrado";

    	}
    	return message;
    }

    public String maxAnimals(){
    	String message = "";
    	if (newWetland[0]!=null){
    		int mayAnimals = newWetland[0].countNumAnimals();
    		int nameWetland=0;
    		for (int i=0;i<MAX_WETLAND && newWetland[i]!=null;i++){
				if (mayAnimals<newWetland[i].countNumAnimals()){
					mayAnimals= newWetland[i].countNumAnimals();
					nameWetland=i;
				}
			}
			message = "" + newWetland[nameWetland].getName();
    	}else {
    		message = "No hay ningun humedal registrado";
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