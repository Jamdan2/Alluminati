package org.sert2521.alluminati.commands.teleop

import edu.wpi.first.wpilibj.command.Command
import org.sert2521.alluminati.oi
import org.sert2521.alluminati.subsystems.Arm.arm
import org.sert2521.alluminati.subsystems.Arm.frontSwitch
import org.sert2521.alluminati.subsystems.Arm.rearSwitch
import org.sert2521.alluminati.subsystems.Arm.speedFactor

class ArmControl : Command() {
    override fun execute() {
        if (frontSwitch.get() || rearSwitch.get()) arm.set(0.0)
        arm.set(oi.armControl * speedFactor)
    }

    override fun isFinished(): Boolean {
        return false
    }
}
