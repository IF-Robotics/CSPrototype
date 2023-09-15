package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Teleop extends LinearOpMode {

    public DcMotor BL = null;
    public DcMotor BR = null;
    public DcMotor FL = null;
    public DcMotor FR = null;

    HardwareMap hwMap = null;

    @Override
    public void runOpMode() {

        BL = hardwareMap.get(DcMotor.class, "BL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class, "FR");

        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {
            BL.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
            BR.setPower(gamepad1.right_stick_y - gamepad1.left_stick_x);
            FL.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x);
            FR.setPower((gamepad1.right_stick_y + gamepad1.left_stick_x));
        }
    }
}
