/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive_Train_Subsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TankDriveCommand extends CommandBase {
  /**
   * Creates a new TankDriveCommand.
   */
  public double stickL, stickR;
  public TankDriveCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_drive);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    stickL = RobotContainer.getLeftStickY();
    stickR = RobotContainer.getRightStickY();
    RobotContainer.m_drive.tankDrive(stickL, stickR);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
