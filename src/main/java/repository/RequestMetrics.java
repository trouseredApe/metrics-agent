package repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name ="REQUEST_METRICS")
public class RequestMetrics {

    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    private String resource;
    private Long processingTime;

    public RequestMetrics(String uuid, String resource, Long processingTime) {
        this.uuid = uuid;
        this.resource = resource;
        this.processingTime = processingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Long processingTime) {
        this.processingTime = processingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestMetrics that = (RequestMetrics) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(resource, that.resource) &&
                Objects.equals(processingTime, that.processingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, resource, processingTime);
    }
}
