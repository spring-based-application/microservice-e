package com.trl.microservicee.app;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/app")
public class AppController {

    private final EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public AppController(@Lazy @Qualifier("eurekaClient") EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post() {

        InstanceInfo instanceInfo = eurekaClient.getApplication(appName).getInstances().get(0);
        String result = String.format("(microservice-e)(PostMapping)(Application name: '%s')(Host: '%s')(Port: '%s')",
                instanceInfo.getAppName(), instanceInfo.getHostName(), instanceInfo.getPort());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get(@PathVariable Long id) {

        InstanceInfo instanceInfo = eurekaClient.getApplication(appName).getInstances().get(0);
        String result = String.format("(microservice-e)(GetMapping)(id: '%s')(Application name: '%s')(Host: '%s')(Port: '%s')",
                id, instanceInfo.getAppName(), instanceInfo.getHostName(), instanceInfo.getPort());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> patch(@PathVariable Long id) {

        InstanceInfo instanceInfo = eurekaClient.getApplication(appName).getInstances().get(0);
        String result = String.format("(microservice-e)(PatchMapping)(id: '%s')(Application name: '%s')(Host: '%s')(Port: '%s')",
                id, instanceInfo.getAppName(), instanceInfo.getHostName(), instanceInfo.getPort());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable Long id) {

        InstanceInfo instanceInfo = eurekaClient.getApplication(appName).getInstances().get(0);
        String result = String.format("(microservice-e)(DeleteMapping)(id: '%s')(Application name: '%s')(Host: '%s')(Port: '%s')",
                id, instanceInfo.getAppName(), instanceInfo.getHostName(), instanceInfo.getPort());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
