package net.anyjava.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Created by anyjava on 2016. 2. 28..
 */
@Embeddable
@Data
@NoArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipcode;

}

