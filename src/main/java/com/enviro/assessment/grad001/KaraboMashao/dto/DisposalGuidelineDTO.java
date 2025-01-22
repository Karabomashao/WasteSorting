package com.enviro.assessment.grad001.KaraboMashao.dto;

public class DisposalGuidelineDTO {

    private Long disposalGuidelineId;
    private String disposalMethod;
    private String location;
    private WasteTypeDTO wasteType;
    private CategoryDTO category;



    public Long getDisposalGuidelineId() {
        return disposalGuidelineId;
    }

    public void setDisposalGuidelineId(Long disposalGuidelineId) {
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

    public WasteTypeDTO getWasteType() {
        return wasteType;
    }

    public void setWasteType(WasteTypeDTO wasteType) {
        this.wasteType = wasteType;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
