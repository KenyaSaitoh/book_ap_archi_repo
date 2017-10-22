package jp.mufg.it.springmvc.person;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan

// @EnableJpaRepositories(basePackages = {"jp.mufg.it.springmvc.person"},
//        entityManagerFactoryRef = "emf")
public class PersonAction {
    @Autowired
    private PersonService personService;

    // アクションメソッド（「入力画面」に遷移する）
    @RequestMapping("/create")
    public String createPerson() {
        return "PersonInputPage";
    }

    // アクションメソッド（「確認画面」に遷移する）
    @RequestMapping("/confirm")
    public String confirm(@Valid @ModelAttribute Person person,
            BindingResult errors, HttpSession session) {
        if (errors.hasErrors()) {
            return "PersonInputPage";
        }
        session.setAttribute("person", person);
        return "PersonUpdatePage";
    }

    // アクションメソッド（「入力画面」に戻る）
    @RequestMapping("/back")
    public String back() {
        return "PersonInputPage";
    }

    // アクションメソッド（人員を更新・追加する）
    @RequestMapping("/update")
    public String updatePerson(Model model, HttpSession session) {
        Person person = (Person)session.getAttribute("person");
        if (person.getPersonId() != null) { // 更新か追加を判定
            personService.updatePerson(person);
        } else {
            personService.addPerson(person);
        }
        List<Person> personList = personService.getPersonList();
        model.addAttribute("personList", personList);
        session.removeAttribute("person");
        return "PersonTablePage";
    }

    // アクションメソッド（人員を編集する）
    @RequestMapping("/edit")
    public String editPerson(@RequestParam("personId") Integer personId,
            Model model) {
        Person person = personService.getPerson(personId);
        model.addAttribute("person", person);
        return "PersonInputPage";
    }

    // アクションメソッド（人員を削除する）
    @RequestMapping("/remove")
    public String removePerson(@RequestParam("personId") Integer personId,
            Model model) {
        personService.removePerson(personId);
        List<Person> personList = personService.getPersonList();
        model.addAttribute("personList", personList);
        return "PersonTablePage";
    }

    // アクションメソッド（人員リストを表示する）
    @RequestMapping("/viewList")
    public String viewPersonList(Model model) {
        List<Person> personList = personService.getPersonList();
        model.addAttribute("personList", personList);
        return "PersonTablePage";
    }
}