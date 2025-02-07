package frc.robot.subsystems.Elevator;

import static edu.wpi.first.units.Units.Inches;

import edu.wpi.first.units.measure.MutDistance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Elevator.ElevatorIO.ElevatorIOInputs;

public class Elevator extends SubsystemBase{
    private final ElevatorIO io;
    private final ElevatorIOInputs inputs = new ElevatorIOInputs();
    private MutDistance setpoint = Inches.mutable(0);

    public Elevator(ElevatorIO io){
        this.io = io;
    }
    
    @Override
    public void periodic(){
        this.io.updateIputs(inputs);
        //Logger.
        this.io.runSetpoint(setpoint);
    }

    public Command setSetpoint(MutDistance setpoint){
        return runOnce(() -> this.setpoint = setpoint);
    }
}
