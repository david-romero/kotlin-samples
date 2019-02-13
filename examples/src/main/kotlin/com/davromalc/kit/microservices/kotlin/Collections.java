package com.davromalc.kit.microservices.kotlin;

import java.util.*;

import static java.util.Arrays.asList;

public class Collections {

    void testCollections() {
        final List<String> customerNames = new ArrayList<>();
        customerNames.addAll(asList("David", "Carlos", "Juan"));

        final Set<Integer> uniqueNumbers = new HashSet<>(asList(1, 2, 3, 4, 5, 6));

        final Map<Integer,String> customerByAge = new HashMap<>();
        customerByAge.put(28, "David");
        customerByAge.put(21, "Carlos");
        customerByAge.put(32, "Juan");

    }

}
