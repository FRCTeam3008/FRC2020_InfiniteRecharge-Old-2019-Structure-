/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Spinner_Off;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */

 //most likely will be switched to Talon SRX + color sensor
public class Spinner_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static Spark spinnerSpark = new Spark(RobotMap.Spark1ID);

  public void spinnerForward() {
    spinnerSpark.set(1.0);    
  }

  public void spinnerBackward() {
    spinnerSpark.set(-1.0);    
  }

  public void spinnerOff(){
    spinnerSpark.set(0.0);    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new Spinner_Off());
  }
}
