package nl.hu.tosad.webserver.rule;

        import nl.hu.tosad.domain.rule.BusinessRule;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface BusinessRuleRepository extends CrudRepository<BusinessRule, Long> {
    Optional<BusinessRule> findById(Long id);

    List<BusinessRule> findAll();
}