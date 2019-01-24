package nl.hu.tosad.webserver.rule;

import nl.hu.tosad.domain.rule.BusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessRuleService implements BusinessRuleServiceInterface {

    private final BusinessRuleRepository businessRuleRepository;

    @Autowired
    public BusinessRuleService(BusinessRuleRepository businessRuleRepository) {
        this.businessRuleRepository = businessRuleRepository;
    }

    @Override
    public BusinessRule getBusinessRuleById(Long id) {
        return businessRuleRepository.findById(id).orElse(null);
    }

    @Override
    public BusinessRule saveBusinessRule(BusinessRule businessRule) {
        return businessRuleRepository.save(businessRule);
    }

    public List<BusinessRule> getAllBusinessRulesByDb(Long dbId){
        List<BusinessRule> businessRules = businessRuleRepository.findAll();
        List<BusinessRule> businessRulesFinal = new ArrayList();
        for(BusinessRule br : businessRules) {

            if(br.getDatabase().getId() == dbId){
                businessRulesFinal.add(br);
            }
        }
        return businessRulesFinal;
    }
    @Override
    public List<BusinessRule> getAllBusinessRules() {
        return businessRuleRepository.findAll();
    }
}
