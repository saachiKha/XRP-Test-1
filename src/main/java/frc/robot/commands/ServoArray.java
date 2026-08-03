// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Arm; 

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ServoArray extends Command {
  Timer timer;
  Arm m_armServo;
  double [] position;
  double m_lastChangeTime = 0.0;
  int m_currentPositionIndex = 0;
  /** Creates a new ServoArray. */
  public ServoArray(Arm m_armServo) {
    this.m_armServo = m_armServo;
    timer = new Timer();
    timer.start();
    position = new double[5];
    position[0] = 0;
    position[1] = 15;
    position[2] = 45;
    position[3] = 90;
    position[4] = 145;
    //double[] position = {0,15,45,90,145};//bit more condensed than the tutorial version
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_armServo.setAngle(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Timer.getFPGATimestamp()-m_lastChangeTime>1.0){
      m_armServo.setAngle(position[m_currentPositionIndex]);
      m_currentPositionIndex++;
      m_lastChangeTime = Timer.getFPGATimestamp();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_currentPositionIndex >= 5 ;
  }
}
