package rso.projects.sales.api.v1;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import com.kumuluz.ee.discovery.annotations.RegisterService;

@ApplicationPath("/v1")
@RegisterService
public class SalesApplication extends Application{
}
