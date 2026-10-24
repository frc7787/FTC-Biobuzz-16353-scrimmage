package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedro.Constants;

public class autoScrimmage1 extends OpMode {

    private DcMotorEx flywheelMotorOne,
            flywheelMotorTwo,
            intakeMotor,
            flippyMotor;

    private Follower follower;

    private ElapsedTime gameTime = new ElapsedTime();

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);


    }

    @Override
    public void start() {
        gameTime.reset();

    }

    @Override
    public void loop() {

        if (gameTime.seconds()>15) {
        follower.manual(
                ManualDrive.fieldCentric(
                        -0.5,
                        -0.0,
                        -0.0,
                        follower.pose().heading()
                )
        );}
        else if (gameTime.seconds()>18) {
            follower.manual(
                    ManualDrive.fieldCentric(
                            -0.0,
                            -0.0,
                            -0.0,
                            follower.pose().heading()
                    )
            );
        }
        follower.update();

    }
}
