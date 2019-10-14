package stateExample;


public class ClientStateExample {

	public static void main(String[] args) throws InterruptedException {
		IStateExample state = Desbloqueado.getInstance();
		
		Celular celular = new Celular("123",10);//password,timeToWait(after 3 wrong tries)
		celular.setState(state);
		
		celular.request("llamar", "", celular);
		celular.request("jugar", "", celular);
		celular.request("sacarFotos", "", celular);
		
		state =	Bloqueado.getInstance();
		celular.setState(state);
		celular.request("password", "235", celular);
		celular.request("password", "235", celular);
		celular.request("password", "235", celular);
		Thread.sleep(8000);
		celular.request("password", "123", celular);
		Thread.sleep(5000);
		celular.request("password", "123", celular);
		
	}

}
