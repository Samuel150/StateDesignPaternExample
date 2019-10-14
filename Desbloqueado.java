package stateExample;

public class Desbloqueado implements IStateExample {

	private static Desbloqueado instance = null;
	
	public static Desbloqueado getInstance() {
		if(instance == null){
			instance = new Desbloqueado();
		}
		return instance;
	}
	
	@Override
	public void handle(String action,String parameter,Celular celular) {
		if(action.equals("llamar")){
			System.out.println("llamando");
		}else if(action.equals("jugar")){
			System.out.println("Jugando");
		}else if(action.equals("sacarFotos")){
			System.out.println("Sacando Fotos");
		}
	}

}
