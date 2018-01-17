package org.sert2521.alluminati.commands.teleop

import edu.wpi.first.wpilibj.command.Command
import org.sert2521.alluminati.oi
import org.sert2521.alluminati.subsystems.DriveTrain.drive
import org.sert2521.alluminati.subsystems.DriveTrain.speedFactor

class ArcadeDrive : Command() {
    override fun execute() {
        drive.arcadeDrive(oi.driveControl * speedFactor, oi.turnControl * speedFactor)
    }

    override fun end() {
        drive.stopMotor()
    }

    override fun isFinished(): Boolean {
        return false
    }
}
