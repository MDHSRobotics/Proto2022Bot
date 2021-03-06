
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static PickerUpper pickerupper;

    public static Lighter lighter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        lighter = new Lighter();
        pickerupper = new PickerUpper();
    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);

    // Pickup
    Logger.setup("PickerUpper Teleop Default Command -> stopverticalclaw...");
    pickerupper.setDefaultCommand(BotCommands.stopverticalclaw);

    Logger.setup("PickerUpper Teleop Default Command -> stophorizontalclaw...");
    pickerupper.setDefaultCommand(BotCommands.stophorizontalclaw);
    }

}
