package org.sert2521.alluminati.subsystems

import FRONT_LEFT
import FRONT_RIGHT
import REAR_LEFT
import REAR_RIGHT
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import org.sert2521.alluminati.commands.teleop.ArcadeDrive

object DriveTrain : Subsystem() {
    val speedFactor = 1

    val left = WPI_TalonSRX(FRONT_LEFT).apply {
        WPI_TalonSRX(REAR_LEFT).follow(this)
    }
    val right = WPI_TalonSRX(FRONT_RIGHT).apply {
        WPI_TalonSRX(REAR_RIGHT).follow(this)
    }

    val drive = DifferentialDrive(left, right)

    init {
        left.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10000)
        right.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10000)

        left.setSelectedSensorPosition(0, 0, 10000)
        right.setSelectedSensorPosition(0, 0, 10000)
    }

    override fun initDefaultCommand() {
        ArcadeDrive().start()
    }
}
