package com.possible.crm.bootstrapData;

import com.possible.crm.model.Contact;
import com.possible.crm.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private ContactRepository repository;

    @Autowired
    public DataLoader(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Contact firstContact = new Contact("Joe", "Don", "joe@gmal.cpm");
        repository.save(firstContact);

        System.out.println(repository.findAll());
    }
}
