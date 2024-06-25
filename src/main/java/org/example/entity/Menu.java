package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cardapio")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Boolean available;

    private BigDecimal value;
    @Column(name = "dt_registered")
    private LocalDateTime dtRegistered = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category category;

    public Menu() {
    }

    public Menu(String name, String description, Boolean available, BigDecimal value, LocalDateTime dtRegistered, Category category) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.value = value;
        this.dtRegistered = dtRegistered;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getDtRegistered() {
        return dtRegistered;
    }

    public void setDtRegistered(LocalDateTime dtRegistered) {
        this.dtRegistered = dtRegistered;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", value=" + value +
                ", dtRegistered=" + dtRegistered +
                ", category=" + category +
                '}';
    }
}
