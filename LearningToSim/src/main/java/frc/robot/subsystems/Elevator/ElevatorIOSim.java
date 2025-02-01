package frc.robot.subsystems.Elevator;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;

public class ElevatorIOSim implements ElevatorIO{
    private final ElevatorSim sim = new ElevatorSim(
        DCMotor.getKrakenX60(1), 
        4, 
        Pounds.of(9.8).in(Kilograms), 
        Inches.of(2).in(Meters), 
        Inches.of(0).in(Meters), 
        Inches.of(52).in(Meters), 
        true,
        Inches.of(0).in(Meters)
        );

        private final PIDController controller = new PIDController(0, 0, 0);

    @Override
    public void runVolts(Voltage volts) {
        sim.setInputVoltage(volts.in(Volts));
    }

    @Override
    public void runSetpoint(Distance position) {
        Distance currentHeight = Meters.of(sim.getPositionMeters());

        Voltage controllerVoltage = Volts.of(controller.calculate(position.in(Inches), currentHeight.in(Inches)));

        runVolts(controllerVoltage);
    }

    @Override
    public void stop() {
        runVolts(Volts.zero());
    }

    @Override
    public void updateIputs(ElevatorIOInputs inputs){
        /*        
        public MutDistance position = Inches.mutable(0);
        public MutLinearVelocity velocity = InchesPerSecond.mutable(0);

        public MutVoltage appliedVolts = Volts.mutable(0);
        public MutCurrent supplyCurrent = Amps.mutable(0);
        public MutCurrent torqueCurrent = Amps.mutable(0); 
        */
        sim.update(0.02);
        inputs.position.mut_replace(sim.getPositionMeters(). Meters);

    }
}
