/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;

//SUBSYSTEM
import frc.robot.subsystems.Arduino_LED_Subsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LDriveTrain_Subsystem;
import frc.robot.subsystems.RDriveTrain_Subsystem;
import frc.robot.subsystems.Test_Subsystem;

//COMMANDS
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Set_LEDs_BLUE;
import frc.robot.commands.Set_LEDs_PartyMode;
import frc.robot.commands.Set_LEDs_RED;
//import frc.robot.commands.Test_Forward;
//import frc.robot.commands.Test_Backward;
//import frc.robot.commands.Test_Off;

//COLOR SENSOR
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public static RDriveTrain_Subsystem RDriveTrain = new RDriveTrain_Subsystem();
  public static LDriveTrain_Subsystem LDriveTrain = new LDriveTrain_Subsystem();
  
  public static Test_Subsystem TestMotor = new Test_Subsystem();
  public static Arduino_LED_Subsystem Arduino_LED = new Arduino_LED_Subsystem();

  /**
   * Change the I2C port below to match the connection of your color sensor
   */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  
  /**
   * A Rev Color Sensor V3 object is constructed with an I2C port as a 
   * parameter. The device will be automatically initialized with default 
   * parameters.
   */
  private final ColorSensorV3 testColorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();

  // Adjust as needed! (numbers on side were default)
  private final Color kBlueTarget = ColorMatch.makeColor(0.19, 0.45, 0.33); //0.143, 0.427, 0.429
  private final Color kGreenTarget = ColorMatch.makeColor(0.22, 0.54, 0.25); //0.197, 0.561, 0.24
  private final Color kRedTarget = ColorMatch.makeColor(0.41, 0.40, 0.18); //0.561, 0.232, 0.114
  private final Color kYellowTarget = ColorMatch.makeColor(0.32, 0.524, 0.14); //0.361, 0.524, 0.113

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

    SmartDashboard.putData("LEDs Blue", new Set_LEDs_BLUE());
    SmartDashboard.putData("LEDs Red", new Set_LEDs_RED());
    SmartDashboard.putData("PArty", new Set_LEDs_PartyMode());

    DriverStation.Alliance color;
    color = DriverStation.getInstance().getAlliance();
    if(color == DriverStation.Alliance.Blue){
      new Set_LEDs_BLUE().start();
    }
    else{
      new Set_LEDs_RED().start();
    }

    //color sensor stuff
    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kYellowTarget);   
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
        /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     * 
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the 
     * measurements and make it difficult to accurately determine its color.
     */
    Color detectedColor = testColorSensor.getColor();

      /**
       * The sensor returns a raw IR value of the infrared light detected.
       */
    double IR = testColorSensor.getIR();

      /**
       * Open Smart Dashboard or Shuffleboard to see the color detected by the 
       * sensor.
       */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);

      /**
       * In addition to RGB IR values, the color sensor can also return an 
       * infrared proximity value. The chip contains an IR led which will emit
       * IR pulses and measure the intensity of the return. When an object is 
       * close the value of the proximity will be large (max 2047 with default
       * settings) and will approach zero when the object is far away.
       * 
       * Proximity can be used to roughly approximate the distance of an object
       * or provide a threshold for when an object is close enough to provide
       * accurate color values.
       */
    int proximity = testColorSensor.getProximity();

    SmartDashboard.putNumber("Proximity", proximity);

    
    String colorString;
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    //Set LEDs to party mode
    Robot.Arduino_LED.Party.set(true); //turn on party mode

    
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}