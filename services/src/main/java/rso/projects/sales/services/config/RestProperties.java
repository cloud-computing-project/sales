package rso.projects.sales.services.config;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigBundle("rest-properties")
public class RestProperties {

    @ConfigValue(value = "external-services.sale-service.enabled", watch = true)
    private boolean saleServiceEnabled;

    public boolean isSaleServiceEnabled() {
        return saleServiceEnabled;
    }

    public void setSaleServiceEnabled(boolean saleServiceEnabled) {
        this.saleServiceEnabled = saleServiceEnabled;
    }
}
