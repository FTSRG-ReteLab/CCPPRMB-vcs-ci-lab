package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainTachoGraph;

import java.util.Date;

/**
 * Created by meres on 3/6/17.
 */
public class TrainTachoGraphImpl implements TrainTachoGraph{

    private Table<Long, Integer, Integer> tachoGraphData = HashBasedTable.create();

    public TrainTachoGraphImpl() {
    }

    @Override
    public void addData(int joystickPosition, int referenceSpeed){
        tachoGraphData.put(new Date().getTime(), joystickPosition, referenceSpeed);
    }

    @Override
    public Table<Long, Integer, Integer> getData(){
        return tachoGraphData;
    }
}
