package jp.mufg.it.domainmodel.domain;

public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private boolean canFreeReturn;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean canFreeReturn() {
        return canFreeReturn;
    }

    public void setCanFreeReturn(boolean canFreeReturn) {
        this.canFreeReturn = canFreeReturn;
    }
}
