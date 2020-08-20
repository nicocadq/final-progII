package logic;

public class Subject {

	private String code;
	private String name;
	private Orientation orientation;
	private Generation generation;

	public Subject(String code, String name, Orientation orientation, Generation generation) {
		super();
		this.code = code;
		this.name = name;
		this.orientation = orientation;
		this.generation = generation;
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

}
