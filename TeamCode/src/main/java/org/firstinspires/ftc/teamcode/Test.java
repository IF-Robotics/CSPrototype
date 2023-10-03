package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Test {
    public enum Opmode {
        Teleop, Auto
    }

    public DcMotor BL = null;
    public DcMotor BR = null;
    public DcMotor FL = null;
    public DcMotor FR = null;
    private HardwareMap hardwareMap;

    public DriveSubsystem driveSubsystem;

    public Test(/*Opmode mode*/ String mode, HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        if(/*mode == Opmode.Teleop*/ mode == "tele") {
            initTele();
        } else {
            initAuto();
        }
        driveSubsystem = new DriveSubsystem(BL, BR, FL, FR, telemetry);
    }

    private void initTele() {
//        CommandScheduler schduler = CommandScheduler.getInstance();
//        schduler.reset();

        BL = hardwareMap.get(DcMotor.class, "BL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class, "FR");

        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);

//        schduler.registerSubsystem(driveSubsystem);
//        schduler.run();
    }

    private void initAuto() {
        CommandScheduler schduler = CommandScheduler.getInstance();
    }
}
