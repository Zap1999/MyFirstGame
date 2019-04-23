package CurrencyPackage;

import java.io.Serializable;

public abstract class Currency implements Serializable {

    long value;

    public Currency (int val) {
        value = val;
    }

    void setValue(int val) {
        value = val;
    }
    long getValue() {
        return value;
    }
    void add(int val) {
        value += val;
    }
    void reduce(int val) {
        value -= val;
    }

}
