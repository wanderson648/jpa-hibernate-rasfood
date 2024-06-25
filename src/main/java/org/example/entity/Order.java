package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal totalValue;

    @Column(name = "data_criacao")
    private LocalDateTime dtCreation = LocalDateTime.now();

    @ManyToOne
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "ordens_cardapio",
            joinColumns = @JoinColumn(name = "ordens_id"),
            inverseJoinColumns = @JoinColumn(name = "cardapio_id")
    )
    private List<Menu> menuList;

    public Order() {
    }

    public Order(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDateTime getDtCreation() {
        return dtCreation;
    }

    public void setDtCreation(LocalDateTime dtCreation) {
        this.dtCreation = dtCreation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalValue=" + totalValue +
                ", dtCreation=" + dtCreation +
                ", client=" + client +
                '}';
    }
}
