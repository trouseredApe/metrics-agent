package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseMetricsRepository extends CrudRepository<ResponseMetrics, Long> {

    public List<ResponseMetrics> findByUuid(String resource);

}
