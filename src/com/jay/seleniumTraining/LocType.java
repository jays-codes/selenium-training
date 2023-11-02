package com.jay.seleniumTraining;

public enum LocType {
	ID("ID"),
	CSS("CSS"),
	XPATH("XPATH");
	
	private final String type;
	
	LocType(final String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
