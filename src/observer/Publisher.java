package observer;

import java.util.LinkedList;
import java.util.List;

public class Publisher {
    private List<Subcriber> subcribers = new LinkedList<>();

    public void subcriber(Subcriber s) {
        subcribers.add(s);
    }

    public void unsubcriber(Subcriber s) {
        subcribers.remove(s);
    }

    public void notifySub() {
        for (Subcriber subcriber : subcribers) {
            subcriber.update();
        }
    }
}
