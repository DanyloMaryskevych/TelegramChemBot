package com.epam.tasks;

import java.util.List;

public class MolConcentration implements Task{
    @Override
    public String message() {
        return "Mol Concentration!";
    }

    @Override
    public String calculate() {
        return null;
    }

    @Override
    public boolean validate(List<String> data) {
        return false;
    }
}
