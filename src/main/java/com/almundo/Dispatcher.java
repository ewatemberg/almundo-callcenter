package com.almundo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.domain.CallMocked;
import com.almundo.domain.Employee;

/**
 * Concurrent Dispatcher Calls
 * 
 * @author emilio.watemberg
 */
public class Dispatcher {

	private static Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	private static long ADDITIONAL_TIME_SEG = 8;

	private ExecutorService executor;
	private PriorityBlockingQueue<Employee> queue;

	/**
	 * Constructor
	 * 
	 * @param concurrentCurrentCalls: init the total concurrent calls
	 * @param employees
	 */
	public Dispatcher(int concurrentCurrentCalls, PriorityBlockingQueue<Employee> employees) {
		this.executor = Executors.newFixedThreadPool(concurrentCurrentCalls);
		this.queue = employees;
	}

	/**
	 * This method dispatch call to first employee available (sorted by priority)
	 * 
	 * @param call
	 * @throws InterruptedException when all employees are busy
	 * @see doc in README.md
	 */
	public void dispatchCall(CallMocked call) throws InterruptedException {
		Employee employee = queue.take();
		executor.submit(asignCall(employee, call));
	}

	/**
	 * This method assign the call to employee and count the total calls
	 * 
	 * @param employee
	 * @param call
	 * @return
	 * @see doc in README.md
	 */
	private Runnable asignCall(Employee employee, CallMocked call) {
		Runnable r = () -> {
			employee.take(call);
			queue.add(employee);
		};
		return r;
	}

	/**
	 * An additional time is added for calls to end. If they do not end, they are interrupted
	 */
	public void shutdown() {
		LOGGER.info("Init Shutdown");
		executor.shutdown();
		try {
			if (!executor.awaitTermination(ADDITIONAL_TIME_SEG, TimeUnit.SECONDS)) {
				LOGGER.error("left unattended calls!");
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			LOGGER.error("Finish Shutdown");
		}
	}

}
