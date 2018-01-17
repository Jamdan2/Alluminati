package org.sert2521.alluminati.subsystems

import SOLENOID_EXTEND
import SOLENOID_RETRACT
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import org.sert2521.alluminati.commands.teleop.ClawControl

object Claw : Subsystem() {
    val claw = DoubleSolenoid(SOLENOID_EXTEND, SOLENOID_RETRACT)

    val isForward: Boolean
        get() = claw.get() == DoubleSolenoid.Value.kForward

    override fun initDefaultCommand() {
        ClawControl().start()
    }
}
