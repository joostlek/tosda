package nl.hu.tosad.webserver.target_database;

import nl.hu.tosad.domain.target_database.DbTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends CrudRepository<DbTable, Long> {

    List<DbTable> findAll();
}
