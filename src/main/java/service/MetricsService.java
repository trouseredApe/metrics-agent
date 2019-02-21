package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RequestMetricsRepository;
import repository.ResponseMetricsRepository;
import java.util.LongSummaryStatistics;
import java.util.stream.StreamSupport;

@Service
public class MetricsService {

    @Autowired
    RequestMetricsRepository requestMetricsRepository;

    @Autowired
    ResponseMetricsRepository responseMetricsRepository;

    public LongSummaryStatistics aggregateRequestMetrics(){
        // get stats related to min, max and average in a single pass
        LongSummaryStatistics stats = StreamSupport.stream(requestMetricsRepository.findAll().spliterator(), true)
                .mapToLong(r -> r.getProcessingTime()).summaryStatistics();
        System.out.println("min: " + stats.getMin() + ", max: " + stats.getMax() + ", avg: " + stats.getAverage());
        return stats;
    }



    public String aggregateResponseMetrics(){
        return null;
    }

}
