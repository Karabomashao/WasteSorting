package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "waste_types")
public class WasteType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wasteId;

    @NotBlank(message = "Type of waste cannot be blank")
    @Column(nullable = false, unique = true)
    private String typeOfWaste;

    @NotBlank(message = "Waste example of waste cannot be blank")
    @Column(nullable = false)
    private String wasteExample;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "wasteType", cascade = CascadeType.ALL)
    private List<DisposalGuideline> disposalGuidelineList;

    @OneToMany(mappedBy = "wasteType", cascade = CascadeType.ALL)
    private List<RecyclingTip> recyclingTipList;

    public WasteType(String typeOfWaste, String wasteExample){
        this.typeOfWaste = typeOfWaste.toLowerCase();
        this.wasteExample = wasteExample.toLowerCase();
    }

    public WasteType(){}

    public int getWasteId() {
        return wasteId;
    }

    public String getTypeOfWaste() {
        return typeOfWaste.toLowerCase();
    }

    public String getWasteExample() {
        return wasteExample.toLowerCase();
    }

    public Category getCategory() {
        return category;
    }

    public void setTypeOfWaste(String typeOfWaste) {
        this.typeOfWaste = typeOfWaste;
    }

    public void setWasteExample(String wasteExample) {
        this.wasteExample = wasteExample.toLowerCase();
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
