/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.GenericHID;

//COMMANDS
import frc.robot.commands.Test_Forward;
import frc.robot.commands.Test_Backward;
//import frc.robot.commands.Test_Off;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
 
  static Joystick stick0 = new Joystick(RobotMap.JoystickPort);
  
  //public JoystickAnalogButton LTrigger = new JoystickAnalogButton(stick0, RobotMap.LTrigger);
  //public JoystickAnalogButton RTrigger = new JoystickAnalogButton(stick0, RobotMap.RTrigger);
  
  //Button RMiddle = new JoystickButton(stick0, RobotMap.RMiddle);
  //Button LMiddle = new JoystickButton(stick0, RobotMap.LMiddle);
  

  Button buttonA = new JoystickButton(stick0, RobotMap.ButtonA);
  Button buttonB = new JoystickButton(stick0, RobotMap.ButtonB);
  Button buttonX = new JoystickButton(stick0, RobotMap.ButtonX);
  Button buttonY = new JoystickButton(stick0, RobotMap.ButtonY);

  
  //Button LBumper = new JoystickButton(stick0, RobotMap.LBumper); // elevator goes down
  //public JoystickAnalogButton TriggerL = new JoystickAnalogButton(stick0, RobotMap.LTrigger); // elevator goes up

  
  //buttonX.whileHeld(new TurnLeft(.05));
  //buttonY.whileHeld(new DriveForward(.05))






  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.



  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
 //buttonA.whileHeld(new Test_Off());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

    public static double getLeftStickY(){
      return (stick0.getRawAxis(RobotMap.LeftJoystickID));
    
    }

    public static double getRightStickY(){
      return (stick0.getRawAxis(RobotMap.RightJoystickID));
    }

  public OI() {
    buttonA.whileHeld(new Test_Forward());
    buttonB.whileHeld(new Test_Backward());
  // buttonA.whileHeld( new Test_Forward() );
  }
}
