
package frc.robot.sensors;

import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import java.util.ArrayList;

import frc.robot.consoles.Logger;
import frc.robot.BotSensors;

public class Pixy {

    private static final int blockSignature = 1;

    // Pixy
    public static void initializePixy(Pixy2 pixy) {
        int result = pixy.init();
        if (result == Pixy2.PIXY_RESULT_ERROR) {
            Logger.problem("Pixy2 failed to connect!");
        }
        else if (result == Pixy2.PIXY_RESULT_TIMEOUT) {
            Logger.problem("Pixy2 timed out!");
        }
        else if (result < 0) {
            Logger.problem("Pixy2 error code: " + result);
        }
    }

    public Block findLargestBlock() {
        Pixy2CCC ccc = BotSensors.pixy.getCCC();
        int blockCount = ccc.getBlocks(true, Pixy2CCC.CCC_SIG1, 10);
        if (blockCount <= 0) {
            Logger.problem("Pixy -> detectBall -> No block count");
        }

        ArrayList<Block> blocks = ccc.getBlocks();
        Block largestBlock = null;
        if (blocks == null) {
            Logger.info("Pixy -> detectBall -> No blocks");
        }
        for (Block block : blocks) {
            if (block.getSignature() == blockSignature) {
                if (largestBlock == null) {
                    largestBlock = block;
                }
                else if (block.getWidth() > largestBlock.getWidth()) {
                    largestBlock = block;
                }
            }
        }
    }

    public static String detectBall() {
        
        if (findLargestBlock() != null) {
            int blockAngle = findLargestBlock().getAngle();
            Logger.info("Largest block angle from camera: " + blockAngle);

            //TODO: find angle range to the left and right of camera ideal for calculating whether ball is to the left or right
            if (blockAngle > 2) {
                return "right"
            } else if (blockAngle < -2) {
                return "left"
            } else {
                return "straight"
            } 
        } 
        return "no blocks detected";
    }

    public boolean reachedBall() {
        //TODO: find y value of ball position on camera for when it reaches the pickup
        if (findLargestBlock().getY() < 10) {
            return true;
        } else {
            return false;
        }
    }
}