package lk.ijse.absd.dto;

public class ItemDTO {

    private String code;
    private String decription;
    private double price;
    private int qty;
    private double amount;

    public ItemDTO() {
    }

    public ItemDTO(String code, String decription, double price, int qty, double amount) {
        System.out.println("******itemdto constructer*******");
        this.setCode(code);
        this.setDescription(decription);
        this.setPrice(price);
        this.setQty(qty);
    }

    public ItemDTO(String code, String decription, double price, int qty) {
        this.code = code;
        this.decription = decription;
        this.price = price;
        this.qty = qty;
    }

    public void setQty(int qty) {

        this.qty=qty;
    }
    public int getQty() {
        return this.qty;
    }



    public double getAmount() {
        System.out.println("******itemdto amount getter*******");
        return amount;
    }

    public void setAmount(double amount) {
        System.out.println("******itemdto amount setter*******");
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price=price;
    }
    public double getPrice() {
        return this.price;
    }

    public String getDescription() {

        return this.decription;
    }
    public void setDescription(String decription) {
        this.decription=decription;
    }

    public void setCode(String code) {
        this.code=code;
    }

    public String getCode() {

        return this.code;
    }


    @Override
    public String toString() {
        return "ItemDTO{" +
                "code='" + code + '\'' +
                ", decription='" + decription + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}