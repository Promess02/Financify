package mikolaj.michalczyk.finance.model;

import java.util.List;

public class Indicators {
    private List<QuoteData> quote;
    private List<AdjCloseData> adjclose;

    public List<QuoteData> getQuote() {return quote;
    }

    public List<AdjCloseData> getAdjclose() {
        return adjclose;
    }
}
