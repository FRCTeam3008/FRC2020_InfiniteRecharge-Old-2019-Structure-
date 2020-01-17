/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

   /*CONTROLER */ 
  //Joystick port
  public static int JoystickPort = 0;
  
  //left motor ID
  public static int MotorL1ID = 1;
  public static int MotorL2ID = 3;
  public static int MotorL3ID = 5;

  //right motor ID
  public static int MotorR1ID = 0;
  public static int MotorR2ID = 2;
  public static int MotorR3ID = 4;

  //letter buttons on right
  public static int ButtonA = 1;
  public static int ButtonB = 2;
  public static int ButtonX = 3;
  public static int ButtonY = 4;

  //trigger IDs
  public static int LTrigger = 2;
  public static int RTrigger = 3;

  //LB and RB on back
  public static int LBumper = 5;
  public static int RBumper = 6;

  //back and start on remote
  public static int LMiddle = 7;
  public static int RMiddle = 8;

  //left and right joystick ID and left and right joystick button ID
  public static int LJoystickBtn = 9;
  public static int RJoystickBtn = 10;
  public static int LeftJoystickID = 1;  
  public static int RightJoystickID = 5;
}