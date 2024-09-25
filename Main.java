public class Main {
    public static void main(String[] args) {
        DataService dataService = new DataService();

        // First call - should fetch from database
        String result1 = dataService.getData("user:1");
        System.out.println(result1);

        // Second call - should fetch from cache
        String result2 = dataService.getData("user:1");
        System.out.println(result2);

        // Close Redis connection
        RedisConnection.closeConnection();
    }
}
