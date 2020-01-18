/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.Ball_Feed_Off;

/**
 * Add your docs here.
 */
public class Ball_Feed_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static Spark ballFeedSpark = new Spark(2); //change this
  static Spark ballFeedSpark2 = new Spark(3); //change this

  public void feedIntake() {
    ballFeedSpark.set(1.0);
    ballFeedSpark2.set(1.0);      
  }

  public void feedOuttake() {
    ballFeedSpark.set(-1.0);     
  }

  public void feedOff(){
    ballFeedSpark.set(0.0);
    ballFeedSpark2.set(0.0);   
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Ball_Feed_Off());
  }
}
