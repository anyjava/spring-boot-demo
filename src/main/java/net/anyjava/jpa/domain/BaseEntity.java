package net.anyjava.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity {

    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

}

