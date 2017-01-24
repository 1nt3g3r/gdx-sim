package com.integer.gdx.sim.process;

import com.integer.gdx.sim.Simulator;

public abstract class TickProcess {
    protected Simulator simulator;
    protected boolean enabled = true;

    public void init(Simulator simulator) {
        this.simulator = simulator;
    };

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void destroy() {

    };

    public void tick() {
        if (enabled) {
            update();
        }
    };

    public abstract void update();
}
