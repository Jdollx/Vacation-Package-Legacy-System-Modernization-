package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Division newDivision = divisionRepository.findById(2L).orElse(null);
        divisionRepository.save(newDivision);


        if (!customerRepository.existsById(2L)) {
            Customer bella = new Customer("Bella", "Bells", "123 Bell Drive", "12345", "1111111111", newDivision);
            customerRepository.save(bella);
            divisionRepository.save(newDivision);

            Customer ted = new Customer("Ted", "Bear", "456 Plushie Road", "54321", "2222222222", newDivision);
            customerRepository.save(ted);
            divisionRepository.save(newDivision);

            Customer rose = new Customer("Rose", "Flower", "111 Bush Road", "11111", "3333333333", newDivision);
            customerRepository.save(rose);
            divisionRepository.save(newDivision);

            Customer bob = new Customer("Bob", "Roberts", "2 Billy Drive", "22222", "4444444444", newDivision);
            customerRepository.save(bob);
            divisionRepository.save(newDivision);

            Customer sun = new Customer("Sun", "Clouds", "1 Sunshine Drive", "33333", "5555555555", newDivision);
            customerRepository.save(sun);
            divisionRepository.save(newDivision);

        }

    }
}
