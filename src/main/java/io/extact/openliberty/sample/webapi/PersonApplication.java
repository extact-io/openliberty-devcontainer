package io.extact.openliberty.sample.webapi;

import java.util.Set;

import io.extact.openliberty.sample.webapi.resource.PersonResourceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("api")
public class PersonApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(
                PersonResourceImpl.class,
                PersonExceptionMapper.class);
    }
}
