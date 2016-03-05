package net.anyjava.jpa.domain.item;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by anyjava on 2016. 2. 28..
 */
@Entity
@Data
@DiscriminatorValue("M")
@EqualsAndHashCode(callSuper = true)
public class Movie extends Item {

    private String director;
    private String actor;
}
