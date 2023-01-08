// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxAlternateEncoder.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Drivebase() {

  }

  private final int diameter = 10;

  CANSparkMax m_leftMotor = new CANSparkMax(0, MotorType.kBrushless);
  CANSparkMax m_rightMotor = new CANSparkMax(1, MotorType.kBrushless);

  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  public void arcadeDrive(double horizontalSpeed, double rotationSpeed){
    m_drive.arcadeDrive(horizontalSpeed, rotationSpeed);
  }

  RelativeEncoder m_leftEncoder = m_leftMaster.getAlternateEncoder(Type.kQuadrature, 5000);
  RelativeEncoder m_rightEncoder = m_rightMaster.getAlternateEncoder(Type.kQuadrature, 5000);

  public void resetEncoders(){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public double getLeftDistanceInch(){
    return m_leftEncoder.getPosition() * diameter * Math.PI;
  }
  
  public double getRightDistanceInch(){
    return m_rightEncoder.getPosition() * diameter * Math.PI;
  }

  public double getAverageDistance(){
    return ((m_rightEncoder.getPosition() * diameter * Math.PI) + (m_leftEncoder.getPosition() * diameter * Math.PI;)) / 2
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}