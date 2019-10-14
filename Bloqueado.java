package stateExample;

import java.time.LocalTime;

public class Bloqueado implements IStateExample {

	private static Bloqueado instance = null;
	
	LocalTime time = LocalTime.now();
	
	public static Bloqueado getInstance(){
		if(instance==null){
			instance=new Bloqueado();
		}
		return instance;
	}
	
	@Override
	public void handle(String action,String parameter,Celular celular) {
		if(action.equals("password")){
			if(parameter.equals(celular.getPassword()) && celular.getTimesTried()<3){
				celular.setState(Desbloqueado.getInstance());
				System.out.println("Desbloqueado");
				
			}else if(!parameter.equals(celular.getPassword())){
				celular.setTimesTried(celular.getTimesTried()+1);
				System.out.println("Intento Fallido");
				if(celular.getTimesTried()>=3){
					celular.setLocalTime(time.now());
				}			
			}else if(celular.getTimesTried()>=3){
				if(celular.getDistance(celular.getTime(),time.now())>=celular.getTimeToWait()){
					celular.setTimesTried(0);
					handle(action,parameter,celular);
				}else{
					System.out.println("Falta "+ (10-celular.getSeconds()) +" segundos");
				}
			}
		}
	}

}
