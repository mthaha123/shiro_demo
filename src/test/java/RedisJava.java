import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisJava {

    @Test
    public void  TestRedis(){
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("服务正在运行："+jedis.ping());
    }
}
