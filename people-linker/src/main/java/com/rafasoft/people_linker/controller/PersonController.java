package com.rafasoft.people_linker.controller;

import com.rafasoft.people_linker.model.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/person")
@Log4j2
public class PersonController {

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable String id) {
        log.info("Called for id {}", id);
        return Mono.just(new Person("Jaime", "Gomez"));
    }

    @GetMapping()
    public Mono<List<Person>> getPersons() {
        log.info("Retrieving all people");
        return Mono
                .just(List.of(
                        new Person("Jaime", "Gomez"),
                        new Person("Juan", "Perez")));
    }
}
