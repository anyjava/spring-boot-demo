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
@DiscriminatorValue("B")
@EqualsAndHashCode(callSuper = true)
public class Book extends Item {

    private String author;
    private String isbn;
}
