package org.sert2521.alluminati.commands.autonomous

import edu.wpi.first.wpilibj.command.PIDCommand
import org.sert2521.alluminati.subsystems.DriveTrain
import org.sert2521.alluminati.subsystems.DriveTrain.left
import org.sert2521.alluminati.subsystems.DriveTrain.right
import kotlin.math.PI

class DriveForward : PIDCommand(0.8, 0.0, 0.0) {
    init {
        requires(DriveTrain)

    }

    override fun initialize() {
        setpoint = 4.0
    }

    override fun usePIDOutput(output: Double) {
        right.set(output)
        left.set(output)
    }

    override fun isFinished(): Boolean {
        println("Hjdfsghk")
        return ((right.getSelectedSensorPosition(0) / 8192 * .15 * PI).also { println(this) } >= setpoint).also {
            println(this)
        }
    }

    override fun returnPIDInput(): Double {
        return right.getSelectedSensorPosition(0).toDouble()
    }
}
