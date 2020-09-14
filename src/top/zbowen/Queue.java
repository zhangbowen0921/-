package top.zbowen;

import java.util.Stack;

public class Queue<E> {

	private Stack<E> inStack;
	private Stack<E> outStack;
	private int size;
	
	public Queue() {
		this.inStack = new Stack<E>();
		this.outStack = new Stack<E>();
	}

	/**
	 * 元素的数量
	 * 
	 * @return
	 */
	public int size() {
		return size;

	}

	/**
	 * 是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size==0;
	}

	/**
	 * 入队
	 * 
	 * @param element
	 */
	public void enQueue(E element) {
		inStack.push(element);
		size++;
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public E deQueue() {
		size--;
		if (outStack.isEmpty()) {
			change();
			return outStack.pop();
		}else {
			return outStack.pop();
		}
	}

	/**
	 * 获取队列的头元素
	 * 
	 * @return
	 */
	public E front() {
		if (outStack.isEmpty()) {
			change();
			return outStack.peek();
		}else {
			return outStack.peek();
		}
	}

	/**
	 * 清空
	 */
	public void clear() {
		inStack.clear();
		outStack.clear();
		size = 0;
	}
	
	private void change() {
		while (!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}
	}

}
