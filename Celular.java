package stateExample;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Celular {
	
	private IStateExample state;
	private String password;
	private int timesTried = 0;
	private int seconds;
	private int timeToWait;
	LocalTime time = LocalTime.now();
	
	public LocalTime getTime(){
		return time;
	}
	
	public void setLocalTime(LocalTime time){
		this.time=time;
	}
	public Celular(String password, int timeToWait) {
		this.password = password;
		this.timeToWait=timeToWait;
	}
	
	public int getTimeToWait(){
		return this.timeToWait;
	}
	
	public IStateExample getState() {
		return state;
	}
	public void setState(IStateExample state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTimesTried() {
		return timesTried;
	}
	public void setTimesTried(int timesTried) {
		this.timesTried = timesTried;
	}
	
	public void request(String action,String parameter,Celular celular){
		state.handle(action,parameter, this);
	}
	
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public int getDistance(LocalTime now, LocalTime celular) {
		seconds=(int) SECONDS.between(now, celular);
		return seconds;
		
	}
}
