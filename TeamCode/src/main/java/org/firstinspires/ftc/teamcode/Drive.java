package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Drive extends CommandOpMode {

    @Override
    public void initialize() {
        Test robot = new Test("tele", hardwareMap, telemetry);

        Command driveCommand = new InstantCommand(() -> {
            robot.driveSubsystem.teleDrive(() -> gamepad1.left_stick_x, () -> gamepad1.left_stick_y, ()-> gamepad1.right_stick_y, .5);
        });

        schedule(driveCommand);
        telemetry.addData("command scheduled", "now");
        telemetry.update();
    }
}
