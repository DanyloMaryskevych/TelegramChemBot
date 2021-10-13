package com.epam.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompoundMassTable {
    public static Map<String, Float> map = Stream.of(new Object[][]{
            {"NaCl", 58.5f},
            {"KCl", 74.5f},
            {"AgNO3", 170f},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Float) data[1]));
}
