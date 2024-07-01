package mikolaj.michalczyk.finance.model;

import java.util.List;

public class Meta {
    private String currency;
    private String symbol;
    private String exchangeName;
    private String fullExchangeName;
    private String instrumentType;
    private long firstTradeDate;
    private long regularMarketTime;
    private boolean hasPrePostMarketData;
    private int gmtoffset;
    private String timezone;
    private String exchangeTimezoneName;
    private double regularMarketPrice;
    private double fiftyTwoWeekHigh;
    private double fiftyTwoWeekLow;
    private double regularMarketDayHigh;
    private double regularMarketDayLow;
    private int regularMarketVolume;
    private double chartPreviousClose;
    private int priceHint;
    private CurrentTradingPeriod currentTradingPeriod;
    private String dataGranularity;
    private String range;
    private List<String> validRanges;

    public static class CurrentTradingPeriod {
        private Period pre;
        private Period regular;
        private Period post;

        public static class Period {
            private String timezone;
            private long start;
            private long end;
            private int gmtoffset;
        }

        public Period getPre() {
            return pre;
        }

        public void setPre(Period pre) {
            this.pre = pre;
        }

        public Period getRegular() {
            return regular;
        }

        public void setRegular(Period regular) {
            this.regular = regular;
        }

        public Period getPost() {
            return post;
        }

        public void setPost(Period post) {
            this.post = post;
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getFullExchangeName() {
        return fullExchangeName;
    }

    public void setFullExchangeName(String fullExchangeName) {
        this.fullExchangeName = fullExchangeName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public long getFirstTradeDate() {
        return firstTradeDate;
    }

    public void setFirstTradeDate(long firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    public long getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(long regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public boolean isHasPrePostMarketData() {
        return hasPrePostMarketData;
    }

    public void setHasPrePostMarketData(boolean hasPrePostMarketData) {
        this.hasPrePostMarketData = hasPrePostMarketData;
    }

    public int getGmtoffset() {
        return gmtoffset;
    }

    public void setGmtoffset(int gmtoffset) {
        this.gmtoffset = gmtoffset;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(double fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public void setRegularMarketDayHigh(double regularMarketDayHigh) {
        this.regularMarketDayHigh = regularMarketDayHigh;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public void setRegularMarketDayLow(double regularMarketDayLow) {
        this.regularMarketDayLow = regularMarketDayLow;
    }

    public int getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public void setRegularMarketVolume(int regularMarketVolume) {
        this.regularMarketVolume = regularMarketVolume;
    }

    public double getChartPreviousClose() {
        return chartPreviousClose;
    }

    public void setChartPreviousClose(double chartPreviousClose) {
        this.chartPreviousClose = chartPreviousClose;
    }

    public int getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(int priceHint) {
        this.priceHint = priceHint;
    }

    public CurrentTradingPeriod getCurrentTradingPeriod() {
        return currentTradingPeriod;
    }

    public void setCurrentTradingPeriod(CurrentTradingPeriod currentTradingPeriod) {
        this.currentTradingPeriod = currentTradingPeriod;
    }

    public String getDataGranularity() {
        return dataGranularity;
    }

    public void setDataGranularity(String dataGranularity) {
        this.dataGranularity = dataGranularity;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public List<String> getValidRanges() {
        return validRanges;
    }

    public void setValidRanges(List<String> validRanges) {
        this.validRanges = validRanges;
    }
}
