package availabletimeslots2;

import java.util.ArrayList;

public class AvailableTimeSlots2 {

    public static void main(String[] args) {

        String[][] Times1 = {{"9:00", "10:30"}, {"12:00", "13:00"}, {"16:00", "18:00"}};

        String[][] Times2 = {{"10:00", "11:30"}, {"12:30", "14:30"}, {"14:30", "15:00"}, {"16:00", "17:00"}};
        String[] Available1 = {"9:00", "20:00"};
        String[] Available2 = {"10:00", "18:30"};
        int n = 30;
        //Output: {{"11:30","12:00"}, {"15:00","16:00"},  {"18:00","18:30"}};

        ArrayList<String[]> slots = AvailableTimes(Times1, Times2, Available1, Available2, n);

        for (int i = 0; i < slots.size(); i++) {
            System.out.println(slots.get(i)[0] + " " + slots.get(i)[1]);
        }

        //10:00 -> next open time --> when slot ends
        //600   
    }

    private static ArrayList<String[]> AvailableTimes(String[][] Times1, String[][] Times2, String[] Available1, String[] Available2, int n) {
        ArrayList<String[]> slots = new ArrayList<String[]>();
        String SlotStart;
        String SlotEnd;
        int pointer;
        //get first time
        if (TimeToMins(Available1[0]) > TimeToMins(Available2[0])) {
            SlotStart = Available1[0];
            pointer = TimeToMins(Available1[0]);
        } else {
            pointer = TimeToMins(Available2[0]);
            SlotStart = Available2[0];
        }

        int lastTime;
        //get last time
        if (TimeToMins(Available1[1]) < TimeToMins(Available2[1])) {
            SlotEnd = Available1[1];
            lastTime = TimeToMins(Available1[1]);
        } else {
            lastTime = TimeToMins(Available2[1]);
            SlotEnd = Available2[1];
        }
       String OriginalSlotEnd = SlotEnd;
       
       boolean inSlot = true;
            while (inSlot) {

                inSlot = false;
                for (int i = 0; i < Times1.length; i++) {
                    int LastMins = TimeToMins(Times1[i][1]);
                    int FirstMins = TimeToMins(Times1[i][0]);
                    if (pointer >= FirstMins && pointer <= LastMins) {
                        pointer = LastMins;
                        inSlot = true;
                        SlotStart = Times1[i][1];
                    }
                }
                for (int i = 0; i < Times2.length; i++) {
                    int LastMins = TimeToMins(Times2[i][1]);
                    int FirstMins = TimeToMins(Times2[i][0]);
                    if (pointer >= FirstMins && pointer <= LastMins) {
                        pointer = LastMins;
                        inSlot = true;
                        SlotStart = Times2[i][1];
                    }
                }
                pointer++;
            }
            pointer--;
       while (pointer < lastTime) {
           SlotEnd = OriginalSlotEnd;
            int NextOpenTime = lastTime;
            //get first open time
            for (int i = 0; i < Times1.length; i++) {
                int mins = TimeToMins(Times1[i][0]);
                if (mins >= pointer) {
                    if (mins < NextOpenTime) {
                        NextOpenTime = mins;
                        SlotEnd = Times1[i][0];
                        break;
                    }
                }
            }
            for (int i = 0; i < Times2.length; i++) {
                int mins = TimeToMins(Times2[i][0]);
                if (mins >= pointer) {
                    if (mins < NextOpenTime) {
                        NextOpenTime = mins;
                        SlotEnd = Times2[i][0];
                        break;
                    }
                }
            }
           

            if (NextOpenTime - pointer+1 >= n) {
                slots.add(new String[]{SlotStart, SlotEnd});
            }
pointer = NextOpenTime;
            //
             inSlot = true;
            while (inSlot) {

                inSlot = false;
                for (int i = 0; i < Times1.length; i++) {
                    int LastMins = TimeToMins(Times1[i][1]);
                    int FirstMins = TimeToMins(Times1[i][0]);
                    if (pointer >= FirstMins && pointer <= LastMins) {
                        pointer = LastMins;
                        inSlot = true;
                        SlotStart = Times1[i][1];
                    }
                }
                for (int i = 0; i < Times2.length; i++) {
                    int LastMins = TimeToMins(Times2[i][1]);
                    int FirstMins = TimeToMins(Times2[i][0]);
                    if (pointer >= FirstMins && pointer <= LastMins) {
                        pointer = LastMins;
                        inSlot = true;
                        SlotStart = Times2[i][1];
                    }
                }
                pointer++;
            }
            pointer--;
           //  System.out.println(pointer);
           // pointer--;

        }

        return slots;

    }

    private static int TimeToMins(String time) {
        String[] split = time.split(":");
        int mins = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        return mins;
    }

}
