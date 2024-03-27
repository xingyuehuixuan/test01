package Stack;

public interface Stack<E> {
    /**
     * 向栈顶压入元素
     * @param value
     * @return
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return
     */
    E pop();

    /**
     * 返回栈顶元素，不弹出
     * @return
     */
    E peek();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * @return
     */
    boolean isFull();
}
