package jp.mufg.it.springmvc.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PERSON")
public class Person {
    // ID
    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;

    // 名前
    @Column(name = "PERSON_NAME")
    @NotEmpty
    @Size(min = 1, max = 20)
    private String personName;

    // 年齢
    @Column(name = "AGE")
    @NotNull
    @Min(20)
    @Max(100)
    private Integer age;

    // 性別
    @Column(name = "GENDER")
    @NotEmpty
    private String gender;

    // コンストラクタ
    public Person() {}

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