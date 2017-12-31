package ua.filter;

import java.time.LocalDate;

public class FriendFilter {

	private String name = "";
	
	private String secondname = "";
	
	private LocalDate min;
	
	private LocalDate max;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public LocalDate getMin() {
		return min;
	}

	public void setMin(LocalDate min) {
		this.min = min;
	}

	public LocalDate getMax() {
		return max;
	}

	public void setMax(LocalDate max) {
		this.max = max;
	}
	
	
}
