package command;

import mvc.TemperatureModal;

public class C2FCommand extends Command {
    private double value;

    public C2FCommand(TemperatureModal temperatureModal, double value) {
        this.temperatureModal = temperatureModal;
        this.value = value;
    }

    @Override
    public void execute() {
        temperatureModal.c2f(value);
    }

}
