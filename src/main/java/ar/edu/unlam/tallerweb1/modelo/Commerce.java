package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commerce_id;
    private String name;
    private Double latitude;
    private Double longitude;


	@OneToMany(mappedBy = "commerce")
    private Set<ItemCommerceImpl> itemCommerceImpls = new HashSet<>();
 
    private Double averageRanking;

	@Transient
    private Long distance;

    public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public Commerce() {
    }

    public Commerce(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getCommerce_id() {
        return commerce_id;
    }

    public void setCommerce_id(Long commerce_id) {
        this.commerce_id = commerce_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ItemCommerceImpl> getItemCommerceImpls(){
        return itemCommerceImpls;
    }

    public void setItemCommerceImpls(Set<ItemCommerceImpl> commerces){
        this.itemCommerceImpls = commerces;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Set<Item> getItems(){
        Set<Item> result = new HashSet<>();

        for (ItemCommerceImpl itemCommerceImpl : itemCommerceImpls){
            result.add(itemCommerceImpl.getItem());
        }

        return result;
    }
    
	public Double getAverageRanking() {
		return averageRanking;
	}

	public void setAverageRanking(Double averageRanking) {
		 this.averageRanking = averageRanking;
		
	}
}