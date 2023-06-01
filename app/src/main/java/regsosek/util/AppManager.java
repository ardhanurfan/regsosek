package regsosek.util;

import regsosek.CreatorData;
import regsosek.Data;

public class AppManager {
    Data data = new Data();
    CreatorData creatorData = new CreatorData();
    ActionHandler actionHandler = new ActionHandler(this);
    UI ui = new UI(this);
    Routing routing = new Routing(this);

    public AppManager() {
        routing.showScreen(0);
    }
}
