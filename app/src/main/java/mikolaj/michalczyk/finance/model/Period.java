package mikolaj.michalczyk.finance.model;

public class Period {
    private String timezone;
    private long start;
    private long end;
    private int gmtoffset;

    public String getTimezone() {
        return timezone;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public int getGmtoffset() {
        return gmtoffset;
    }
}
