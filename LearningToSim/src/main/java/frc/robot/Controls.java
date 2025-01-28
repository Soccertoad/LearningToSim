package frc.robot;

//      WPI Imports 
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Controls {
    /**     Create Xbox Controllers:
     *          Senses inputs from Xbox Controller
    */
    //              Driver Controller
    public static XboxController xbox_driver = new XboxController(Constants.ControlConstants.XBOX_CONTROLLER_DRIVER_PORT);
    //              Operator Controller
    public static XboxController xbox_operator = new XboxController(Constants.ControlConstants.XBOX_CONTROLLER_OPERATOR_PORT);
    
    /**     Creates Command Xbox Controller:
     *          Maps commands to Xbox Controller inputs
    */
    //              Driver Controller
    public static CommandXboxController driver = new CommandXboxController(Constants.ControlConstants.XBOX_CONTROLLER_DRIVER_PORT); // Creates a CommandXboxController on port 1.
    //              Operator Controller
    public static CommandXboxController operator = new CommandXboxController(Constants.ControlConstants.XBOX_CONTROLLER_OPERATOR_PORT); // Creates a CommandXboxController on port 1.
}