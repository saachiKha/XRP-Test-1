//This is a comment. We can use these to leave notes in our code

package frc.robot.commands;

//These are import statements. If WPILib is a library, think of these as checking out specific books
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class WaveDemo extends Command {
  /** Creates a new WaveDemo. */

  //These 2 lines allow this part of the code to recognize that we can use the drivetrain and arm
  Drivetrain drivetrain;
  Arm Servoarm;

  public WaveDemo(Drivetrain d, Arm s) {
    this.drivetrain = d;
    this.Servoarm = s;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain, Servoarm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { //this sets everything into its ideal starting position
    this.Servoarm.setAngle(0);
    this.drivetrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { //here is where we can write the logic
    if ((drivetrain.getGyroAngleZ() >= 10) || (drivetrain.getGyroAngleZ() <= 20)){
      this.Servoarm.setAngle(135);
    } else {
      this.Servoarm.setAngle(45);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean isGreater = Math.abs(this.drivetrain.getGyroAngleZ())>90; //will be true or false
    return isGreater;
  }
};
