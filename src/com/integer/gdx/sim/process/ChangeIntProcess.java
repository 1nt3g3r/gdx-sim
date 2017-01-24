package com.integer.gdx.sim.process;

public class ChangeIntProcess extends TickProcess {
    private String key;
    private int amount;

    public ChangeIntProcess(String key, int amount) {
        this.key = key;
        this.amount = amount;
    }

    @Override
    public void update() {
        simulator.data().changeInt(key, amount);
    }
}
