import mvc.TemperatureController;
import mvc.TemperatureEnterController;
import mvc.TemperatureModal;
import mvc.TemperatureView;

public class App {
    public static void main(String[] args) throws Exception {
        TemperatureModal modal = new TemperatureModal();
        TemperatureView view = new TemperatureView(modal);
        TemperatureEnterController temperatureEnterController = new TemperatureEnterController(modal, view);
        TemperatureController temperatureController = new TemperatureController(modal, view);
    }
}
