package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Teleop extends LinearOpMode {

    public DcMotor BL = null;
    public DcMotor BR = null;
    public DcMotor FL = null;
    public DcMotor FR = null;
    public DcMotor arm = null;

    public Servo claw = null;
    public Servo wrist = null;
    public double wristPosition = .85;

    @Override
    public void runOpMode() {

        BL = hardwareMap.get(DcMotor.class, "BL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class, "FR");
        arm = hardwareMap.get(DcMotor.class, "arm");

        claw = hardwareMap.get(Servo.class, "claw");
        wrist = hardwareMap.get(Servo.class, "wrist");
        int position = 0;

        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();
        arm.setTargetPosition(0);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(opModeIsActive()) {

            //drive code
            double speed = 1;
            BL.setPower(speed * (gamepad1.left_stick_y + gamepad1.left_stick_x));
            BR.setPower(speed * (gamepad1.right_stick_y - gamepad1.left_stick_x));
            FL.setPower(speed * (gamepad1.left_stick_y - gamepad1.left_stick_x));
            FR.setPower(speed * (gamepad1.right_stick_y + gamepad1.left_stick_x));

            //arm
            position += (int) (2 * gamepad2.left_stick_y);
            arm.setTargetPosition(position);
            arm.setPower(.5);
            telemetry.addData("position", position);
            telemetry.addData("arm", arm.getCurrentPosition());
            telemetry.update();

            //claw
            // use .5 for full open, .4 for medium open, .3 for close on pixel, 0 for total close
            if (gamepad2.left_bumper) {
                claw.setPosition(.4);
            } else if (gamepad2.right_bumper) {
                claw.setPosition(.3);
            }

            //wrist
            if(gamepad2.dpad_up) {
                wristPosition = .85;
            } else if (gamepad2.dpad_down) {
                wristPosition -= .1;
            }
            wrist.setPosition(wristPosition);

            //dumb way
            //arm.setPower(gamepad2.left_stick_y * .5);
        }
    }
}
