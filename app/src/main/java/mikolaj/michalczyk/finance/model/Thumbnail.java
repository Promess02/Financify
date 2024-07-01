package mikolaj.michalczyk.finance.model;

import java.util.List;

class Thumbnail {
    private List<Resolution> resolutions;

    // Getters and setters for all fields (omitted for brevity)
    // ...


    public Thumbnail() {
    }

    public Thumbnail(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    public List<Resolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }
}