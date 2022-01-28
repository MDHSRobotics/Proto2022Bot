
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Lighter subsystem, for turning lights on and off.
public class Picker extends SubsystemBase {

    public Picker() {
        Logger.setup("Constructing Subsystem: Picker...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void openHorizontal() {
        SubsystemDevices.talonPickup1.set(0.5);
        SubsystemDevices.talonPickup2.set(0.5);
    }

    public void closeHorizontal() {
        
    }

    public void stopHorizontal() {
        SubsystemDevices.talonPickup1.stopMotor();
    }
}
