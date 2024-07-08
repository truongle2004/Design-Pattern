package mvc;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import command.C2FCommand;
import command.Command;
import command.F2CCommand;

public class TemperatureEnterController {
    private TemperatureModal temperatureModal;
    private TemperatureView temperatureView;

    public TemperatureEnterController(TemperatureModal temperatureModal, TemperatureView temperatureView) {
        this.temperatureModal = temperatureModal;
        this.temperatureView = temperatureView;
        this.temperatureModal.subcriber(temperatureView);

        this.temperatureView.jTextFieldC.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double valueC = Double.parseDouble(temperatureView.jTextFieldC.getText());
                Command commandRemote = new C2FCommand(temperatureModal, valueC);
                execute(commandRemote);
            }
        });

        this.temperatureView.jTextFieldF.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valueF = Double.parseDouble(temperatureView.jTextFieldF.getText());
                Command commandRemote = new F2CCommand(temperatureModal, valueF);
                execute(commandRemote);
            }
        });
    }

    public void execute(Command command) {
        command.execute();
    }
}
