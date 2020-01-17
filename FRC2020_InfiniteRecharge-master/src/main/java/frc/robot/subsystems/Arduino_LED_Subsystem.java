/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalOutput;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Set_LEDs_Alliance;

/**
 * Add your docs here.
 */
public class Arduino_LED_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DigitalOutput Red_or_Blue = new DigitalOutput(0); //Connects to Arduino DIO 4
  public DigitalOutput Party = new DigitalOutput(1);  //Connects to Arduino DIO 3


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Set_LEDs_Alliance());
  }
}
