package case_study.entity;

public class Coord {
    private double lon;
    private double lat;
    public Coord() {}
    public Coord(int lon, int lat) {
        this.lon = lon;
        this.lat = lat;
    }
    public double getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }
}
