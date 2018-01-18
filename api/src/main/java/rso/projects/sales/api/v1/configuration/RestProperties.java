package rso.projects.sales.api.v1.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ConfigBundle("rest-properties")
@ApplicationScoped
public class RestProperties {

    @JsonProperty("healthy")
    private boolean healthy;

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    @ConfigValue(value = "external-services.sale-service.enabled", watch = true)
    private boolean saleServiceEnabled;

    @ConfigValue(value = "testVar", watch = true)
    private boolean test;

    public boolean isSaleServiceEnabled() {
        return saleServiceEnabled;
    }

    public void setSaleServiceEnabled(boolean saleServiceEnabled) {
        this.saleServiceEnabled = saleServiceEnabled;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}
