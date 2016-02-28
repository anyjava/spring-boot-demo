package net.anyjava.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.anyjava.jpa.domain.item.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by anyjava on 2016. 2. 28..
 */
@Entity
@Table(name = "ORDER_ITEM")
@Data
@EqualsAndHashCode
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;


    private int orderPirce;
    private int count;

}
