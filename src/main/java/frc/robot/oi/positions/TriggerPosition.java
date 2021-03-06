
package frc.robot.oi.positions;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;

// The position values obtained from Xbox Triggers
public class TriggerPosition {

    public double leftTriggerPosition = 0;
    public double rightTriggerPosition = 0;

    public TriggerPosition() {
    }

    public TriggerPosition(double leftTrigger, double rightTrigger) {
        leftTriggerPosition = leftTrigger;
        rightTriggerPosition = rightTrigger;
    }

    // Gets the xbox trigger positions
    public static TriggerPosition getTriggerPosition(XboxController xbox) {
        double leftTriggerAxis = xbox.getLeftTriggerAxis();
        double rightTriggerAxis = xbox.getRightTriggerAxis();

        TriggerPosition pos = new TriggerPosition(leftTriggerAxis, rightTriggerAxis);
        return pos;
    }

}
