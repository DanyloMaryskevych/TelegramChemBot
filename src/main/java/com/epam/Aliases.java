package com.epam;

import com.epam.tasks.MolCalculation;
import com.epam.tasks.MolConcentration;
import com.epam.tasks.Task;

import java.util.HashMap;
import java.util.Map;

public class Aliases {
    private static Map<String, Task> classMap;

    public Aliases() {
        classMap = new HashMap<>();
        classMap.put("/mol", new MolCalculation());
        classMap.put("/molConc", new MolConcentration());
    }

    public static Map<String, Task> getMap() {
        return classMap;
    }
}
