import mvc.TemperatureController;
import mvc.TemperatureModal;
import mvc.TemperatureView;

public class App {
    public static void main(String[] args) throws Exception {
        TemperatureModal modal = new TemperatureModal();
        TemperatureView view = new TemperatureView(modal);
        TemperatureController temperatureController = new TemperatureController(modal, view);
    }
}
