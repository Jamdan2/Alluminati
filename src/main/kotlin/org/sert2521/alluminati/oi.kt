package org.sert2521.alluminati

import CONTROLLER
import LEFT_STICK
import RIGHT_STICK
import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.Preferences
import edu.wpi.first.wpilibj.XboxController

val leftJoystick = Joystick(LEFT_STICK)
val rightJoystick = Joystick(RIGHT_STICK)
val controller = XboxController(CONTROLLER)

val oi = if (Preferences.getInstance().getDouble("ControlMode", 0.0) == 0.0) {
    JoystickOi()
} else {
    ControllerOi()
}

interface Oi {
    val driveControl: Double
    val turnControl: Double
    val armControl: Double
    val clawControl: Boolean
}

class JoystickOi : Oi {
    override val driveControl: Double
        get() = -leftJoystick.y
    override val turnControl: Double
        get() = leftJoystick.x
    override val armControl: Double
        get() = rightJoystick.y
    override val clawControl: Boolean
        get() = rightJoystick.triggerPressed
}

class ControllerOi : Oi {
    override val driveControl: Double
        get() = -controller.getY(GenericHID.Hand.kLeft)
    override val turnControl: Double
        get() = controller.getX(GenericHID.Hand.kLeft)
    override val armControl: Double
        get() = controller.getY(GenericHID.Hand.kRight)
    override val clawControl: Boolean
        get() = controller.getBumper(GenericHID.Hand.kLeft) || controller.getBumper(GenericHID.Hand.kRight)
}
