package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "disposal_guidelines")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disposalGuidelineId;

    @Column(nullable = false)
    @NotBlank(message = "Disposal method cannot be blank")
    private String disposalMethod;

    @Column(nullable = false)
    @NotBlank(message = "Location cannot be blank")
    private String location;

    @ManyToOne
    @JoinColumn(name = "waste_id", nullable = false)
    private WasteType wasteType;


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

}

