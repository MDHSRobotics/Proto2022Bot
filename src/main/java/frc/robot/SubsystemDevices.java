
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped subsystem components, and utility methods.
// IMPORTANT: It is imperative that ONLY subsystems control any interactive device.
// Also, only ONE subsystem should control any given device.
public class SubsystemDevices {

    // Relays
    public static Relay relayLighter = new Relay(1);

    // Motor Controllers
    // TODO: Add the appropriate motor controllers

    // Drives
    // TODO: Add the appropriate drives

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        // TODO: Initialize the devices
        // Shooter
        public static DevCompressor compressor = new DevTalonSRX("talonSrxShooterBottomWheel", 4);
        public static DevSolenoid solenoid = new DevTalonSRX("talonSrxShooterTopWheel", 10);

        // Pickup
        public static DevTalonSRX talonPickup1 = new DevTalonSRX("talonSrxShooterTopWheel", 10);
        public static DevTalonSRX talonPickup2 = new DevTalonSRX("talonSrxShooterTopWheel", 10);
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}
