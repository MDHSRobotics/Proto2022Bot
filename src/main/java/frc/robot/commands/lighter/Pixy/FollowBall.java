
package frc.robot.commands.Pixy;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Pixy;

// This command spins the Pickup
public class FollowBall extends CommandBase {

    public FollowBall() {
        Logger.setup("Constructing Command: FollowBall...");
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: FollowBall...");
    }

    @Override
    //probably going to use encoder?
    public void execute() {
        if (Pixy.detectBall().equals("right")) {
            //turn right
            while !(Pixy.reachedBall()) {
                //go straight
            }
        } else if (Pixy.detectBall().equals("left")) {
            //turn left
            while !(Pixy.reachedBall()) {
                //go straight
            }
        } else if (Pixy.detectBall().equals("straight")) {
            while !(Pixy.reachedBall()) {
                //go straight
            }
        }
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: pixyTest...");
        } else {
            Logger.ending("Ending Command: pixyTest...");
        }
    }

}