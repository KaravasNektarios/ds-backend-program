package gr.hua.dit.ds.projectDSBackend.entity;

import java.util.List;

public class RequestForm {
    private String name;
    private List<Integer> farmersId;
    private List<Integer> productsId;
    private Integer regionId;

    public RequestForm(String name, List<Integer> farmersId, List<Integer> productsId, Integer regionId) {
        this.name = name;
        this.farmersId = farmersId;
        this.productsId = productsId;
        this.regionId = regionId;
    }

    public RequestForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getFarmersId() {
        return farmersId;
    }

    public void setFarmersId(List<Integer> farmersId) {
        this.farmersId = farmersId;
    }

    public List<Integer> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Integer> productsId) {
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
                ", farmersId=" + farmersId +
                ", productsId=" + productsId +
                ", regionId=" + regionId +
                '}';
    }
}
