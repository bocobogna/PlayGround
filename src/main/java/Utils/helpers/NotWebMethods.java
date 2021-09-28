package Utils.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NotWebMethods {
    //logger
    static Logger log = LoggerFactory.getLogger(NotWebMethods.class);

    public static List<String> textToWordsList(List<String> list) {
        String text = list.toString().toLowerCase();
        text = text.replaceAll("[!,?.$&%]", "");
        return Arrays.asList(text.split(" "));
    }

    public static List<String> textToLetters(List<String> list) {
        String text = list.toString();
        text = text.replaceAll("\\W", "");
        text = text.replaceAll(" ", "");
        List<String> listToReturn = Arrays.asList(text.split(""));
        listToReturn.removeAll(Arrays.asList(" ", "", null));
        return listToReturn;
    }

    public static Set<String> findDuplicates(List<String> list) {
        return list
                .stream()
                .filter(x -> Collections.frequency(list, x) > 1)
                .collect(Collectors.toSet());
    }

    public static String getFirstDuplicate(List<String> list) {
        HashSet<String> set = new HashSet<>();
        int min = -1;
        for (int i = list.size() - 1; i >= 0; i--)
            if (set.contains(list.get(i)))
                min = i;
            else
                set.add(list.get(i));
        return min == -1 ? "No duplicates" : list.get(min);
    }

    public static Map<String, List<Integer>> getDuplicatesWithIndexes(List<String> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.groupingBy(list::get))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Long> getDuplicatesCount(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(el -> el.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static String getMostPopularElement(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).get();
    }
}
