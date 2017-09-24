package jp.mufg.it.domainmodel.dto;

public class CustomerDTO {
    private Integer id;
    private String name;
    private Integer customerType;
    private String address;
    private Integer point;

    public CustomerDTO(String name, Integer customerType, String address,
            Integer point) {
        this.name = name;
        this.customerType = customerType;
        this.address = address;
        this.point = point;
    }

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

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
