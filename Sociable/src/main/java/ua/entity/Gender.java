package ua.entity;



public enum Gender {
	
	MALE("Man",0),FEMALE("Woman",1);

	private String description;
	private int id;

	private Gender(String description, int id) {
		this.description = description;
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	 public String getValue() {
	        return name();
	    }

	 public void setValue(String value) {}

	public int getId() {
		return id;
	}

	 
}
