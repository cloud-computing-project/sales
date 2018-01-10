package rso.projects.sales.api.v1.health;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import rso.projects.sales.api.v1.configuration.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Health
@ApplicationScoped
public class SaleServiceHealthCheck implements HealthCheck{

    @Inject
    private RestProperties restProperties;

    @Override
    public HealthCheckResponse call() {

        if (restProperties.isHealthy()) {
            return HealthCheckResponse.named(SaleServiceHealthCheck.class.getSimpleName()).up().build();
        } else {
            return HealthCheckResponse.named(SaleServiceHealthCheck.class.getSimpleName()).down().build();
        }

    }
}
