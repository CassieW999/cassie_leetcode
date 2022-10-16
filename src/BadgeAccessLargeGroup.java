import java.util.*;
/*
  1. sort by time and "exit" first
  2.maxsize, maxgroupname --> string
    for (record : records){
      find the largest group
      if enter: renew
      else exit: pop out
    }
   3. for loop, get the time laps. [find the maxenter and minexit]
   4. return [maxgroupname, time laps]
 */
public class BadgeAccessLargeGroup {
    public static Map<String, List<String[]>> findLargeGroup(String[][] records) {
        Map<String, List<String[]>> res = new HashMap<>();

        String Enter = "enter";
        // sort the records by time and by exit 1 and enter 2;
        Arrays.sort(records, (o1, o2) -> {
            int t1 = Integer.parseInt(o1[1]);
            int t2 = Integer.parseInt(o2[1]);

            if (t1 != t2) {
                return t1 - t2;
            } else {
                return o2[2].compareTo(o1[2]);
            }
        });

        Set<String> finalGroup = new HashSet<>();

        // people currently in the room
        Set<String> curGroup = new HashSet<>();

        int maxSize = 0;
        String maxGroupName = "";
        for (String[] record: records) {
            if (record[2].equalsIgnoreCase(Enter)) {
                String name = record[0];
                curGroup.add(name);
                String groupNames = getGroup(curGroup);

                // check whether final group contains current group
                if (finalGroup.contains(groupNames)) {
                    if (curGroup.size() > maxSize) {
                        maxSize = curGroup.size();
                        maxGroupName = groupNames;
                    }
                } else {
                    // find the intersection
                    for (String people: finalGroup) {
                        Set<String> finalSet = new HashSet<>(Arrays.asList(people.split(",")));
                        try {
                            finalSet.retainAll(curGroup);
                        } catch (NullPointerException e) {
                            System.out.println("Exception thrown : " + e);
                        }

                        // update maxSize and String of names if needed
                        if (finalSet.size() > maxSize) {
                            maxSize = finalSet.size();
                            maxGroupName = getGroup(finalSet);
                        }
                    }
                }
                finalGroup.add(groupNames);
            } else {
                // remove the person from the set
                curGroup.remove(record[0]);
            }
        }

        // above, we find the names string and the intersection
        // in the following part, we should find the time
        curGroup.clear();
        Set<String> maxSet = new HashSet<>(Arrays.asList(maxGroupName.split(",")));
        List<String[]> timeList = new ArrayList<>();
        String lastEnter = "";
        for (String[] record: records) {
            // find the name which is in our max group
            // find the enter status
            String status = record[2];
            if (status.equalsIgnoreCase(Enter)) {
                curGroup.add(record[0]);
                if (maxSet.contains(record[0])) {
                    lastEnter = record[1];
                }
            } else {
                // all members about to leave in the curGroup
                if (curGroup.containsAll(maxSet) && maxSet.contains(record[0])) {
                    timeList.add(new String[] {lastEnter, record[1]});
                }
                curGroup.remove(record[0]);
            }
        }
//        System.out.println(maxSet);
//        for (String[] time: timeList) {
//            System.out.println(Arrays.toString(time));
//        }
        //
        res.put(maxGroupName, timeList);
        return res;
    }

    public static String getGroup(Set<String> curGroup) {
        List<String> list = new ArrayList<>(curGroup);
        Collections.sort(list);
        return String.join(",", list);
    }

    public static void main(String[] args) {
        String[][] records = {
                {"Paul", "1214", "enter"},
                {"Paul", "830", "enter"},
                {"Curtis", "1100", "enter"},
                {"Paul", "903", "exit"},
                {"John", "908", "exit"},
                {"Paul", "1235", "exit"},
                {"Jennifer", "900", "exit"},
                {"Curtis", "1330", "exit"},
                {"John", "815", "enter"},
                {"Jennifer", "1217", "enter"},
                {"Curtis", "745", "enter"},
                {"John", "1230", "enter"},
                {"Jennifer", "800", "enter"},
                {"John", "1235", "exit"},
                {"Curtis", "810", "exit"},
                {"Jennifer", "1240", "exit"},
        };
        //sort(records);
        //for (int i = 0; i < records.length; i++) {
        //for (int j = 0; j < records[i].length; j++) {
        //System.out.print(records[i][j] + " ");
        //}
        //System.out.println();
        //}

        Map<String, List<String[]>> res = findLargeGroup(records); // <Key, value>: <"John;Anna", [[800,900],[1000,1300]]>
        for (String names: res.keySet()) {
            System.out.print(names + ": ");
            for (int i = 0; i < res.get(names).size(); i++){
                String[] times = res.get(names).get(i);
                System.out.print(times[0]);
                System.out.print(" to ");
                System.out.print(times[1] + "; ");
            }
        }

    }
}
