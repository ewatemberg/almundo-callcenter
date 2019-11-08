package com.almundo;

import java.util.concurrent.PriorityBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.almundo.domain.CallMocked;
import com.almundo.domain.Employee;
import com.almundo.domain.type.Type;

@SpringBootApplication
public class CallCenterApplication implements CommandLineRunner {

	private static Logger LOGGER = LoggerFactory.getLogger(CallCenterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CallCenterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("INIT APP EXAMPLE WITH 10 CALLS");
		Dispatcher dispatcher = new Dispatcher(10, getMockListEmployees());
		LOGGER.info("distpatch calls");
		for (int i = 0; i < 10; i++) {
			dispatcher.dispatchCall(new CallMocked());
		}
		dispatcher.shutdown();
	}

	private static PriorityBlockingQueue<Employee> getMockListEmployees() {
		PriorityBlockingQueue<Employee> list = new PriorityBlockingQueue<Employee>();
		LOGGER.info("Adding operators...");
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		list.add(new Employee(Type.OPERATOR));
		LOGGER.info("Adding supervisors...");
		list.add(new Employee(Type.SUPERVISOR));
		list.add(new Employee(Type.SUPERVISOR));
		LOGGER.info("Adding director...");
		list.add(new Employee(Type.DIRECTOR));
		return list;
	}

}
