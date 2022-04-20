package com.z.vo;

import com.z.model.CtgDetail;
import lombok.Data;

import java.util.List;

/**
 * @author zfx
 * @date 2022-03-20 12:20
 */
@Data
public class CategoryVO {
    private Integer id;
    private String name;
    private List<CtgDetail> list;
}
