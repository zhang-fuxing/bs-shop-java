package com.z.vo;

import com.z.model.Pimage;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zfx
 * @date 2022-04-19 14:30
 */
@Data
public class ProductVO {
    private Integer             id;
    private Integer             categoryId;
    private Integer             ctgId;
    private String              pname;
    private String              description;
    private BigDecimal          unitPrice;
    private Integer             inventoryNum;
    private String              storeName;
    private LocalDateTime       createdTime;
    private LocalDateTime       modifiedTime;
    private String              createdUser;
    private String              modifiedUser;
    private List<Pimage>        imgList;

}
