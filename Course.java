
public class Course{
	private String id;
	private String title;
	private double credit;
	private int sectionCount;
	private int[] timeSlots;
	private TimeSlot timeSlot;
	
	public Course(String id, String title, double credit, int sectionCount, int[] timeSlots) {
		this.id = id;
		this.title = title;
		this.credit = credit;
		this.sectionCount = sectionCount;
		this.timeSlots = timeSlots;
	}
	
	public Course(String id, String title, double credit, TimeSlot timeSlot) {
		this.id = id;
		this.title = title;
		this.credit = credit;
		this.timeSlot = timeSlot;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public int getSectionCount() {
		return sectionCount;
	}

	public void setSectionCount(int sectionCount) {
		this.sectionCount = sectionCount;
	}
	
	public int[] getTimeSlots() {
		return this.timeSlots;
	}
	
	public TimeSlot getTimeSlot() {
		return this.timeSlot;
	}
	
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Course clone(TimeSlot timeSlot) {
		Course course = new Course(this.getId(), this.getTitle(), this.getCredit(), timeSlot);
		return course;
	}
}