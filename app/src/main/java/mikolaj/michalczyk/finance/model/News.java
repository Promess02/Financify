package mikolaj.michalczyk.finance.model;

import java.util.List;

class News {
    private String uuid;
    private String title;
    private String publisher;
    private String link;
    private long providerPublishTime;
    private String type;
    private Thumbnail thumbnail;
    private List<String> relatedTickers;

    // Getters and setters for all fields (omitted for brevity)
    // ...

    public News() {
    }

    public News(String uuid, String title, String publisher, String link, long providerPublishTime, String type, Thumbnail thumbnail, List<String> relatedTickers) {
        this.uuid = uuid;
        this.title = title;
        this.publisher = publisher;
        this.link = link;
        this.providerPublishTime = providerPublishTime;
        this.type = type;
        this.thumbnail = thumbnail;
        this.relatedTickers = relatedTickers;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getProviderPublishTime() {
        return providerPublishTime;
    }

    public void setProviderPublishTime(long providerPublishTime) {
        this.providerPublishTime = providerPublishTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getRelatedTickers() {
        return relatedTickers;
    }

    public void setRelatedTickers(List<String> relatedTickers) {
        this.relatedTickers = relatedTickers;
    }
}
