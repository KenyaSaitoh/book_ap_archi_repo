package jp.mufg.it.ee.jsf.person;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named("personTable")
public class PersonTableBean implements Serializable {
    // 入出力値のプロパティ
    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    // フラッシュスコープ
    private Flash flash;

    // インジェクションポイント
    @Inject
    private PersonService personService;

    // アクションメソッド（人員を編集する）
    public String editPerson(Integer personId) {
        Person person = personService.getPerson(personId);
        flash.put("person", person);
        return "PersonInputPage";
    }

    // アクションメソッド（人員を削除する）
    public String removePerson(Integer personId) {
        personService.removePerson(personId);
        return "PersonTablePage";
    }

    @PostConstruct
    public void postConstruct() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        flash = facesContext.getExternalContext().getFlash();
        personList = personService.getPersonList();
    }
}