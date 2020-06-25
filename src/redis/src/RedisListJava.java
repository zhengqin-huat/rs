import redis.clients.jedis.Jedis;
import java.util.List;
public class RedisListJava {
        public static void main(String[] args) {
            //连接本地的 Redis 服务
            Jedis jedis = new Jedis("localhost");
            System.out.println("连接成功");
            //存储数据到列表中
            jedis.lpush("site-list", "123123");
            jedis.lpush("site-list", "abcdabcd");
            jedis.lpush("site-list", "qwer");
            // 获取存储的数据并输出
            List<String> list = jedis.lrange("site-list", 0 ,2);
            for(int i=0; i<list.size(); i++) {
                System.out.println("列表项为: "+list.get(i));
            }
        }
}
