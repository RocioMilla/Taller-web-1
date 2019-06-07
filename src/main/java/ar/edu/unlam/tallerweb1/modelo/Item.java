package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String brand;
    
    
    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="commerce_item", joinColumns=@JoinColumn(name="itemId"), inverseJoinColumns=@JoinColumn(name="commerceId"))   
    public Set<Commerce> commerces;
    @ManyToOne
    private Category category;

    
    
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return itemId;
    }

    public void setId(Long id) {
        this.itemId = id;
    }


    public Set<Commerce> getCommerces() {
        return commerces;
    }

    public void setCommerces(Set<Commerce> commerces) {
        this.commerces = commerces;
    }
}
