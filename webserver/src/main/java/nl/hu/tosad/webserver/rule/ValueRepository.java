package nl.hu.tosad.webserver.rule;

import nl.hu.tosad.domain.rule.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends CrudRepository<Value, Long> {
}