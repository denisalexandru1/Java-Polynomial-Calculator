import Model.Model;
import UI.Controller;
import UI.View;
import Model.Model;
import Logic.*;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        view.setVisible(true);

    }
}

