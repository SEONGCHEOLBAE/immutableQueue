package com.queueTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import com.queue.ImmutableQueue;
import com.queue.Queue;

class ImmutableQueueTest {

	private ArrayList<Integer> testValues = 
			new ArrayList<Integer>(Arrays.asList(1, 20, 300, 4000, 50000, 600000, 7000000, 80000000, 900000000));
	
	@Test
	void testImmutableQueue() {
		Queue<Integer> queue = new ImmutableQueue<Integer>();
		assertNotNull(queue);
	}
	
	@Test
	void testIsEmpty() {
		Queue<Integer> queue = new ImmutableQueue<Integer>();
		assertTrue(queue.isEmpty());
		queue = queue.enQueue(testValues.get(0));
		assertFalse(queue.isEmpty());
	}


	@Test
	void testEnQueue() {
		Queue<Integer> queue = new ImmutableQueue<Integer>();
		for (Integer i : testValues) {
			queue = queue.enQueue(i);
			assertTrue(new ImmutableQueue<Integer>() != queue);
			assertEquals(i, queue.head());
			System.out.println("EnQueue: " + queue.head()); // if you checked value
		}
	}

	@Test
	void testDeQueue() {
		int defaultTest = 0;
		int deQueueTestFirst = testValues.get(0);
		int deQueueTestSecond = testValues.get(1);
		Queue<Integer> queue = new ImmutableQueue<Integer>();

		queue = queue.enQueue(deQueueTestFirst);
		System.out.println("DnQueue: " + queue.head()); // if you checked value
		queue = queue.enQueue(deQueueTestSecond);
		System.out.println("DnQueue: " + queue.head()); // if you checked value
		queue = queue.deQueue(); // head and next has data
		System.out.println("DnQueue: " + queue.head()); // if you checked value
		assertEquals(deQueueTestFirst, queue.head());
		queue = queue.deQueue(); // head only has data
		assertTrue(queue.isEmpty());
	}

	@Test
	void testHead() {
		Queue<Integer> queue = new ImmutableQueue<Integer>();
		for (Integer i : testValues) {
			queue = queue.enQueue(i);
		}
		assertEquals(testValues.get(testValues.size() - 1), queue.head());
		
	}

}
