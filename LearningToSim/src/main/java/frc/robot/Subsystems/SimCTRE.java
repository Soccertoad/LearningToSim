// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CTREConstants;

public class SimCTRE extends SubsystemBase {
  TalonFX kraken;
  DCMotorSim krakenSimWPI;
  double kGearRatio = 10.00;
  /** Creates a new SimCTRE. */
  public SimCTRE() {
    kraken = new TalonFX(CTREConstants.KRAKEN_ID);
    krakenSimWPI =new DCMotorSim(LinearSystemId.createDCMotorSystem(
      DCMotor.getKrakenX60Foc(1), 0.001, kGearRatio), 
      DCMotor.getKrakenX60Foc(0)
    );
  }
  public void simulationPeriodic(){
    var krakenSim = kraken.getSimState();

    // set the supply voltage of the TalonFX
    krakenSim.setSupplyVoltage(RobotController.getBatteryVoltage());
 
    // get the motor voltage of the TalonFX
    var motorVoltage = krakenSim.getMotorVoltageMeasure();
 
    // use the motor voltage to calculate new position and velocity
    // using WPILib's DCMotorSim class for physics simulation
    m_motorSimModel.setInputVoltage(motorVoltage.in(Volts));
    m_motorSimModel.update(0.020); // assume 20 ms loop time
 
    // apply the new rotor position and velocity to the TalonFX;
    // note that this is rotor position/velocity (before gear ratio), but
    // DCMotorSim returns mechanism position/velocity (after gear ratio)
    krakenSim.setRawRotorPosition(m_motorSimModel.getAngularPosition().times(kGearRatio));
    krakenSim.setRotorVelocity(m_motorSimModel.getAngularVelocity().times(kGearRatio));
  }
/*
public void simulationPeriodic() {

} */
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
