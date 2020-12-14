package pl.com.janeck.model;



public class Movie {

    private Long id;
    private String title;
    private int year;
    private String producer;


    public Movie(String title, int year, String producer) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    public Movie(Long id, String title, int year, String producer) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
