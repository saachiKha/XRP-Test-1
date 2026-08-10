// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project. 
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
/*The commmented lines 11 & 13 are what the tutorial says, but they caused errors
 * Others also seem to be having the same error on WPI's forums and CD, but I didn't follow
 * Lines 10 & 12 were copied from RobotContainer */
import frc.robot.subsystems.Arm;
//import edu.wpi.first.wpilibj.examples.xrpreference.subsystem.Arm;
import frc.robot.subsystems.Drivetrain;
//import edu.wpi.first.wpilibj.examples.xrpreference.subsystem.Drivetrain;



/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ServoWithGyro extends Command {
  Drivetrain drivetrain;
  Arm Servoarm;
  /** Creates a new ServoWithGyro. */
  public ServoWithGyro(Drivetrain d, Arm s) { // I added these parameters, but the tutorial does't instruct to do so, which causes an error
    this.drivetrain = d;//originaly, d & s were drivetrain & Servoarm, but it looked a bit confusing
    this.Servoarm = s;
    addRequirements(drivetrain, Servoarm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.Servoarm.setAngle(0);
    this.drivetrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(drivetrain.getGyroAngleZ()>=90){
      this.Servoarm.setAngle(45);
    }else if(drivetrain.getGyroAngleZ()>=-90){
      this.Servoarm.setAngle(180);
    }else{
      this.Servoarm.setAngle(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(this.drivetrain.getGyroAngleZ())>90;
  }
}
