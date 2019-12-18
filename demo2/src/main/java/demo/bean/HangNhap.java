package demo.bean;

public class HangNhap {
    private Integer id;
    private String dateNhap;
    private HangHoa hangHoa;
    private Integer amount;
    private Double price;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDateNhap() {
        return dateNhap;
    }
    public void setDateNhap(String dateNhap) {
        this.dateNhap = dateNhap;
    }
    
   
    public HangHoa getHangHoa() {
        return hangHoa;
    }
    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }
    
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public HangNhap(Integer id, String dateNhap) {
        super();
        this.id = id;
        this.dateNhap = dateNhap;
    }
    public HangNhap(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }
    
}
