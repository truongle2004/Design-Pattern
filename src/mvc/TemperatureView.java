package mvc;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import observer.Subcriber;

public class TemperatureView extends JFrame implements Subcriber {

    private JPanel jPanel;
    protected JLabel jLabelC, jLabelF, jLabelResult;
    protected JTextField jTextFieldC, jTextFieldF;
    private JMenuBar jMenuBar;
    protected JMenuItem f2cItem, c2fItem;
    private TemperatureModal temperatureModal;

    public TemperatureView(TemperatureModal temperatureModal) {
        this.temperatureModal = temperatureModal;
        buildUI();
    }

    private void buildUI() {
        jPanel = new JPanel();

        jLabelC = new JLabel("Celsius");
        jTextFieldC = new JTextField(10);
        jPanel.add(jLabelC);
        jPanel.add(jTextFieldC);

        jLabelF = new JLabel("Fahreheit");
        jTextFieldF = new JTextField(10);
        jPanel.add(jLabelF);
        jPanel.add(jTextFieldF);

        jLabelResult = new JLabel();
        jPanel.add(jLabelResult);

        add(jPanel);
        setTitle("Temperature App");
        setSize(500, 200);

        MenuBarUI();
        setJMenuBar(jMenuBar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void MenuBarUI() {
        jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Commands");

        f2cItem = new JMenuItem("f2c");
        c2fItem = new JMenuItem("c2f");

        jMenu.add(f2cItem);
        jMenu.add(c2fItem);

        jMenuBar.add(jMenu);
    }

    @Override
    public void update() {
        System.out.println("C" + jTextFieldC.getText().equals(""));
        System.out.println("F" + jTextFieldF.getText().equals(""));

        if (jTextFieldC.getText().equals("") == false) {
            jTextFieldF.setText("" + temperatureModal.getResult());
        } else if (jTextFieldF.getText().equals("") == false) {
            jTextFieldC.setText("" + temperatureModal.getResult());
        }
    }
}
