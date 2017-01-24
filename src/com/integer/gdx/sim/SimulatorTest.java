package com.integer.gdx.sim;

import com.integer.gdx.sim.process.ChangeIntProcess;

import java.util.Timer;
import java.util.TimerTask;

public class SimulatorTest {
    public static void main(String[] args) {
        final Simulator simulator = new Simulator();

        ChangeIntProcess goldMine = new ChangeIntProcess("gold", 1);
        simulator.addProcess("gold.mine", goldMine);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                simulator.tick();

                System.out.println("Gold: " + simulator.data().getInt("gold"));
            }
        }, 0, 100);
    }
}
