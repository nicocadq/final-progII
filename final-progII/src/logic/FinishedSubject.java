package logic;

public class FinishedSubject {

	private int mark;
	
	private Subject subject;

	public FinishedSubject(int mark, Subject subject) {
		super();
		this.mark = mark;
		this.subject = subject;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public Subject getSubject() {
		return this.subject;
	}

}
