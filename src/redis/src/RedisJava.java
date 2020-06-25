import redis.clients.jedis.Jedis;
public class RedisJava {
    public static void main(String[] args) {
        //连接本地Redis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

}
