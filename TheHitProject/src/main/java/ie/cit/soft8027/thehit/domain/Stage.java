package ie.cit.soft8027.thehit.domain;

public class Stage {
	
	private static Stage stage=null;
	
	public static Stage getInstance(){
		
		if(stage==null){
			stage=new Stage();
		}		
		return stage;
	}
}