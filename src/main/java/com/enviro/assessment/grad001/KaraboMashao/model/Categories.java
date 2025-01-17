package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "waste_categories")
public class Categories {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private int categoryId;
    private String wasteCategory;


    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<WasteTypes> wasteTypes;

    public int getCategoryId() {
        return categoryId;
    }
    public String getWasteCategory() {
        return wasteCategory;
    }

    public String getDescription() {
        return description;
    }

    private String description;

    public void setWasteCategory(String waste_category) {
        this.wasteCategory = waste_category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
