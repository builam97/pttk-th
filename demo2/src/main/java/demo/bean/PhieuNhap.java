package demo.bean;

import java.util.List;

public class PhieuNhap {
    private Integer id;
    private List<HangNhap> hangNhap;
    private NhaCungCap nhaCungCap;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<HangNhap> getHangNhap() {
        return hangNhap;
    }
    public void setHangNhap(List<HangNhap> hangNhap) {
        this.hangNhap = hangNhap;
    }
    
    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }
    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    public PhieuNhap(Integer id, List<HangNhap> hangNhap) {
        super();
        this.id = id;
        this.hangNhap = hangNhap;
    }
    public PhieuNhap(List<HangNhap> hangNhap, NhaCungCap nhaCungCap) {
        super();
        this.hangNhap = hangNhap;
        this.nhaCungCap = nhaCungCap;
    }
    
    
}
