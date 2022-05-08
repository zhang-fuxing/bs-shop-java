package com.z.dto;

import com.z.model.Pimage;
import com.z.model.Product;

import java.util.Arrays;

/**
 * @author zfx
 * @date 2022-05-08 14:14
 */
public class ProductDTO {
    private Product product;
    private Pimage[] previewImage;
    private Pimage[] detailImage;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Pimage[] getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(Pimage[] previewImage) {
        this.previewImage = previewImage;
    }

    public Pimage[] getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(Pimage[] detailImage) {
        this.detailImage = detailImage;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "product=" + product +
                ", previewImage=" + Arrays.toString(previewImage) +
                ", detailImage=" + Arrays.toString(detailImage) +
                '}';
    }
}
