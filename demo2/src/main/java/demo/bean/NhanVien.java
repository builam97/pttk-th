package demo.bean;

import java.util.List;

public class NhanVien {
    private Integer id;
    
    private List<PhieuNhap> phieuNhap;
    private Account account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PhieuNhap> getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(List<PhieuNhap> phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public NhanVien(Integer id, List<PhieuNhap> phieuNhap) {
        super();
        this.id = id;
        this.phieuNhap = phieuNhap;
    }
}
