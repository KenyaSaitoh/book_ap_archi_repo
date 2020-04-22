package jp.mufg.it.ee.jpa.company.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    // 郵便番号
    @Column(name = "ZIP_CODE")
    private String zipCode;
    // 市町村
    @Column(name = "CITY")
    private String city;
    // 番地
    @Column(name = "STREET")
    private String street;

    // 引数なしのコンストラクタ
    public Address() {
    }

    // コンストラクタ
    public Address(String zipCode, String city, String street) {
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
    }

    // 郵便番号へのアクセサメソッド
    @Column(name = "ZIP_CODE")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // 市町村へのアクセサメソッド
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // 番地へのアクセサメソッド
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}