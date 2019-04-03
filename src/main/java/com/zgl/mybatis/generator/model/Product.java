package com.zgl.mybatis.generator.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_product")
public class Product implements Serializable {
    @Id
    private String id;

    @Column(name = "prodect_name")
    private String prodectName;

    private Integer price;

    private String description;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return prodect_name
     */
    public String getProdectName() {
        return prodectName;
    }

    /**
     * @param prodectName
     */
    public void setProdectName(String prodectName) {
        this.prodectName = prodectName;
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", prodectName=").append(prodectName);
        sb.append(", price=").append(price);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}