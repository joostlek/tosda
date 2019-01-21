package nl.hu.tosad.webserver.databases;

import nl.hu.tosad.domain.ruletype.Operator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, Long> {
}
