package regsosek.util;

public class AppManager {
    ActionHandler actionHandler = new ActionHandler(this);
    UI ui = new UI(this);
    Routing routing = new Routing(this);

    public AppManager() {
        routing.showScreen(0);
    }
}
