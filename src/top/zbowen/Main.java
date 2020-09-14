package top.zbowen;

import java.util.ArrayList;

import top.zbowen.circle.CircleQueue;
import top.zbowen.circle.DoubleCircleQueue;

public class Main {

	public static void main(String[] args) {
		//testCircleQueue();
		//testDoubleCicleQueue();
		ArrayList<Integer> list =  new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			list.add(i);
		}
		list.add(0, 10);
		list.add(0, 13);
		for (int i : list) {
			System.out.print(i + " ");
		}
		new ArrayList<>(20);
	}

	public static void testDoubleCicleQueue() {
		DoubleCircleQueue<Integer> queue = new DoubleCircleQueue<Integer>(); 
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i+1);
			queue.enQueueRear(i+100);
		}
		System.out.println(queue);
		
		for (int i = 0; i < 3; i++) {
			queue.deQueueFront();
			queue.deQueueRear();
			System.out.println(queue);
		}
		
		queue.enQueueFront(11);
		queue.enQueueFront(12);
		
		while (!queue.isEmpty()) {
			System.out.print(queue.deQueueFront()+" ");
		}
	}
	

	public static void testCircleQueue() {
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		System.out.println(queue);
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue);
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		System.out.println(queue);
		for (int i = 15; i < 26; i++) {
			queue.enQueue(i);
			System.out.println(queue);
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.deQueue()+" ");
		}
	}
}
