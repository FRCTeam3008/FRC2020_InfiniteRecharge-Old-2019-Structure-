/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TalonSpinner_Subsystem extends SubsystemBase {
  /**
   * Creates a new TalonSpinner_Subsystem.
   */
  TalonSRX spinnerTalon = new TalonSRX(8);

  public TalonSpinner_Subsystem() {
  }

  public void talonOff(){
    spinnerTalon.set(ControlMode.PercentOutput, 0);
  }

  public void talonForward()
  {
    spinnerTalon.set(ControlMode.PercentOutput, .25);
  }
}
