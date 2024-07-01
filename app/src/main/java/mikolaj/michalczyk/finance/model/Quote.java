package mikolaj.michalczyk.finance.model;

public class Quote {
    private String exchange;
    private String shortname;
    private String quoteType;
    private String symbol;
    private String index;
    private double score;
    private String typeDisp;
    private String longname;
    private String exchDisp;
    private String sector;
    private String sectorDisp;
    private String industry;
    private String industryDisp;
    private Boolean dispSecIndFlag;
    private boolean isYahooFinance;


    public Quote() {
    }

    public Quote(String exchange, String shortname, String quoteType, String symbol, String index, double score, String typeDisp, String longname, String exchDisp, String sector, String sectorDisp, String industry, String industryDisp, Boolean dispSecIndFlag, boolean isYahooFinance) {
        this.exchange = exchange;
        this.shortname = shortname;
        this.quoteType = quoteType;
        this.symbol = symbol;
        this.index = index;
        this.score = score;
        this.typeDisp = typeDisp;
        this.longname = longname;
        this.exchDisp = exchDisp;
        this.sector = sector;
        this.sectorDisp = sectorDisp;
        this.industry = industry;
        this.industryDisp = industryDisp;
        this.dispSecIndFlag = dispSecIndFlag;
        this.isYahooFinance = isYahooFinance;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getTypeDisp() {
        return typeDisp;
    }

    public void setTypeDisp(String typeDisp) {
        this.typeDisp = typeDisp;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getExchDisp() {
        return exchDisp;
    }

    public void setExchDisp(String exchDisp) {
        this.exchDisp = exchDisp;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSectorDisp() {
        return sectorDisp;
    }

    public void setSectorDisp(String sectorDisp) {
        this.sectorDisp = sectorDisp;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustryDisp() {
        return industryDisp;
    }

    public void setIndustryDisp(String industryDisp) {
        this.industryDisp = industryDisp;
    }

    public Boolean getDispSecIndFlag() {
        return dispSecIndFlag;
    }

    public void setDispSecIndFlag(Boolean dispSecIndFlag) {
        this.dispSecIndFlag = dispSecIndFlag;
    }

    public boolean isYahooFinance() {
        return isYahooFinance;
    }

    public void setYahooFinance(boolean yahooFinance) {
        isYahooFinance = yahooFinance;
    }
}

