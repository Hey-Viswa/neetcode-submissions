

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // 1. Pair each car's starting position with its speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // 2. Sort cars from closest to target -> farthest from target
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double bottleneckTime = 0.0; // Top of our virtual monotonic stack

        // 3. Walk backward from the finish line
        for (int[] car : cars) {
            double arrivalTime = (double) (target - car[0]) / car[1];

            // Strictly slower than the fleet ahead -> cannot catch up -> new fleet
            if (arrivalTime > bottleneckTime) {
                fleets++;
                bottleneckTime = arrivalTime;
            }
            // Otherwise (arrivalTime <= bottleneckTime), it catches up and merges
        }

        return fleets;
    }
}