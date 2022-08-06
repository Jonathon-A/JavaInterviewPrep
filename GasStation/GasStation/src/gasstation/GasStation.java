package gasstation;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int remaining = 0;
        int candidate = 0;
        int prevRemianing = 0;
        //finds candiate station - station that can reach end of array
        //for every station
        for (int i = 0; i < gas.length; i++) {
            //find fuel at station from last valid station
            remaining += gas[i] - cost[i];
            //if below zero then invalid station
            if (remaining < 0) {
                //valid station set to next station
                candidate = i + 1;
                prevRemianing += remaining;
                remaining = 0;
            }

        }
        //adds feul and cost total from previous stations to candidate costs
        if (candidate == gas.length || remaining + prevRemianing < 0) {
            return -1;
        } else {
            return candidate;
        }
    }
}
