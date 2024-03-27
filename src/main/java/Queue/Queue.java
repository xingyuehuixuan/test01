package Queue;

public interface Queue<E> {
    /**
     * 向队列尾插入值
     * @param value
     * @return
     */
    boolean offer(E value);

    /**
     * 从队列头获取值，并移除
     * @return
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * @return
     */
    E peek();

    /**
     * 检查队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断队列是否已满
     * @return
     */
    boolean isFull();
}
