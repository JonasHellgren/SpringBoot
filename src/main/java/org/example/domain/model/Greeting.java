package org.example.domain.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.domain.api.GreetingController;

//src/main/java/org/example/config/log4j.properties

public class Greeting {
//Thanks to the Jackson JSON library we can marshal instances of type Greeting into JSON
    private static Logger logger = LogManager.getLogger(Greeting.class);
    private final long id;
    private final String name;
    public Greeting(long id, String name) {
        this.id = id;      this.name = name;
        logger.info("Greeting created."+" id:" +id+", name:"+name);
    }
    //Following getters are needed for spring to extract id and name field when sending as json
    public long getId() {  logger.debug("getId called");  return id;   }
    public String getName() {  logger.debug("getContent called"); return name;    }
}