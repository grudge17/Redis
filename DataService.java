public class DataService {

    // Simulate a slow database query
    public String getDataFromDatabase(String key) {
        try {
            Thread.sleep(3000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data for " + key;
    }

    // Method to get data with caching
    public String getData(String key) {
        Jedis jedis = RedisConnection.getConnection();

        // Check if data is in cache
        if (jedis.exists(key)) {
            System.out.println("Fetching data from cache");
            return jedis.get(key);
        } else {
            System.out.println("Fetching data from database");
            String data = getDataFromDatabase(key);

            // Store data in cache with an expiration time (e.g., 60 seconds)
            jedis.setex(key, 60, data);

            return data;
        }
    }
}
