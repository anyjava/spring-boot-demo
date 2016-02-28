package net.anyjava.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * Created by anyjava on 2016. 2. 28..
 */
@Setter
@Getter
@MappedSuperclass
public class BaseEntity {

    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

}

