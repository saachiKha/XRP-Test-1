// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveASquare extends SequentialCommandGroup {
  /** Creates a new DriveASquare. */
  public DriveASquare(Drivetrain drivetrain) {//TODO:Not working, come back to this later
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    for (int i = 0; i < 4; i++){
      //drivetrain.resetGyro();
      addCommands(//why not use a loop? edit:that's taught later in the tutorial
        new DriveDistance(1, 5, drivetrain),
        new TurnDegrees(1, 90, drivetrain)
      );
    }
  }
}
