package frc.robot.subsystems.Elevator;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.MutCurrent;
import edu.wpi.first.units.measure.MutDistance;
import edu.wpi.first.units.measure.MutLinearVelocity;
import edu.wpi.first.units.measure.MutVoltage;
import edu.wpi.first.units.measure.Voltage;

public interface ElevatorIO {
    class ElevatorIOInputs {

    }

    void updateIputs(ElevatorIOInputs inputs);
    void runVolts(Voltage volts);
    void runSetpoint(Distance position);
    void stop();
    
} 