package core.base.concurrent.queue;

import core.base.concurrent.IDriver;
import core.base.concurrent.IQueueDriverAction;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description: 消息驱动器
 * User: Boiling
 * Date: 2018-07-03
 * Time: 20:40
 */
@Slf4j
public class MessageDriver implements IDriver {

    /**
     * 队列最大数量
     */
    private int maxQueueSize;
    /**
     * 驱动名称
     */
    private String name;

    /**
     * 消息队列
     */
    private final IMessageQueue<IQueueDriverAction> queue;

    public MessageDriver(String name, int maxQueueSize) {
        this.name = name;
        this.maxQueueSize = maxQueueSize;
        this.queue = new MessageQueue<IQueueDriverAction>();
        this.queue.setName(name);
    }

    /**
     * 添加一个行为到队列中
     *
     * @param action action
     */
    @Override
    public boolean addAction(IQueueDriverAction action) {
        boolean result;
        synchronized (queue) {
            result = queue.offer(action);
            if (result) {
                // 设置action的queue属性
                action.setActionQueue(queue);
            } else {
                log.error("{}队列添加任务失败",name);
            }
        }
        return result;
    }

    @Override
    public IMessageQueue<IQueueDriverAction> getActions() {
        return queue;
    }

}