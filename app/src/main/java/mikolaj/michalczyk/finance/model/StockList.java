package mikolaj.michalczyk.finance.model;

import java.util.List;

public class StockList {
    private List<Object> explains;
    private int count;
    private List<Quote> quotes;
    private List<News> news;
    private List<Object> nav;
    private List<Object> lists;
    private List<Object> researchReports;
    private List<Object> screenerFieldResults;
    private int totalTime;
    private int timeTakenForQuotes;
    private int timeTakenForNews;
    private int timeTakenForAlgowatchlist;
    private int timeTakenForPredefinedScreener;
    private int timeTakenForCrunchbase;
    private int timeTakenForNav;
    private int timeTakenForResearchReports;
    private int timeTakenForScreenerField;
    private int timeTakenForCulturalAssets;

    // Getters and setters for all fields (omitted for brevity)
    // ...


    public StockList() {
    }

    public StockList(List<Object> explains, int count, List<Quote> quotes, List<News> news, List<Object> nav, List<Object> lists, List<Object> researchReports, List<Object> screenerFieldResults, int totalTime, int timeTakenForQuotes, int timeTakenForNews, int timeTakenForAlgowatchlist, int timeTakenForPredefinedScreener, int timeTakenForCrunchbase, int timeTakenForNav, int timeTakenForResearchReports, int timeTakenForScreenerField, int timeTakenForCulturalAssets) {
        this.explains = explains;
        this.count = count;
        this.quotes = quotes;
        this.news = news;
        this.nav = nav;
        this.lists = lists;
        this.researchReports = researchReports;
        this.screenerFieldResults = screenerFieldResults;
        this.totalTime = totalTime;
        this.timeTakenForQuotes = timeTakenForQuotes;
        this.timeTakenForNews = timeTakenForNews;
        this.timeTakenForAlgowatchlist = timeTakenForAlgowatchlist;
        this.timeTakenForPredefinedScreener = timeTakenForPredefinedScreener;
        this.timeTakenForCrunchbase = timeTakenForCrunchbase;
        this.timeTakenForNav = timeTakenForNav;
        this.timeTakenForResearchReports = timeTakenForResearchReports;
        this.timeTakenForScreenerField = timeTakenForScreenerField;
        this.timeTakenForCulturalAssets = timeTakenForCulturalAssets;
    }

    public List<Object> getExplains() {
        return explains;
    }

    public void setExplains(List<Object> explains) {
        this.explains = explains;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Object> getNav() {
        return nav;
    }

    public void setNav(List<Object> nav) {
        this.nav = nav;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public List<Object> getResearchReports() {
        return researchReports;
    }

    public void setResearchReports(List<Object> researchReports) {
        this.researchReports = researchReports;
    }

    public List<Object> getScreenerFieldResults() {
        return screenerFieldResults;
    }

    public void setScreenerFieldResults(List<Object> screenerFieldResults) {
        this.screenerFieldResults = screenerFieldResults;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTimeTakenForQuotes() {
        return timeTakenForQuotes;
    }

    public void setTimeTakenForQuotes(int timeTakenForQuotes) {
        this.timeTakenForQuotes = timeTakenForQuotes;
    }

    public int getTimeTakenForNews() {
        return timeTakenForNews;
    }

    public void setTimeTakenForNews(int timeTakenForNews) {
        this.timeTakenForNews = timeTakenForNews;
    }

    public int getTimeTakenForAlgowatchlist() {
        return timeTakenForAlgowatchlist;
    }

    public void setTimeTakenForAlgowatchlist(int timeTakenForAlgowatchlist) {
        this.timeTakenForAlgowatchlist = timeTakenForAlgowatchlist;
    }

    public int getTimeTakenForPredefinedScreener() {
        return timeTakenForPredefinedScreener;
    }

    public void setTimeTakenForPredefinedScreener(int timeTakenForPredefinedScreener) {
        this.timeTakenForPredefinedScreener = timeTakenForPredefinedScreener;
    }

    public int getTimeTakenForCrunchbase() {
        return timeTakenForCrunchbase;
    }

    public void setTimeTakenForCrunchbase(int timeTakenForCrunchbase) {
        this.timeTakenForCrunchbase = timeTakenForCrunchbase;
    }

    public int getTimeTakenForNav() {
        return timeTakenForNav;
    }

    public void setTimeTakenForNav(int timeTakenForNav) {
        this.timeTakenForNav = timeTakenForNav;
    }

    public int getTimeTakenForResearchReports() {
        return timeTakenForResearchReports;
    }

    public void setTimeTakenForResearchReports(int timeTakenForResearchReports) {
        this.timeTakenForResearchReports = timeTakenForResearchReports;
    }

    public int getTimeTakenForScreenerField() {
        return timeTakenForScreenerField;
    }

    public void setTimeTakenForScreenerField(int timeTakenForScreenerField) {
        this.timeTakenForScreenerField = timeTakenForScreenerField;
    }

    public int getTimeTakenForCulturalAssets() {
        return timeTakenForCulturalAssets;
    }

    public void setTimeTakenForCulturalAssets(int timeTakenForCulturalAssets) {
        this.timeTakenForCulturalAssets = timeTakenForCulturalAssets;
    }
}
