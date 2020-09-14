package top.zbowen.circle;

@SuppressWarnings("unchecked")
public class CircleQueue<E> {

	private int size;
	private E[] elements;
	private int front;

	private static final int DEFAULT_CAPATICY = 10;

	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPATICY];
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
		return size == 0;
	}

	/**
	 * 入队
	 * 
	 * @param element
	 */
	public void enQueue(E element) {
		// 扩容
		ensureCapaticy();
		elements[index(size++)] = element;
	}

	private void ensureCapaticy() {
		if (size < elements.length)
			return;
		int newCapaticy = size + (size >> 1);
		System.out.println("扩容：" + size + "--->" + newCapaticy);
		E[] temp = (E[]) new Object[newCapaticy];
		for (int i = 0; i < size; i++) {
			temp[i] = elements[index(i)];
		}
		elements = temp;
		front = 0;
	}

	private int index(int index) {
		index += front;
		return index >= elements.length ? index - elements.length : index;
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public E deQueue() {
		E e = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return e;
	}

	/**
	 * 获取队列的头元素
	 * 
	 * @return
	 */
	public E front() {
		return elements[front];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Capaticy==").append(elements.length).append(", size==").append(size).append(", front==" + front);
		sb.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				sb.append(", ");
			}
			sb.append(elements[i]);
		}
		sb.append("]");
		return sb.toString();
	}

}
