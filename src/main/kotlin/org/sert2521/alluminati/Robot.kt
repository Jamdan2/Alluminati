package org.sert2521.alluminati

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler
import org.sert2521.alluminati.subsystems.Arm
import org.sert2521.alluminati.subsystems.DriveTrain

class Robot : IterativeRobot() {
    override fun robotInit() {
        DriveTrain
        Arm
    }

    override fun autonomousInit() {

    }

    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
        DriveTrain.drive.tankDrive(.75, .5)
    }

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }
}
