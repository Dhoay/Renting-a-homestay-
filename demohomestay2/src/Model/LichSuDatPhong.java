package Model;

import java.util.Date;

public class LichSuDatPhong {
    private int id;
    private String tennguoidat;
    private String emailnguoidat;
    private String sodienthoainguoidat;
    private int idhomestay;
    private Date ngaydat;

    // Constructors, getters, and setters

    public LichSuDatPhong() {
        // Default constructor
    }

    public LichSuDatPhong(int id, String tennguoidat, String emailnguoidat, String sodienthoainguoidat, int idhomestay, Date ngaydat) {
        this.id = id;
        this.tennguoidat = tennguoidat;
        this.emailnguoidat = emailnguoidat;
        this.sodienthoainguoidat = sodienthoainguoidat;
        this.idhomestay = idhomestay;
        this.ngaydat = ngaydat;
    }

    // Add getters and setters for all properties

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettennguoidat() {
        return tennguoidat;
    }

    public void settennguoidat(String tennguoidat) {
        this.tennguoidat = tennguoidat;
    }

    public String getemailnguoidat() {
        return emailnguoidat;
    }

    public void setemailnguoidat(String emailnguoidat) {
        this.emailnguoidat = emailnguoidat;
    }

    public String getsodienthoainguoidat() {
        return sodienthoainguoidat;
    }

    public void setsodienthoainguoidat(String sodienthoainguoidat) {
        this.sodienthoainguoidat = sodienthoainguoidat;
    }

    public int getidhomestay() {
        return idhomestay;
    }

    public void setidhomestay(int idhomestay) {
        this.idhomestay = idhomestay;
    }

    public Date getngaydat() {
        return ngaydat;
    }

    public void setngaydat(Date ngaydat) {
        this.ngaydat = ngaydat;
    }
    
}
