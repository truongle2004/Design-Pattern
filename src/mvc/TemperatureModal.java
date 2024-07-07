package mvc;

import observer.Publisher;

public class TemperatureModal extends Publisher {
    private double result;

    public void c2f(double C) {
        this.result = (9.0 / 5.0 * C) + 32;
        changeState();
    }

    public void f2c(double F) {
        this.result = 5.0 / 9.0 * (F - 32);
        changeState();
    }

    public double getResult() {
        return this.result;
    }

    public void changeState() {
        notifySub();
    }
}
