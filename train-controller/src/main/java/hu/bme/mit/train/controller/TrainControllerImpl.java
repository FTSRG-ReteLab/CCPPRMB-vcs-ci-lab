package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainTachoGraph;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;

	private TrainTachoGraph tachoGraph;

	public TrainControllerImpl(TrainTachoGraph tachoGraph) {
		this.tachoGraph = tachoGraph;
	}

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
			if(referenceSpeed+step<0)
				referenceSpeed=0;
			else
			referenceSpeed += step;
		}

		enforceSpeedLimit();
		tachoGraph.addData(step, referenceSpeed);

	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;
		tachoGraph.addData(step, referenceSpeed);
	}

}
