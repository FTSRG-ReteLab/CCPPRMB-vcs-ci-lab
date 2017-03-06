package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainEmergencyBreak;

/**
 * Created by meres on 3/6/17.
 */
public class TrainEmergencyBreakImpl implements TrainEmergencyBreak {

    private TrainController controller;
    private int previousSpeedLimit;

    public TrainEmergencyBreakImpl(TrainController controller) {
        this.controller = controller;
        this.previousSpeedLimit = controller.getReferenceSpeed();
    }

    @Override
    public void doEmergencyBreak() {
        controller.setSpeedLimit(0);
    }

    @Override
    public void releaseEmergencyBreak() {
        controller.setSpeedLimit(previousSpeedLimit);
    }
}
