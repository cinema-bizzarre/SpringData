package module;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor


public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
   private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product() {
    }

    public void incrementPrice(int amount) {
        price +=amount;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String getNameCategory() {
        return this.getName();
    }
}
