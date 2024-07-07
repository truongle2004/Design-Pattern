package command;

import mvc.TemperatureModal;

public class F2CCommand extends Command {
    private double value;

    public F2CCommand(TemperatureModal temperatureModal, double value) {
        this.temperatureModal = temperatureModal;
        this.value = value;
    }

    @Override
    public void execute() {
        temperatureModal.f2c(value);
    }
}
