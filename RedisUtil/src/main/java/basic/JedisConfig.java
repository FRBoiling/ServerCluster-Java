package basic;

import lombok.Getter;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConfig {

    private String ip;

    public String getIp() {
        return ip;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    private String password;
    private int port;

    public int getDbNum() {
        return dbNum;
    }

    public void setDbNum(int dbNum) {
        this.dbNum = dbNum;
    }

    private int dbNum;

    @Getter
    private int connectionTimeout=2000;

    @Getter
    private int soTimeout=2000;

    @Getter
    private int attempts=10;

    public boolean init(String ip,String pw,int port,int dbNum){
        this.ip=ip;
        this.password=pw;
        this.port=port;
        setDbNum(dbNum);

        return true;
    }
}
