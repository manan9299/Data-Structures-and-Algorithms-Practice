import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {


    }

    public int[][] merge(int[][] intervals) {
        StringBuilder sb = new StringBuilder(10);
        
        if(intervals.length <= 1) return intervals;

        Comparator<int[]> intervalComp = new Comparator<>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        };

        Arrays.sort(intervals, intervalComp);

        ArrayList<ArrayList<Integer>> mergedIntervals = new ArrayList<>();

        int earliestTime = intervals[0][0];
        int latestTime = intervals[0][1];

        ArrayList<Integer> firstInterval = new ArrayList<>();
        firstInterval.add(earliestTime);
        firstInterval.add(latestTime);

        mergedIntervals.add(firstInterval);

        for(int i = 1; i < intervals.length; i++){
            ArrayList<Integer> latestInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            earliestTime = latestInterval.get(0);
            latestTime = latestInterval.get(1);

            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if(curStart > latestTime){
                ArrayList<Integer> newInterval = new ArrayList<>();
                newInterval.add(curStart);
                newInterval.add(curEnd);
                mergedIntervals.add(newInterval);
            } else {
                latestInterval.set(1, Math.max(latestTime, curEnd));
            }
        }

        int[][] result = new int[mergedIntervals.size()][2];

        for(int i = 0; i < mergedIntervals.size(); i++){
            result[i][0] = mergedIntervals.get(i).get(0);
            result[i][1] = mergedIntervals.get(i).get(1);
        }

        return result;
    }
}
