package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.Robot;

public class MyRobot extends Robot {
    // enum to specify opmode type
    public enum OpModeType {
        TELEOP, AUTO
    }

    // the constructor with a specified opmode type
    public MyRobot(OpModeType type) {
        if (type == OpModeType.TELEOP) {
            initTele();
        } else {
            initAuto();
        }
    }

    /*
     * Initialize teleop or autonomous, depending on which is used
     */
    public void initTele() {
        // initialize teleop-specific scheduler
        CommandScheduler.getInstance().reset();
        CommandScheduler.getInstance().run();
    }

    public void initAuto() {
        // initialize auto-specific scheduler
        CommandScheduler.getInstance().reset();
        CommandScheduler.getInstance().run();
    }
}
