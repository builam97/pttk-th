package demo.bean;

public class HangHoa {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer amount;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public HangHoa(Integer id, String name, String description, Double price, Integer amount) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
    public HangHoa(String name, String description, Double price, Integer amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
    public HangHoa() {
    }
    
}
