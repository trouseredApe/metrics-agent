package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RequestMetricsRepository;
import repository.ResponseMetricsRepository;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
public class MetricsService {

    @Autowired
    RequestMetricsRepository requestMetricsRepository;

    @Autowired
    ResponseMetricsRepository responseMetricsRepository;

    private IntSummaryStatistics aggregateRequestMetrics(){
        IntSummaryStatistics stats = StreamSupport.stream(requestMetricsRepository.findAll().spliterator(), true)
                .mapToInt(r -> r.getProcessingTime()).summaryStatistics();
        return stats;
    }

    private IntSummaryStatistics aggregateResponseMetrics(){
        IntSummaryStatistics stats = StreamSupport.stream(responseMetricsRepository.findAll().spliterator(), true)
                .mapToInt(r -> r.getResponseSize()).summaryStatistics();
        return stats;
    }


    public Map<String, Object> generateMetrics () {
        IntSummaryStatistics requestStats = aggregateRequestMetrics();
        IntSummaryStatistics responseStats = aggregateResponseMetrics();
        Map<String, Object> metrics = new HashMap<>();

        metrics.put("maxTime", requestStats.getMax());
        metrics.put("minTime", requestStats.getMin());
        metrics.put("avgTime", requestStats.getAverage());
        metrics.put("maxSize", responseStats.getMax());
        metrics.put("minSize", responseStats.getMin());
        metrics.put("avgSize", responseStats.getAverage());

        return metrics;
    }
}
