package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Drive extends CommandOpMode {
    private MecanumCommand mecanumCommand;
    CommandScheduler scheduler = CommandScheduler.getInstance();
    Test robot;

    @Override
    public void initialize() {
        robot = new Test("tele", hardwareMap, telemetry);
        mecanumCommand = new MecanumCommand(robot.driveSubsystem, gamepad1, .5);

        waitForStart();
        schedule(mecanumCommand);
    }

//    @Override
//    public void run() {
//        scheduler.run();
//        telemetry.addData("drive command", robot.driveSubsystem.getCurrentCommand());
//        telemetry.addData("LX in opmode", gamepad1.left_stick_x);
////        telemetry.update();
//    }
}
