package telran.interview;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int [] array, int sum) {
        HashSet<Integer> helpers = new HashSet<>();
        int index = 0;
        while(index < array.length && !helpers.contains(sum - array[index])) {
            helpers.add(array[index++]);
        }
        return index < array.length;
    }


    static public int getMaxWithNegativePresentation(int [] array) {
        HashSet<Integer> set = new HashSet<>();
        int res = -1;
        for(int num:array){
            int absNum = Math.abs(num);
            if (set.contains(-num)) {
                res = Math.max(res, absNum);
            }
            set.add(num);
        }
        return res;
    }


    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {
        Map<LocalDate, String> roleMap = new HashMap<>();
        for (DateRole role : rolesHistory) {
            roleMap.put(role.date(), role.role());
        }

        return dates.stream()
            .map(date -> {
                String lastKnownRole = roleMap.entrySet().stream()
                    .filter(entry -> !entry.getKey().isAfter(date))
                    .map(Map.Entry::getValue)
                    .reduce((first, second) -> second)
                    .orElse(null);
                return new DateRole(date, lastKnownRole);
            })
            .collect(Collectors.toList());
    }

    public static boolean isAnagram(String word, String anagram) {
        Map<Character, Integer> charCount = new HashMap<>();
        int j=0;
        if (!word.equals(anagram)) {
            for (char ch : anagram.toCharArray()) {
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            }

            while (j<word.length()&& charCount.containsKey(word.charAt(j)) && charCount.get(word.charAt(j)) > 0) {
                charCount.put(word.charAt(j), charCount.get(word.charAt(j))- 1);
                j++;
            }
        }
        return anagram.length()>0&&j==word.length()&&word.length()>0;
    }
    
}