import controller.AdminController;
import controller.AgentController;
import controller.ClientController;
import model.User;
import security.RoleBasedAccessControl;
import view.View;

public class App {
    public static void main(String[] args) {
        RoleBasedAccessControl rbac = new RoleBasedAccessControl();
        View view = new View();
        
        while (true) {
            User currentUser = rbac.login();
            
            if (currentUser != null) {
                switch (currentUser.getRole()) {
                    case "Admin":
                        AdminController adminController = new AdminController(currentUser, view);
                        adminController.start();
                        break;
                    case "Agent":
                        AgentController agentController = new AgentController(currentUser, view);
                        agentController.start();
                        break;
                    case "Client":
                        ClientController clientController = new ClientController(currentUser, view);
                        clientController.start();
                        break;
                    default:
                        view.displayMessage("Invalid role.");
                }
            }
        }
    }
}
