package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Menu menu;

    private BigDecimal value;

    private Integer quantity;


    public OrderMenu(Order order, Menu menu, Integer quantity) {
        this.order = order;
        this.menu = menu;
        this.quantity = quantity;
        this.value = menu.getValue();
    }

    public OrderMenu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "id=" + id +
                ", order=" + order +
                ", menu=" + menu +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
