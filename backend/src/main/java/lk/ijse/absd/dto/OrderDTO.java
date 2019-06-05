package lk.ijse.absd.dto;



public class OrderDTO {


    private String oid;
    private CustomerDTO customer;
    private String date;

    public OrderDTO() {
    }

    public OrderDTO(String oid, CustomerDTO customer, String date) {
        this.setOid(oid);
        this.setDate(date);
        this.setCustomerDTO(customer);
    }

    public void setOid(String oid) {

        this.oid=oid;
    }
    public String getOid() {
        return this.oid;
    }

    public void setCustomerDTO(CustomerDTO customer) {

        this.customer=customer;
    }
    public CustomerDTO getCustomer() {

        return this.customer;
    }

    public String getDate() {

        return this.date;
    }
    public void setDate(String date)
    {
        this.date=date;
    }




    @Override
    public String toString() {
        return "OrderDTO{" +
                "oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}