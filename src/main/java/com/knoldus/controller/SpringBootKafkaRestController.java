package com.knoldus.controller;

import com.knoldus.producer.SpringBootKafkaProducer;
import com.knoldus.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringBootKafkaRestController {

    @Autowired
    SpringBootKafkaProducer springBootKafkaProducer;

    @GetMapping(value = "/send/{message}")
    public void send(@PathVariable String message) {
        springBootKafkaProducer.sendMessage(message);
    }

    @PostMapping(value = "/send")
    public void send(@RequestBody Tutorial tutorial) {
        springBootKafkaProducer.sendMessage(tutorial);
    }

}
