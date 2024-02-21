package gr.hua.dit.ds.projectDSBackend.config;

import gr.hua.dit.ds.projectDSBackend.entity.*;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Farmer.class);
        config.exposeIdsFor(Supervisor.class);
        config.exposeIdsFor(Product.class);
        config.exposeIdsFor(Region.class);
        config.exposeIdsFor(Request.class);
    }
}
