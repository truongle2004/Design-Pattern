package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import command.C2FCommand;
import command.Command;
import command.F2CCommand;

public class TemperatureController implements ActionListener {
    private TemperatureModal temperatureModal;
    private TemperatureView temperatureView;

    public TemperatureController(TemperatureModal temperatureModal, TemperatureView temperatureView) {
        this.temperatureModal = temperatureModal;
        this.temperatureView = temperatureView;
        this.temperatureModal.subcriber(temperatureView);

        this.temperatureView.c2fItem.addActionListener(this);
        this.temperatureView.f2cItem.addActionListener(this);

    }

    public void execute(Command command) {
        command.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Command commandRomote = null;
        String command = e.getActionCommand();

        if (command == "c2f") {

            double valueC = Double.parseDouble(temperatureView.jTextFieldC.getText());
            commandRomote = new C2FCommand(temperatureModal, valueC);
            execute(commandRomote);

        } else if (command == "f2c") {

            double valueF = Double.parseDouble(temperatureView.jTextFieldF.getText());
            commandRomote = new F2CCommand(temperatureModal, valueF);
            execute(commandRomote);
        }
    }
}
