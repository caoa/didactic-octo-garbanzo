package caoa.dog;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Xul {

    private Xul() {
    }

    public static List<Map.Entry<String, List<String>>> regroup(Collection<String> values, Predicate<String> predicate) {
        BiConsumer<Deque<List<String>>, String> biConsumer = (deque, s) -> {
            if (predicate.test(s)) {
                deque.add(new ArrayList<>());
            }
            if (!deque.isEmpty()) {
                deque.getLast().add(s);
            }
        };
        Deque<List<String>> res = values.stream().collect(ArrayDeque::new, biConsumer, Queue::addAll);
        return res.stream().map(strings -> new AbstractMap.SimpleImmutableEntry<>(strings.get(0), strings.subList(1, strings.size()))).collect(Collectors.toList());
    }

}
