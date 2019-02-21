package repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ResponseMetrics {

    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    private String resource;
    private Integer responseSize;

    public ResponseMetrics(String uuid, String resource, Integer responseSize) {
        this.uuid = uuid;
        this.resource = resource;
        this.responseSize = responseSize;
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

    public Integer getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(Integer responseSize) {
        this.responseSize = responseSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseMetrics that = (ResponseMetrics) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(resource, that.resource) &&
                Objects.equals(responseSize, that.responseSize);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, resource, responseSize);
    }
}
