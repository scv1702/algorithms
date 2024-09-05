import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        HashMap<String, Integer> cache = new HashMap<>();
        TreeMap<Integer, String> accessTimes = new TreeMap<>(); // for lru replacement policy
        int answer = 0;
        int time = 0;
        for (String city: cities) {
            city = city.toLowerCase();
            time += 1;
            if (cacheSize > 0) {
                if (cache.containsKey(city)) { // cache hit
                    answer += 1;
                    // delete previous cache access time
                    int accessTime = cache.get(city);
                    accessTimes.remove(accessTime);
                } else { // cache miss
                    answer += 5;
                    if (cache.size() >= cacheSize) { // replaces cache entry
                        int replaceEntryAcessTime = accessTimes.firstKey();
                        String replaceEntryKey = accessTimes.get(replaceEntryAcessTime);
                        cache.remove(replaceEntryKey);
                        accessTimes.remove(replaceEntryAcessTime);
                    }
                }
                accessTimes.put(time, city);
                cache.put(city, time);
            } else {
                answer += 5;
            }
        }
        return answer;
    }
}
