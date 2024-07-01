package mikolaj.michalczyk.finance.model;

import java.util.List;

public class Result {
    private Meta meta;
    private List<Long> timestamp;
    private Indicators indicators;

    public Meta getMeta() {
        return meta;
    }

    public List<Long> getTimestamp() {
        return timestamp;
    }

    public Indicators getIndicators() {
        return indicators;
    }
}
