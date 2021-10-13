package com.epam.tasks;

import java.util.List;

public class MolCalculation implements Task{
    private String compound;
    private float mass;

    @Override
    public String message() {
        return "Please, provide compound and mass (g):";
    }

    @Override
    public String calculate() {
        StringBuilder sb = new StringBuilder();
        float molarMass = CompoundMassTable.map.get(compound);
        float mol = (float) (Math.round((mass / molarMass) * 1000.0) / 1000.0);
        sb.append("Compound: ").append(compound)
                .append(", m = ").append(mass).append(" (g)")
                .append("\nMr = ").append(molarMass).append(" (g/mol)")
                .append("\nn = m/Mr = ").append(mol).append(" (mol)");
        return sb.toString();
    }

    @Override
    public boolean validate(List<String> data) {
        boolean correctCompound = CompoundMassTable.map.containsKey(data.get(0));
        if (correctCompound) compound = data.get(0);
        boolean correctMass = true;
        try {
            mass = Float.parseFloat(data.get(1));
        } catch (Exception e) {
            correctMass = false;
        }

        return correctCompound && correctMass;
    }
}
