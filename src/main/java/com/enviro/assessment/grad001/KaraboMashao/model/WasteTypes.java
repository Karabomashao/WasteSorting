package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "waste_types")
public class WasteTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int wasteId;
    private String typeOfWaste;
    private String wasteExample;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Categories categories;

    public int getWasteId() {
        return wasteId;
    }

    public String getTypeOfWaste() {
        return typeOfWaste;
    }

    public String getWasteExample() {
        return wasteExample;
    }

//    public WasteTypes getWasteTypes() {
//        return wasteTypes;
//    }

    public void setTypeOfWaste(String typeOfWaste) {
        this.typeOfWaste = typeOfWaste;
    }

    public void setWasteExample(String wasteExample) {
        this.wasteExample = wasteExample;
    }
}
