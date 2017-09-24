package jp.mufg.it.ee.jsf.person;

public class Person {
    // IDフィールド
    private Integer personId;
    // 名前フィールド
    private String personName;
    // 年齢フィールド
    private Integer age;
    // 性別フィールド
    private String gender;

    // コンストラクタ
    public Person() {
    };

    public Person(Integer personId, String personName, Integer age,
            String gender) {
        this.personId = personId;
        this.personName = personName;
        this.age = age;
        this.gender = gender;
    }

    public Person(String personName, Integer age, String gender) {
        this.personName = personName;
        this.age = age;
        this.gender = gender;
    }

    // IDへのアクセサメソッド
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    // 名前へのアクセサメソッド
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    @Override
    public String toString() {
        return "Person [personId=" + personId + ", personName=" + personName
                + ", age=" + age + ", gender=" + gender + "]";
    }
}