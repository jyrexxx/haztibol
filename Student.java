package ass;

public class Student {
	String id;
	String name;
	String major;

	public Student (String id, String name, String major) {
		this.id = id;
		this.name = name;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
	public String getMajor() {
		return major;
	}

	@Override
	public String toString() {
		return "Student ID: " + id + " | Student: " + name + " | Major: " + major;
	}
}