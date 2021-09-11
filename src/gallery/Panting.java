package gallery;

public class Panting {
    private String artist;
    private String title;
    private double purchase_price;
    private double selling_price;
    private int year;

    // constructor
    public Panting(String artist, String title, double purchase_price, double selling_price, int year) {
        this.artist = artist;
        this.title = title;
        this.purchase_price = purchase_price;
        this.selling_price = selling_price;
        this.year = year;
    }

    // getter and setter methods
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



}
