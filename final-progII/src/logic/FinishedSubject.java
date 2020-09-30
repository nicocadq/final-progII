package logic;

public class FinishedSubject {

	private int mark;
	
	private String subjectCode;

	public FinishedSubject(int mark, String subjectCode) {
		this.mark = mark;
		this.subjectCode = subjectCode;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	public String getSubjectCode() {
		return this.subjectCode;
	}

}
