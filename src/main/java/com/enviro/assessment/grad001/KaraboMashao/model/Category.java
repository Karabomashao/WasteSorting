package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "waste_categories")
public class Category {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int categoryId;
    @Column(unique=true, nullable = false)
    @NotBlank(message = "Waste category cannot be blank")
    private String wasteCategory;

    @NotBlank(message = "Description cannot be blank")
    @Column(nullable = false)
//    @Size(min = 20)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<WasteType> wasteTypes;


    public Category() {}
    public Category(String wasteCategory, String description) {
        this.wasteCategory = wasteCategory;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }
    public String getWasteCategory() {
        return wasteCategory;
    }

    public String getDescription() {
        return description;
    }


    public void setWasteCategory(String waste_category) {
        this.wasteCategory = waste_category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
