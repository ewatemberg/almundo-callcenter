package com.almundo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.domain.type.Type;

/**
 * The employee domain
 * @author emilio.watemberg
 */
public class Employee implements Comparable<Employee> {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	
	private Type type;
		
	public Employee(Type type) {
		super();
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public void take(CallMocked call) {
		LOGGER.info("Hello, how can i help you...");
		try {
			Thread.sleep(call.getTime() * 1000);
		} catch (InterruptedException e) {
			LOGGER.warn("We had a problem with the call, it was interrupted!");
		}
		LOGGER.info("Finish call.");
	}

	@Override
	public int compareTo(Employee e) {
		return this.getType().getPriority().compareTo(e.getType().getPriority());
	}

}
