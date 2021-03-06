package core.base.serviceframe;

import core.network.ServiceState;

public interface IService {
    /**
     * init
     * @param args 输入参数
     */
    void init(String[] args);

    /**
     * start
     */
    void start();

    /**
     * stop
     */
    void stop();

    /**
     * update
     */
    void update(long dt);

    /**
     * 获取当前服务的状态
     *
     * @return ServiceState
     */
    ServiceState getState();

    /**
     * 是否已开启
     *
     * @return boolean
     */
    default boolean isOpened() {
        return getState() == ServiceState.RUNNING;
    }

    /**
     * 是否已关闭
     *
     * @return boolean
     */
    default boolean isClosed() {
        return getState() == ServiceState.STOPPED;
    }
}
