package com.almundo.domain.type;

/**
 * The role employee enum
 * @author emilio.watemberg
 *
 */
public enum Type {
	
	OPERATOR(0, "OPERADOR"),
	SUPERVISOR(1, "SUPERVISOR"),
	DIRECTOR(2, "DIRECTOR");
	
	private Integer priority;
	private String name;
	
	private Type(int priority, String name) {
		this.priority = priority;
		this.name = name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
