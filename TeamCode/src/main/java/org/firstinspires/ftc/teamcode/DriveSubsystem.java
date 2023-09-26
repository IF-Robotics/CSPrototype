package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DriveSubsystem extends SubsystemBase {

    private DcMotor BL;
    private DcMotor BR;
    private DcMotor FL;
    private DcMotor FR;

    /*public static final int right = 1;
    public static final int left = -1;
    public static final int forward = 1;
    public static final int LEFT = -1;*/

    public enum Direction {
        left,
        right,
        forward,
        backward
    }
    private Direction dir = Direction.forward;

    private double power;
    private DcMotor.RunMode runMode = DcMotor.RunMode.RUN_USING_ENCODER;

    public DriveSubsystem(DcMotor BL, DcMotor BR, DcMotor FL, DcMotor FR) {
        this.BL = BL;
        this.BR = BR;
        this.FL = FL;
        this.FR = FR;

        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setRunMode(DcMotor.RunMode runMode) {
        this.runMode = runMode;
    }

    public void drive(double power, Direction dir) {
        this.power = power;
        this.dir = dir;

        if(dir == Direction.backward || dir == Direction.left) {
            this.power *= -1;
        }
    }

    @Override
    public void periodic() {
        if(BL.getMode() != runMode) {
            BL.setMode(runMode);
            BR.setMode(runMode);
            FL.setMode(runMode);
            FR.setMode(runMode);
        }

        if(runMode == DcMotor.RunMode.RUN_USING_ENCODER) {
            if(dir == Direction.left || dir == Direction.right) {
                BL.setPower(power);
                BR.setPower(-power);
                FL.setPower(-power);
                FR.setPower(power);
            } else {
                BL.setPower(power);
                BR.setPower(power);
                FL.setPower(power);
                FR.setPower(power);
            }
        }
    }
}