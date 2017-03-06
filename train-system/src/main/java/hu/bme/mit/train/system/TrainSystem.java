package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.controller.TrainEmergencyBreakImpl;
import hu.bme.mit.train.interfaces.*;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.tachograph.TrainTachoGraphImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

    private TrainTachoGraph tachoGraph = new TrainTachoGraphImpl();
    private TrainController controller = new TrainControllerImpl(tachoGraph);
    private TrainSensor sensor = new TrainSensorImpl(controller);
    private TrainUser user = new TrainUserImpl(controller);
    private TrainEmergencyBreak emergencyBreak = new TrainEmergencyBreakImpl(controller);


    public TrainController getController() {
        return controller;
    }

    public TrainSensor getSensor() {
        return sensor;
    }

    public TrainUser getUser() {
        return user;
    }

    public TrainEmergencyBreak getEmergencyBreak() {
        return emergencyBreak;
    }

    public TrainTachoGraph getTachoGraph() {
        return tachoGraph;
    }

}
