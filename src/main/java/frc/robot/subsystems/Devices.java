package frc.robot.subsystems;

import frc.robot.devices.*;

import edu.wpi.first.wpilibj.Servo;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // Shooter
    public static DevCompressor compressor = new DevTalonSRX("talonSrxShooterBottomWheel", 4);
    public static DevSolenoid solenoid = new DevTalonSRX("talonSrxShooterTopWheel", 10);

    /////////////////////
    // Drive Instances //
    /////////////////////

}