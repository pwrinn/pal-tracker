package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String PORT;
    private String MEMORY_LIMIT;
    private String CF_INSTANCE_INDEX;
    private String CF_INSTANCE_ADDR;

    public EnvController(@Value("${port:NOT SET}") String PORT,
                         @Value("${memory.limit:NOT SET}") String MEMORY_LIMIT,
                         @Value("${cf.instance.index:NOT SET}") String CF_INSTANCE_INDEX,
                         @Value("${cf.instance.addr:NOT SET}") String CF_INSTANCE_ADDR) {
        this.PORT = PORT;
        this.MEMORY_LIMIT = MEMORY_LIMIT;
        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map envMap = new HashMap<>();
        envMap.put("PORT" ,this.PORT);
        envMap.put("MEMORY_LIMIT", this.MEMORY_LIMIT);
        envMap.put("CF_INSTANCE_INDEX", this.CF_INSTANCE_INDEX);
        envMap.put("CF_INSTANCE_ADDR", this.CF_INSTANCE_ADDR);

       return envMap;
    }
}
