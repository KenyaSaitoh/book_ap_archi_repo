package jp.mufg.it.ee.cdi.conversation;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ConversationScoped
@Named("personConversation")
public class PersonConversationBean implements Serializable {
    // UIコンポーネントの値を保持するためのプロパティ
    private Person person;
    private List<Person> personList;

    public Person getPerson() {
        if (person == null) {
            person = new Person();
        }
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonList() {
        personList = personService.getPersonList();
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    // インジェクションポイント
    @Inject
    private PersonService personService;

    // インジェクションポイント
    @Inject
    private Conversation conversation;

    // アクションメソッド（確認画面に遷移する）
    public String confirm() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        return "PersonUpdatePage?faces-redirect=true";
    }

    // アクションメソッド（人員を更新・追加する）
    public String updatePerson() {
        conversation.end();
        if (person.getPersonId() != null) {
            personService.updatePerson(person);
        } else {
            personService.addPerson(person);
        }
        return "PersonTablePage?faces-redirect=true";
    }

    // アクションメソッド（「入力画面」に戻る）
    public String back() {
        return "PersonInputPage?faces-redirect=true";
    }

    // アクションメソッド（人員を削除する）
    public String removePerson(Integer personId) {
        personService.removePerson(personId);
        return "PersonTablePage?faces-redirect=true";
    }

    // アクションメソッド（人員を編集する）
    public String editPerson(Integer personId) {
        conversation.begin();
        person = personService.getPerson(personId);
        return "PersonInputPage?faces-redirect=true";
    }

    // ヴューアクションメソッド（人員を表示する）
    public void viewAction() {
        if (person != null) {
            person = personService.getPerson(person.getPersonId());
        }
    }
}