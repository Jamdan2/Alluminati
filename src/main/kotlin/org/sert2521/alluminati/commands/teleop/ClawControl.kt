package org.sert2521.alluminati.commands.teleop

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Command
import org.sert2521.alluminati.oi
import org.sert2521.alluminati.subsystems.Claw.claw
import org.sert2521.alluminati.subsystems.Claw.isForward

class ClawControl : Command() {
    override fun execute() {
        if (isForward && oi.clawControl) {
            claw.set(DoubleSolenoid.Value.kReverse)
        } else if (!isForward && oi.clawControl) {
            claw.set(DoubleSolenoid.Value.kForward)
        }
    }

    override fun isFinished(): Boolean {
        return false
    }
}
