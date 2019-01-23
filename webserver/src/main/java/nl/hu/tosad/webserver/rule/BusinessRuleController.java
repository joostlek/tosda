package nl.hu.tosad.webserver.rule;

import nl.hu.tosad.domain.ruletype.Template;
import nl.hu.tosad.domain.target_database.Dialect;
import nl.hu.tosad.webserver.ruletype.BusinessRuleTypeRepository;
import nl.hu.tosad.webserver.ruletype.TemplateRepository;
import nl.hu.tosad.webserver.target_database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusinessRuleController {
    @Autowired
    BusinessRuleServiceInterface businessRuleService;

    @Autowired
    DatabaseService databaseService;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private BusinessRuleTypeRepository businessRuleTypeRepository;



    @GetMapping("/")
    public String ruleList(Model model) {
        model.addAttribute("businessRules", businessRuleService.getAllBusinessRules());
        return "ruleList";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("templates", templateRepository.findAll());
        model.addAttribute("chosenRule", new ChosenRuleTypeDTO());
        return "add";
    }

    @PostMapping("/addType")
    public String addType(@ModelAttribute ChosenRuleTypeDTO brtc, Model model) {
        Dialect dialect = databaseService.getDialectbyID((long) 1);
        Template template = businessRuleTypeRepository.findBusinessRuleTypeByCode(brtc.getBusinessRuleTypeCode()).getTemplate(dialect);
        model.addAttribute("chosenType", template.getAttributes());
        return "fillRule";
    }


}
