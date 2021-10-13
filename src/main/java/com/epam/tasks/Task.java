package com.epam.tasks;

import java.util.List;

public interface Task {
    String message();

    String calculate();

    boolean validate(List<String> data);
}
