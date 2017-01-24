package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by mlowery2 on 1/11/2017.
 */

@Autonomous(name = "Shoot and Beacon, BLUE SIDE", group ="auto")
public class ShootAndBeaconBlue extends LinearBase {

    public void runOpMode() throws InterruptedException
    {
        initalize(DcMotor.RunMode.RUN_TO_POSITION, true);
        waitForStart();
        Thread.sleep(100);

        front.enableLed(true);

        moveShootMove(-0.75, 1440 * 2, 1440 * 1.5); // shoot

        turn(0.45, -45); // turn right 45

        move(MAX_MOVE_SPEED * -1, 1440 * 3.3); // the diag

        turn(0.45, 133); // turn to press the button

        pressAndTest(MAX_MOVE_SPEED, 1440 * -2.35, Color.BLUE); // press

        move(-MAX_MOVE_SPEED, 1440*2); // move back to hit the ball

        turn(0.45, 80); // DONT FALL OVER ROBOT (bump)
    }
}