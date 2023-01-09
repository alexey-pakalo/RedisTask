import redis.clients.jedis.Jedis;

public class RedisExample {
    public static void main(String[] args) {
        // Connect to the Redis server
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connected to Redis");

        // Set a value
        //jedis.set("hello", "world");
        String value = jedis.get("hello");
        System.out.println("Got value: " + value);

        // Close the connection
        jedis.close();
    }
}
