package demo.bean;

public class NhanVien {
    private Integer id;
    
    private Account account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public NhanVien(Integer id) {
        super();
        this.id = id;
    }
}
