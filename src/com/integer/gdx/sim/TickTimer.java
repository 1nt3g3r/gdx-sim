package com.integer.gdx.sim;

public class TickTimer {
    private int tickCount;
    private int elapsedTickCount;
    private boolean enabled = true;

    public void tick() {
        if (enabled && elapsedTickCount > 0) {
            elapsedTickCount--;
        }
    }

    public void start(int tickCount) {
        this.tickCount = tickCount;
        this.elapsedTickCount = tickCount;
    }

    public void reset() {
        elapsedTickCount = 0;
    }

    public void change(int tickAmount) {
        elapsedTickCount += tickAmount;
    }

    public boolean isFinished() {
        return elapsedTickCount <= 0;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
