package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

public class MecanumCommand extends CommandBase {
    DriveSubsystem driveSubsystem;
    private double power = 0;
    private Gamepad gamepad1;

    public MecanumCommand(DriveSubsystem driveSubsystem, Gamepad gamepad1, double power) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
        this.power = power;
        this.gamepad1 = gamepad1;
    }

    @Override
    public void execute() {
        driveSubsystem.teleDrive(gamepad1, power);
//        telemetry.addLine("mecanum command runnning");
//        telemetry.update();
    }
}
