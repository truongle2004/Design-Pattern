package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import command.C2FCommand;
import command.Command;
import command.CommandProcessor;
import command.F2CCommand;

public class TemperatureController implements ActionListener {
    private TemperatureModal temperatureModal;
    private TemperatureView temperatureView;
    private CommandProcessor commandProcessor;

    public TemperatureController(TemperatureModal temperatureModal, TemperatureView temperatureView) {
        this.temperatureModal = temperatureModal;
        this.temperatureView = temperatureView;
        this.temperatureModal.subcriber(temperatureView);

        commandProcessor = CommandProcessor.getInstance();

        this.temperatureView.c2fItem.addActionListener(this);
        this.temperatureView.f2cItem.addActionListener(this);

        // this.temperatureView.jTextFieldC.addKeyListener(new KeyAdapter() {
        // @Override
        // public void keyPressed(KeyEvent e) {
        // if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        // double valueC = Double.parseDouble(temperatureView.jTextFieldC.getText());
        // Command command = new C2FCommand(temperatureModal, valueC);
        // commandProcessor.execute(command);
        // }
        // }
        // });

        // this.temperatureView.jTextFieldF.addKeyListener(new KeyAdapter() {
        // @Override
        // public void keyPressed(KeyEvent e) {
        // if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        // double valueF = Double.parseDouble(temperatureView.jTextFieldF.getText());
        // Command command = new F2CCommand(temperatureModal, valueF);
        // commandProcessor.execute(command);
        // }
        // }
        // });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Command commandRomote = null;
        String command = e.getActionCommand();

        if (command == "c2f") {

            double valueC = Double.parseDouble(temperatureView.jTextFieldC.getText());
            commandRomote = new C2FCommand(temperatureModal, valueC);
            commandProcessor.execute(commandRomote);

        } else if (command == "f2c") {

            double valueF = Double.parseDouble(temperatureView.jTextFieldF.getText());
            commandRomote = new F2CCommand(temperatureModal, valueF);
            commandProcessor.execute(commandRomote);
        }
    }
}
