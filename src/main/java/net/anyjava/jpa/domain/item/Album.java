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
@DiscriminatorValue("A")
@EqualsAndHashCode(callSuper = true)
public class Album extends Item {

    private String artist;
    private String etc;

}
