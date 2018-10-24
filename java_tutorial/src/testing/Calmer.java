package testing;

import generics.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Calmer {
    private static final HashSet<String> MUTUALLY_ANTAGONISTIC = new HashSet<>();
    static {
        MUTUALLY_ANTAGONISTIC.add("Republican");
        MUTUALLY_ANTAGONISTIC.add("Democrat");
    };

    public static String calmSpeech(String speech) {
        return speech.replace("!", "");
    }

    public static List<String> calmAudience(List<String> invitees) {
        final Map<Boolean, List<String>> partitioned = invitees.stream()
                .collect(Collectors.groupingBy(MUTUALLY_ANTAGONISTIC::contains));
        final List<String> reasonable = partitioned.getOrDefault(false, new ArrayList<>());
        final String belligerent = partitioned.getOrDefault(true, new ArrayList<>()).get(0);
        if (belligerent != null) {
            reasonable.add(belligerent);
        }
        return reasonable;
    }
}
