package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Drive extends CommandOpMode {

    @Override
    public void initialize() {
        Test robot = new Test("tele", hardwareMap, telemetry);

        Command driveCommand = new InstantCommand(() -> {
<<<<<<< Updated upstream
            robot.driveSubsystem.teleDrive(() -> (double) gamepad1.left_stick_x, () -> (double) gamepad1.left_stick_y, ()-> (double) gamepad1.right_stick_y, .5);
=======
            robot.driveSubsystem.teleDrive(gamepad1, .5);
>>>>>>> Stashed changes
        });

        schedule(driveCommand);
        telemetry.addData("command scheduled", "now");
        telemetry.addData("LX in opmode", gamepad1.left_stick_x);
        telemetry.update();
    }
}
