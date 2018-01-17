package org.sert2521.alluminati.subsystems

import ARM_LEFT
import ARM_RIGHT
import FRONT_SWITCH
import REAR_SWITCH
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.command.Subsystem
import org.sert2521.alluminati.commands.teleop.ArmControl

object Arm : Subsystem() {
    val arm = WPI_TalonSRX(ARM_RIGHT).apply {
        follow(WPI_TalonSRX(ARM_LEFT))
    }

    val speedFactor = 1

    val frontSwitch = DigitalInput(FRONT_SWITCH)
    val rearSwitch = DigitalInput(REAR_SWITCH)

    override fun initDefaultCommand() {
        ArmControl().start()
    }
}
