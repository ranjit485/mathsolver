import controller.AppController;
import model.AppModel;
import view.AppView;

public class App {
    public static void main(String[] args) {
        AppModel model = new AppModel();
        AppView view = new AppView();
        AppController controller = new AppController(model, view);

        // Set up the application
        view.setVisible(true);
    }
}
