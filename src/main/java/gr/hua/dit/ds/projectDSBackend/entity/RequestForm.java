package gr.hua.dit.ds.projectDSBackend.entity;

import java.util.List;

public class RequestForm {
    private String name;
    private String farmersId;
    private String productsId;
    private Integer regionId;

    public RequestForm() {
    }

    public RequestForm(String name, String farmersId, String productsId, Integer regionId) {
        this.name = name;
        this.farmersId = farmersId;
        this.productsId = productsId;
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFarmersId() {
        return farmersId;
    }

    public void setFarmersId(String farmersId) {
        this.farmersId = farmersId;
    }

    public String getProductsId() {
        return productsId;
    }

    public void setProductsId(String productsId) {
        this.productsId = productsId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }


    @Override
    public String toString() {
        return "RequestForm{" +
                "name='" + name + '\'' +
                ", farmersId='" + farmersId + '\'' +
                ", productsId='" + productsId + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}
