package demo.bean;

import java.util.List;

public class NhaCungCap {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private List<HangHoa> hangHoa;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<HangHoa> getHangHoa() {
        return hangHoa;
    }
    public void setHangHoa(List<HangHoa> hangHoa) {
        this.hangHoa = hangHoa;
    }
    
    public NhaCungCap(Integer id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public NhaCungCap(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public NhaCungCap() {
    }
}
