package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestMetricsRepository extends CrudRepository<RequestMetrics, Long> {

    public List<RequestMetrics> findByUuid(String resource);

}
