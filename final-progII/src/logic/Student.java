package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {

	private Orientation orientation;
	private Status status;
	private Generation generation;

	private List<Absence> absences;
	private List<Exam> exams;
	private List<FinishedSubject> finishedSubjects;

	public Student(int ci, String name, String lastName, Orientation orientation, Status status, Generation generation,  String mail, String password,  LocalDate dateBirth) {
		super(ci, name, lastName, mail, password, dateBirth);
		this.orientation = orientation;
		this.status = status;
		this.generation = generation;
		this.absences = new ArrayList<Absence>();
		this.exams = new ArrayList<Exam>();
		this.finishedSubjects = new ArrayList<FinishedSubject>();
	}
	
	public Student(int ci) {
		super(ci);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Generation getGeneration() {
		return generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	
	public List<Absence> getAbsences(){
		return this.absences;
	}
	
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public List<Exam> getExams(){
		return this.exams;
	}
	
	public void setFinishedSubjects(List<FinishedSubject> finishedSubjects) {
		this.finishedSubjects = finishedSubjects;
	}
	
	public List<FinishedSubject> getFinishedSubjects(){
		return this.finishedSubjects;
	}
}
