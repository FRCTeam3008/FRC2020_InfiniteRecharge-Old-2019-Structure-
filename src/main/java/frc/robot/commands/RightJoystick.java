/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class RightJoystick extends Command {
  public RightJoystick() {
    requires(Robot.RDriveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.RDriveTrain.MotorR1.set(OI.getRightStickY());
    Robot.RDriveTrain.MotorR2.set(OI.getRightStickY());
    Robot.RDriveTrain.MotorR3.set(OI.getRightStickY());
    //System.out.println("Right");

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
