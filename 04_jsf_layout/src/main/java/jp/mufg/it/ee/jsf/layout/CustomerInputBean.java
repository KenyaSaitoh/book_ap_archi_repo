package jp.mufg.it.ee.jsf.layout;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("customerInput")
public class CustomerInputBean implements Serializable {
    private String customerName;
    private String gender;
    private Integer age;
    private Date birthday;

    // 顧客名へのアクセサメソッド
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // 性別へのアクセサメソッド
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // 年齢へのアクセサメソッド
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    // 生年月日へのアクセサメソッド
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}