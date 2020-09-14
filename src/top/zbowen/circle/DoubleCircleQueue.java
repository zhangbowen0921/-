package top.zbowen.circle;

@SuppressWarnings("unchecked")
public class DoubleCircleQueue<E> {

	private int size;
	private E[] elements;
	private int front;

	private static final int DEFAULT_CAPATICY = 10;

	public DoubleCircleQueue() {
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
	 * 从队尾入队
	 * 
	 * @param element
	 */
	public void enQueueRear(E element) {
		// 扩容
		ensureCapaticy();
		elements[index(size++)] = element;
	}

	/**
	 * 从队头入队
	 * 
	 * @param element
	 */
	public void enQueueFront(E element) {
		// 扩容
		ensureCapaticy();
		front = index(-1);
		elements[front] = element;
		size++;
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
		if (index < 0) {
			return index + elements.length;
		}
		return index >= elements.length ? index - elements.length : index;
	}

	/**
	 * 从队头出队
	 * 
	 * @return
	 */
	public E deQueueFront() {
		E e = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return e;
	}

	/**
	 * 从队尾出队
	 * 
	 * @return
	 */
	public E deQueueRear() {
		int index = index(--size);
		E e = elements[index];
		elements[index] = null;
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
