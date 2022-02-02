
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Lighter subsystem, for turning lights on and off.
public class PickerUpper extends SubsystemBase {

    public PickerUpper() {
        Logger.setup("Constructing Subsystem: PickerUpper...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    //moves the arms horizontally
    public void openHorizontal() {
        SubsystemDevices.talonPickup1.set(0.5);
        }

    public void closeHorizontal() {
        SubsystemDevices.talonPickup1.set(-0.5);
    }

    public void stopHorizontal() {
        SubsystemDevices.talonPickup1.stopMotor();
    }

    //moves the arms vertically
    public void armsUp() {
        SubsystemDevices.talonPickup2.set(0.5);
    }

    public void armsDown() {
        SubsystemDevices.talonPickup2.set(-0.5);
    }

    public void verticalStop() {
        SubsystemDevices.talonPickup2.stopMotor();
    }


}
