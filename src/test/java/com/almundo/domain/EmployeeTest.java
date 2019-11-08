package com.almundo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.almundo.domain.type.Type;

@SpringBootTest
public class EmployeeTest {
	
	@Test
	void testComparatorEmployee() {
		Employee director = new Employee(Type.DIRECTOR);
		Employee operator = new Employee(Type.OPERATOR);
		Employee supervisor = new Employee(Type.SUPERVISOR);
		
		int result1 = director.compareTo(operator);
		int result2 = director.compareTo(supervisor);
		assertEquals(1,result1);
		assertEquals(1,result2);
	}

}
