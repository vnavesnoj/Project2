package last1k.controller;

import last1k.ReadDto.PersonReadDto;
import last1k.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"person"})
public class PeopleController {
    @Autowired
    private PeopleService peopleService;
    @GetMapping("/people/new")
    public String createAccountPage() {
        return "createPerson";
    }

    @PostMapping("/people/new")
    public String createAccount(PersonReadDto personReadDto, Model model) {
        model.addAttribute("person", peopleService.createPerson(personReadDto));
        return "redirect:/people/%s/edit".formatted(personReadDto.getFullName());
    }

    @GetMapping("/people/{fullName}/edit")
    public String editAccountPage(@PathVariable String fullName, Model model) {
        model.addAttribute("person", peopleService.findByFullname(fullName));
        return "editPerson";
    }

    @PostMapping("/people/{fullName}/edit")
    public String editAccount(PersonReadDto personReadDto, Model model) {
        model.addAttribute("person", peopleService.updatePerson(personReadDto));
        return "redirect:/people/%s/edit".formatted(personReadDto.getFullName());
    }

    @GetMapping("/people")
    public String peoplePage(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "people";
    }
}
