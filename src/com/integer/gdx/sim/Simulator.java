package com.integer.gdx.sim;


import com.badlogic.gdx.utils.ObjectMap;
import com.integer.gdx.sim.process.TickProcess;

public class Simulator {
    private Data data = new Data();
    private ObjectMap<String, TickTimer> timers = new ObjectMap<String, TickTimer>();
    private ObjectMap<String, TickProcess> processes = new ObjectMap<String, TickProcess>();

    public void tick() {
        for(TickTimer timer : timers.values()) {
            timer.tick();
        }

        for(TickProcess process : processes.values()) {
            process.tick();
        }
    }

    public Data data() {
        return data;
    }

    public TickTimer getTimer(String name) {
        if (!timers.containsKey(name)) {
            timers.put(name, new TickTimer());
        }
        return timers.get(name);
    }

    public void removeTimer(String name) {
        timers.remove(name);
    }

    public TickProcess getProcess(String name) {
        return processes.get(name);
    }

    public void addProcess(String name, TickProcess process) {
        process.init(this);
        processes.put(name, process);
    }

    public void removeProcess(String name) {
        if (processes.containsKey(name)) {
            processes.get(name).destroy();
        }
        processes.remove(name);
    }
}
