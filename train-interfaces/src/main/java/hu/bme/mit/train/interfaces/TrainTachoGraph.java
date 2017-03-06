package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;

/**
 * Created by meres on 3/6/17.
 */
public interface TrainTachoGraph {

    public void addData(int joystickPosition, int referenceSpeed);

    public Table<Long, Integer, Integer> getData();
}
