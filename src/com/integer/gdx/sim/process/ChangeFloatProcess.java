package com.integer.gdx.sim.process;

public class ChangeFloatProcess extends TickProcess {
    private String key;
    private float amount;

    public ChangeFloatProcess(String key, float amount) {
        this.key = key;
        this.amount = amount;
    }

    @Override
    public void update() {
        simulator.data().changeFloat(key, amount);
    }
}
