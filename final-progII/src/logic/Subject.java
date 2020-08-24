package logic;

public class Subject {

	private String code;
	private String name;
	private Orientation orientation;
	private Generation generation;
	
	private Teacher teacher;

	public Subject(String code, String name, Orientation orientation, Generation generation, Teacher teacher) {
		super();
		this.code = code;
		this.name = name;
		this.orientation = orientation;
		this.generation = generation;
		this.teacher = teacher;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Generation getGeneration() {
		return generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Teacher getTeacher() {
		return this.teacher;
	}

}
