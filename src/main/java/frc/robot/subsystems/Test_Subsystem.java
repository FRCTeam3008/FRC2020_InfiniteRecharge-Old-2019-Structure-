/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Test_Off;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class Test_Subsystem extends Subsystem {
  
  static Spark TestSpark = new Spark(0);

  public void Forward() {
    TestSpark.set(1.0);    
  }

  public void Backward() {
    TestSpark.set(-1.0);    
  }

  public void Off(){
    TestSpark.set(0.0);    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new Test_Off());
  }
}
