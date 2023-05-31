package regsosek.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    AppManager am;

    public ActionHandler(AppManager am) {
        this.am = am;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "page-register":
                am.routing.showScreen(1);
                break;
            case "page-login":
                am.routing.showScreen(0);
                break;
            case "login":
                am.routing.showScreen(4);
                break;
            case "register":
                am.routing.showScreen(0);
                break;
            case "page-blok4":
                am.routing.showScreen(3);
                break;
            case "mulai":
                am.routing.showScreen(2);
                break;
            case "logout":
                am.routing.showScreen(0);
                break;
            case "submit":
                am.routing.showScreen(4);
                break;
            case "home":
                am.routing.showScreen(4);
                break;
            default:
                break;
        }
        am.ui.refreshVariable();
    }

}
