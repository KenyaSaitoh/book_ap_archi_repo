package jp.mufg.it.ee.servlet.mvc;

public class PersonModel {
    // フィールド（状態）
    private String personName;
    private String country;
    private String message;

    // コンストラクタ
    public PersonModel(String personName, String country) {
        this.personName = personName;
        this.country = country;
    }

    // アクセサメソッド
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // ビジネスメソッド
    public void sayHello() {
        if (country != null && country.equals("japan")) {
            message = "こんにちは！私は" + personName + "です";
        } else {
            message = "Hello! I'm " + personName + ".";
        }
    }
}