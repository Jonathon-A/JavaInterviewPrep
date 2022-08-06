package availabletimetableslots;

import java.util.ArrayList;

public class AvailableTimeTableSlots {
//Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    public static void main(String[] args) {

        String[][] Times1 = {{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};
        String[] Available1 = {"9:00", "20:00"};
        String[][] Times2 = {{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] Available2 = {"10:00", "18:30"};
        //Output: {{"11:30","12:00"}, {"15:00","16:00"},  {"18:00","18:30"}};
        int n = 30;
        String[][] Output = AvailableTimes(Times1, Available1, Times2, Available2, n);
        for (int i = 0; i < Output.length; i++) {

            System.out.print("[" + Output[i][0] + "," + Output[i][1] + "],");

        }
        //Output: {{"11:30","12:00"}, {"15:00","16:00"},  {"18:00","18:30"}};
    }

    private static String[][] AvailableTimes(String[][] Times1, String[] Available1, String[][] Times2, String[] Available2, int n) {
        int[][] Times1Mins = new int[Times1.length][2];
        for (int i = 0; i < Times1.length; i++) {
            Times1Mins[i] = ToMins(Times1[i]);
        
        }
        int[] Available1Mins = ToMins(Available1);

        
        int[][] Times2Mins = new int[Times2.length][2];
        for (int i = 0; i < Times2.length; i++) {
            Times2Mins[i] = ToMins(Times2[i]);
         
        }

        int[] Available2Mins = ToMins(Available2);

        ArrayList<int[]> BothMins = new ArrayList<>();
        for (int i = 0; i < Times1Mins.length; i++) {
            BothMins.add(Times1Mins[i]);
        }
        for (int i = 0; i < Times2Mins.length; i++) {
            BothMins.add(Times2Mins[i]);
        }

        ArrayList<int[]> ReturnedTimes = new ArrayList<>();

        int CurrentTime = Math.max(Available1Mins[0], Available2Mins[0]);
        
        while (CurrentTime <= Math.min(Available1Mins[1], Available2Mins[1])) {
            int MaxTime = -1;
            // System.out.println("s " + Start);
            //find time slots current is in - find latest end time from them slots
            for (int i = 0; i < BothMins.size(); i++) {

                if (CurrentTime >= BothMins.get(i)[0] && CurrentTime <= BothMins.get(i)[1]) {
                    if (BothMins.get(i)[1] > MaxTime) {
                        MaxTime = BothMins.get(i)[1];
                    }
                }
            }
        
            int Time1 = Math.min(Available1Mins[1], Available2Mins[1]);
            //if current not in a slot - get min start time above current time
            if (MaxTime == -1) {
                int j = 0;
                for (int i = 0; i < BothMins.size(); i++) {
                    if (CurrentTime <= BothMins.get(i)[0] && BothMins.get(i)[0] <= Time1) {
                        Time1 = BothMins.get(i)[0];
                        j = i;
                    }
                }
                //if slot more than n mins add to returnd list
                if (Time1 - (CurrentTime - 1) >= n) {
                    int[] newTime = new int[2];
                    newTime[0] = CurrentTime - 1;
                    newTime[1] = Time1;
                    ReturnedTimes.add(newTime);
                }
                //Current time = next minute after slot
                CurrentTime = Time1 + 1;

            } else {
                //Current time = next minute after latest end time from them slots
                CurrentTime = MaxTime + 1;
            }

        }
        String[][] ReturnedTimesString = new String[ReturnedTimes.size()][2];
        for (int i = 0; i < ReturnedTimes.size(); i++) {

            String[] Slot = new String[2];
            Slot[0] = (ReturnedTimes.get(i)[0] / 60) + ":";
            if ((ReturnedTimes.get(i)[0] % 60) == 0) {
                Slot[0] += "00";
            } else {
                Slot[0] += (ReturnedTimes.get(i)[0] % 60);
            }
            Slot[1] = (ReturnedTimes.get(i)[1] / 60) + ":";
            if ((ReturnedTimes.get(i)[1] % 60) == 0) {
                Slot[1] += "00";
            } else {
                Slot[1] += (ReturnedTimes.get(i)[1] % 60);
            }
            ReturnedTimesString[i] = Slot;
        }

        return ReturnedTimesString;
    }

    private static int[] ToMins(String[] slot) {
        int[] slotMins = new int[2];
        String first = slot[0];
        String[] firstTime = first.split(":");
        slotMins[0] = Integer.valueOf(firstTime[0]) * 60 + Integer.valueOf(firstTime[1]);

        String second = slot[1];
        String[] secondTime = second.split(":");
        slotMins[1] = Integer.valueOf(secondTime[0]) * 60 + Integer.valueOf(secondTime[1]);

        return slotMins;
    }
}
