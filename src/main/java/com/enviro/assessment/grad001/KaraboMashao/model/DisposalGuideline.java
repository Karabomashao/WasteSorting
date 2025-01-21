package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disposalGuidelineId;

    private String disposalMethod;

    private String location;

    @ManyToOne
    @JoinColumn(name = "waste_id", nullable = false)
    private WasteType wasteType;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    // Getters and Setters
    public int getDisposalGuidelineId() {
        return disposalGuidelineId;
    }

    public void setDisposalGuidelineId(int disposalGuidelineId) {
        this.disposalGuidelineId = disposalGuidelineId;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public WasteType getWasteType() {
        return wasteType;
    }

    public void setWasteType(WasteType wasteType) {
        this.wasteType = wasteType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

