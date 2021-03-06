
package frc.robot.oi.positions;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.brains.XboxBrain;

// The position values obtained from Xbox Thumbsticks
public class ThumbStickPosition {

    public double leftForwardBackPosition = 0; // y left Forward & Backward
    public double leftSideToSidePosition = 0; // x left Side to Side
    public double rightForwardBackPosition = 0; // y right Forward & Backward
    public double rightSideToSidePosition = 0; // x right Side to Side

    public ThumbStickPosition() {
    }

    public ThumbStickPosition(double leftForwardBack, double leftSideToSide, double rightForwardBack, double rightSideToSide) {
        leftForwardBackPosition = leftForwardBack;
        leftSideToSidePosition = leftSideToSide;
        rightSideToSidePosition = rightForwardBack;
        rightSideToSidePosition = rightSideToSide;
    }

    // Gets the xbox thumbstick positions and applies user-determined orientation, deadzones, and sensitivity
    public static ThumbStickPosition getThumbstickPosition(XboxController xbox, boolean isYleftFlipped) {
        double yLeft = xbox.getLeftY(); // Forward & backward, flipped
        double xLeft = xbox.getLeftX(); // Strafe
        double yRight = xbox.getRightY(); // Forward & backward, flipped
        double xRight = xbox.getRightX(); // Rotate

        // Forward/backward direction is reversed from what is intuitive, so flip it
        yLeft = -yLeft;
        yRight = -yRight;

        // User-determined flipping of forward/backward orientation
        if (isYleftFlipped) {
            yLeft = -yLeft;
            yRight = -yRight;
        }

        // Deadzones
        double yLeftDeadZone = XboxBrain.getYleftDeadZone();
        double xLeftDeadZone = XboxBrain.getXleftDeadZone();
        double yRightDeadZone = XboxBrain.getYrightDeadZone();
        double xRightDeadZone = XboxBrain.getXrightDeadZone();

        if (Math.abs(yLeft) <= yLeftDeadZone)
            yLeft = 0;
        if (Math.abs(xLeft) <= xLeftDeadZone)
            xLeft = 0;
        if (Math.abs(yRight) <= yRightDeadZone)
            yRight = 0;
        if (Math.abs(xRight) <= xRightDeadZone)
            xRight = 0;

        if (yLeft > 0)
            yLeft = yLeft - yLeftDeadZone;
        if (yLeft < 0)
            yLeft = yLeft + yLeftDeadZone;
        if (xLeft > 0)
            xLeft = xLeft - xLeftDeadZone;
        if (xLeft < 0)
            xLeft = xLeft + xLeftDeadZone;
        if (yRight > 0)
            yRight = yRight - yRightDeadZone;
        if (yRight < 0)
            yRight = yRight + yRightDeadZone;
        if (xRight > 0)
            xRight = xRight - xRightDeadZone;
        if (xRight < 0)
            xRight = xRight + xRightDeadZone;

        // Sensitivity
        double yLeftSensitivity = XboxBrain.getYleftSensitivity();
        double xLeftSensitivity = XboxBrain.getXleftSensitivity();
        double yRightSensitivity = XboxBrain.getYrightSensitivity();
        double xRightSensitivity = XboxBrain.getXrightSensitivity();

        yLeft = yLeft * yLeftSensitivity;
        xLeft = xLeft * xLeftSensitivity;
        yRight = yRight * yRightSensitivity;
        xRight = xRight * xRightSensitivity;

        ThumbStickPosition pos = new ThumbStickPosition(yLeft, xLeft, yRight, xRight);
        return pos;
    }

    // TODO: Also consider adding a "debouncer" for the buttons
    // https://frc-pdr.readthedocs.io/en/latest/user_input/joystick.html

}
