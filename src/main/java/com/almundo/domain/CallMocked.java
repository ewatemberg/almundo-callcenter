package com.almundo.domain;

import java.util.Random;

/**
 * This class simulate be a call with time between 5 and 10 seg.
 * @author emilio.watemberg
 */
public class CallMocked {
	
	private static final Integer MIN = 5;
	private static final Integer MAX = 10;
	private Integer time;
	
	public CallMocked() {
		Random rn = new Random();
		int range = MAX - MIN + 1;
		int random =  rn.nextInt(range) + MIN;
		time = random;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}
	
}
