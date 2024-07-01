package mikolaj.michalczyk.finance.model;

import java.util.List;

public class QuoteData {
    private List<Double> volume;
    private List<Double> open;
    private List<Double> low;
    private List<Double> high;
    private List<Double> close;

    public List<Double> getVolume() {
        return volume;
    }

    public List<Double> getOpen() {
        return open;
    }

    public List<Double> getLow() {
        return low;
    }

    public List<Double> getHigh() {
        return high;
    }

    public List<Double> getClose() {
        return close;
    }
}
