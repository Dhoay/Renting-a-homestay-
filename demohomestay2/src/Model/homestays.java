package Model;

public class homestays {
    private int id;
    private String ten;
    private String diachi;
    private String dienthoai;
    private String email;
    private String anh;
    private String mota;
    private int gia;
    private String tiennghi;
    private String dichVu;

    public homestays() {
        // Constructor mặc định
    }

    public homestays(int id, String ten, String diachi, String dienthoai, String email, String anh, String mota, int gia, String tiennghi, String dichVu) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.email = email;
        this.anh = anh;
        this.mota = mota;
        this.gia = gia;
        this.tiennghi = tiennghi;
        this.dichVu = dichVu;
    }
    
    public homestays(String ten, String diachi, String dienthoai, String email, String anh, String mota, int gia, String tiennghi, String dichVu) {
        this.ten = ten;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.email = email;
        this.anh = anh;
        this.mota = mota;
        this.gia = gia;
        this.tiennghi = tiennghi;
        this.dichVu = dichVu;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getdiachi() {
        return diachi;
    }

    public void setdiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getdienthoai() {
        return dienthoai;
    }

    public void setdienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getmota() {
        return mota;
    }

    public void setmota(String mota) {
        this.mota = mota;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String gettiennghi() {
        return tiennghi;
    }

    public void settiennghi(String tiennghi) {
        this.tiennghi = tiennghi;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }
}
