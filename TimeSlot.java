
public class TimeSlot {
	
	private String day;
	private Time startTime;
	private Time endTime;
	
	public TimeSlot(String day, Time startTime, Time endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public static boolean checkTimeClash(TimeSlot t1, TimeSlot t2) {
		int m1 = t1.startTime.getHour() * 60 + t1.startTime.getMinutes();
		int m2 = t1.endTime.getHour() * 60 + t1.endTime.getMinutes();
		int m3 = t2.startTime.getHour() * 60 + t2.startTime.getMinutes();
		int m4 = t2.endTime.getHour() * 60 + t2.endTime.getMinutes();
		
		if(!t1.day.equals(t2.day))
			return false;
		
		if(m3 >= m1 && m3 <= m2) {
			return true;
		}
		else if(m4 >= m1 && m4 <= m2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return (this.getStartTime().getHour() < 10 ? "0"+this.getStartTime().getHour() : this.getStartTime().getHour()) + ":" + (this.getStartTime().getMinutes() < 10 ? "0"+this.getStartTime().getMinutes() : this.getStartTime().getMinutes()) + " - " + (this.getEndTime().getHour() < 10 ? "0"+this.getEndTime().getHour() : this.getEndTime().getHour()) + ":" + (this.getEndTime().getMinutes() < 10 ? "0"+this.getEndTime().getMinutes() : this.getEndTime().getMinutes()) + " " + this.getDay();
	}
}
