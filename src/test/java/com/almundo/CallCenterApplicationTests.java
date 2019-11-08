package com.almundo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.PriorityBlockingQueue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.almundo.domain.CallMocked;
import com.almundo.domain.Employee;
import com.almundo.domain.type.Type;

@SpringBootTest
class CallCenterApplicationTests {

	@Test
	void test10ConcurrentCalls() throws InterruptedException {
		PriorityBlockingQueue<Employee> list = getMockListEmployees();
		Dispatcher dispatcher = new Dispatcher(10,list);
		for(int i = 0; i<10; i++) {
			dispatcher.dispatchCall(new CallMocked());
		}		
		dispatcher.shutdown();
	}
	
	@Test
	void test20ConcurrentCalls() throws InterruptedException {
		PriorityBlockingQueue<Employee> list = getMockListEmployees();
		Dispatcher dispatcher = new Dispatcher(10,list);
		for(int i = 0; i<20; i++) {
			dispatcher.dispatchCall(new CallMocked());
		}		
		dispatcher.shutdown();
	}
	
	private static PriorityBlockingQueue<Employee> getMockListEmployees() {
		PriorityBlockingQueue<Employee> list = new PriorityBlockingQueue<Employee>();
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.SUPERVISOR));
		list.add(new Employee(Type.SUPERVISOR));
		list.add(new Employee(Type.DIRECTOR));
		return list;
	}

}
