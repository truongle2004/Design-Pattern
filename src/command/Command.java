package command;

import mvc.TemperatureModal;

public abstract class Command {
    protected TemperatureModal temperatureModal;

    public abstract void execute();

}
