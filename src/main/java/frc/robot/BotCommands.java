
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.lighter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    public static CycleLights cycleLights;
    public static PickerUpper pickerupper;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Pickup
        clawdown = new ClawDown(BotSubsystems.pickerupper);
        clawup = new ClawUp(BotSubsystems.pickerupper);
        closeclaw = new CloseClaw(BotSubsystems.pickerupper);
        openclaw = new OpenClaw(BotSubsystems.pickerupper);
        stophorizontalclaw = new StopHorizontalClaw(BotSubsystems.pickerupper);
        stopverticalclaw = new StopVerticalClaw(BotSubsystems.pickerupper);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}
