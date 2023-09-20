
public class Time {
	private int hour;
	private int minutes;
	
	public Time(int hour, int minutes) {
		this.hour = hour;
		this.minutes = minutes;
	}

	public int getHour() {
		return hour;
	}

	public int getMinutes() {
		return minutes;
	}
	
	public void addTime(int minutes) {
		if(minutes > 59) {
			this.hour += minutes / 60;
			this.minutes += minutes % 60;
		}
		else {
			this.minutes += minutes;
		}
		
		if(this.minutes >= 60) {
			this.hour += this.minutes/60;
			this.minutes = this.minutes % 60;
		}
	}
	
	public Time clone() {
		return new Time(this.hour, this.minutes);
	}
}
