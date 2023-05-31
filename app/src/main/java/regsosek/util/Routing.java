package regsosek.util;

public class Routing {
    AppManager am;

    public Routing(AppManager am) {
        this.am = am;
    }

    public void showScreen(int screenIndex) {
        for (int i = 0; i < am.ui.bgPanel.length; i++) {
            if (i == screenIndex) {
                am.ui.bgPanel[i].setVisible(true);
            } else {
                if (am.ui.bgPanel[i] != null) {
                    am.ui.bgPanel[i].setVisible(false);
                }
            }
        }

    }
}
