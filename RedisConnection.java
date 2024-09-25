import redis.clients.jedis.Jedis;

public class RedisConnection {
    private static Jedis jedis = null;

    public static Jedis getConnection() {
        if (jedis == null) {
            // Connect to Redis server running on localhost and default port 6379
            jedis = new Jedis("localhost", 6379);
            System.out.println("Connected to Redis");
        }
        return jedis;
    }

    public static void closeConnection() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
