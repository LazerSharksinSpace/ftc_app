package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.hardware.*;
import org.swerverobotics.library.*;
import org.swerverobotics.library.interfaces.*;

/**
 * A skeletal example of a do-nothing first OpMode. Go ahead and change this code
 * to suit your needs, or create sibling OpModes adjacent to this one in the same
 * Java package.
 */
@TeleOp(name="LaserShark OpMode old")
public class LaserShark_teleOp_oldProgram extends SynchronousOpMode {
    /* Declare here any fields you might find useful. */
    DcMotor motorLeft = null;
    DcMotor motorRight = null;
    DcMotor motorArm = null;
    DcMotor motorEx = null;
   // Servo   servoLeft = null;
   // Servo   servoRight = null;
   // Servo   servoMiddle = null;
    //Servo   servoMR = null;


    @Override
    public void main() throws InterruptedException {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
        this.motorLeft = this.hardwareMap.dcMotor.get("motorL");
        this.motorRight = this.hardwareMap.dcMotor.get("motorR");
        this.motorArm = this.hardwareMap.dcMotor.get("motorArm");
        this.motorEx = this.hardwareMap.dcMotor.get("motorEx");
       // this.servoLeft = this.hardwareMap.servo.get("servoL");
        //this.servoRight = this.hardwareMap.servo.get("servoR");
        //this.servoMiddle = this.hardwareMap.servo.get("servoM");
        //this.servoMR = this.hardwareMap.servo.get("servoMR");



        //reverse motors
        motorRight.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start
        waitForStart();

        // telOp Code below...
        while (opModeIsActive())//loop to run while play is active. Until stop button is pressed.
        {
            if (updateGamepads()) //method to read gamepads
            {
                // tank drive
                motorLeft.setPower(gamepad1.left_stick_y);
                motorRight.setPower(gamepad1.right_stick_y);


                //Arm Control w/Joystick
                motorArm.setPower(gamepad2.right_stick_y/3);
                motorEx.setPower(gamepad2.left_stick_y/4);
    /*

                    // Arm Control- Uses dual buttons to control motor direction
                    if (gamepad2.right_bumper) {
                        motorArm.setPower(-gamepad2.right_trigger); // if both Bumper + Trigger, then negative power, runs arm down
                    }
                    else {
                        motorArm.setPower(gamepad2.right_trigger);  // else trigger positive value, runs arm up
                    }

                    // Arm Extension- Uses dual buttons to control motor direction
                    if (gamepad2.left_bumper) {
                        motorEx.setPower(-gamepad2.left_trigger); // if both Bumper + Trigger, then negative power, Brings arm in
                    }
                    else {
                        motorEx.setPower(gamepad2.left_trigger);  // else trigger positive value, extends arm forward
                    }


                /*if(gamepad2.x){
                    servoLeft.setPosition(1);
                }
                if(gamepad2.y) {
                    servoLeft.setPosition(0.5);
                }
                if(gamepad2.b){
                    servoRight.setPosition(1);
                }
                if(gamepad2.a){
                    servoRight.setPosition(0.5);
                }
    `   */






                telemetry.update();
                idle();
            }//if
        }//OpModeActive

    }//Main
}//MyFirstOpMode
