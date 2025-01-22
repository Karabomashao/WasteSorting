package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "Recycling_tip")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipId;

    @NotBlank(message = "Tip description cannot be blank")
    @Column(nullable = false)
    private String tipDescription;

    @NotBlank(message = "Material cannot be blank")
    @Column(nullable = false)
    private String material;

    @NotBlank(message = "Additional info cannot be blank")
    @Column(nullable = false)
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "waste_id", nullable = false)
    private WasteType wasteType;

    public int getTipId() {
        return tipId;
    }

    public void setTipId(int tipId) {
        this.tipId = tipId;
    }

    public String getTipDescription() {
        return tipDescription.toLowerCase();
    }

    public void setTipDescription(String tipDescription) {
        this.tipDescription = tipDescription.toLowerCase();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material.toLowerCase();
    }

    public String getAdditionalInfo() {
        return additionalInfo.toLowerCase();
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo.toLowerCase();
    }

    public WasteType getWasteType() {
        return wasteType;
    }

    public void setWasteType(WasteType wasteType) {
        this.wasteType = wasteType;
    }
}
