package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity@Table(name="divisions")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    @Column(name = "country_id")
    private Long country_id;

    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers;

    public void add(Customer customer) {
        if (customer != null) {
            if (customers == null) {
                customers = new HashSet<>();
            }
            customers.add(customer);
            customer.setDivision(this);
        }
    }
}

