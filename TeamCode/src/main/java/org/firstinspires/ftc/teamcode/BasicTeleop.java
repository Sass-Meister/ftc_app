package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by mlowery2 on 9/21/2016.
 */


@TeleOp(name="Basic Teleop", group="Testing")

public class BasicTeleop extends LinearOpMode {

    DcMotor left1;
    DcMotor left2;
    DcMotor right1;
    DcMotor right2;

    Servo rightBp;
    Servo leftBp;

    final float DEADZONE = 0.200f;
    final double BPMIN = 0;
    final double BPMAX = 1; // divide by 2 for mid

    public void runOpMode() throws InterruptedException {

        left1  = hardwareMap.dcMotor.get("left1");
        left2  = hardwareMap.dcMotor.get("left2");
        right1 = hardwareMap.dcMotor.get("right1");
        right2 = hardwareMap.dcMotor.get("right2");

        left1.setDirection(DcMotor.Direction.REVERSE); // make sure this works
        left2.setDirection(DcMotor.Direction.REVERSE);

        rightBp = hardwareMap.servo.get("rightBp");
        leftBp  = hardwareMap.servo.get("leftBp");

        gamepad1.setJoystickDeadzone(DEADZONE);
        gamepad2.setJoystickDeadzone(DEADZONE);

        rightBp.setPosition(BPMAX/2); // init to default positions
        leftBp.setPosition(BPMAX/2);

        waitForStart();

        while(opModeIsActive())
        {
            moveRight(gamepad1.right_stick_y, -1);
            moveLeft(gamepad1.left_stick_y, -1);

            if(gamepad1.b)
            {
                rightBp.setPosition(BPMAX);
                leftBp.setPosition(BPMAX);
            }
            else if(gamepad1.x)
            {
                rightBp.setPosition(BPMIN);
                leftBp.setPosition(BPMIN);
            }

        }
    } // End of running code
     //  Start of Functions

    public void moveLeft(float speed, int dist)
    {
        if(dist<0) // so that I dont have to input a distance for the encodes to go
        {
            left1.setPower(speed);
            left2.setPower(speed);
        }
    }

    public void moveRight(float speed, int dist)
    {
        if(dist<0)
        {
            right1.setPower(speed);
            right2.setPower(speed);
        }
    }

    public void moveForward(float speed, int dist) // not for use in this code
    {
        if(dist<0)
        {
            right1.setPower(speed);
            right2.setPower(speed);
            left1.setPower(speed);
            left2.setPower(speed);
        }
    }
}
