package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

public class MecanumCommand extends CommandBase {
    DriveSubsystem driveSubsystem;

    public MecanumCommand(DriveSubsystem driveSubsystem, gamepad1) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        super.execute();
        driveSubsystem.teleDrive(gamepad1, power);
    }
}
