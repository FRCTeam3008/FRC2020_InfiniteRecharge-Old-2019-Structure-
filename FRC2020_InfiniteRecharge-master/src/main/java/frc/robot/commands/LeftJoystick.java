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

public class LeftJoystick extends Command {
  public LeftJoystick() 
  {
    requires(Robot.LDriveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() 
  {
    Robot.LDriveTrain.MotorL1.set(-OI.getLeftStickY());
    Robot.LDriveTrain.MotorL2.set(-OI.getLeftStickY());
    Robot.LDriveTrain.MotorL3.set(-OI.getLeftStickY());
    //System.out.println("Left");
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
