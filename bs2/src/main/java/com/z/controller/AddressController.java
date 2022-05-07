package com.z.controller;


import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.z.common.util.ResultModel;
import com.z.model.Address;
import com.z.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author z
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {


    @Autowired
    private AddressService addressService;

    @PostMapping("/list")
    public String getAddressListByUserId(HttpServletRequest request) {
        JWT jwt = JWTUtil.parseToken(request.getHeader("token"));
        Integer uid = (Integer) jwt.getPayload("id");
        return addressService.getUserAddress(uid);
    }

    @PostMapping("/getById/{id}")
    public String getAddressById(@PathVariable("id") Integer id) {
        if (id == null) {
            return ResultModel.success(1, "无默认地址");
        }
        QueryWrapper<Address> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", id).eq("receive_status", 1);
        Address address = addressService.getOne(wrapper);
        return ResultModel.success(address);

    }

    @PostMapping("/append")
    public String appendAddress(HttpServletRequest request, @RequestBody Address address) {
        JWT token = JWTUtil.parseToken(request.getHeader("token"));
        int uid = (int) token.getPayload("id");
        address.setUid(uid);
        address.setReceiveStatus(0);
        boolean save = addressService.save(address);
        return ResultModel.success(save);
    }

    @PostMapping("/setDefault/{id}")
    public String setDefaultAddress(@PathVariable("id") int id, HttpServletRequest request) {
        int uid = (int) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        Address one = addressService.getOne(new QueryWrapper<Address>().eq("uid", uid).eq("receive_status", 1));
        if (one != null) {
            UpdateWrapper<Address> wrapper1 = new UpdateWrapper<>();
            wrapper1.eq("receive_status", 1).eq("uid", uid).ne("id", id).set("receive_status", 0);
            addressService.update(wrapper1);
        }

        UpdateWrapper<Address> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id).set("receive_status", 1);
        boolean update = addressService.update(wrapper);

        if (!update)
            return ResultModel.error("出现了点问题呢");
        return ResultModel.success(true);
    }

    @PostMapping("/update")
    public String updateAddress(@RequestBody Address address) {

        UpdateWrapper<Address> wrapper = new UpdateWrapper<>();
        wrapper.set("address_name", address.getAddressName())
                .set("name", address.getName())
                .set("phone", address.getPhone())
                .set("province", address.getProvince())
                .set("city", address.getCity())
                .set("region", address.getRegion())
                .set("detail_address", address.getDetailAddress())
                .eq("id", address.getId());

        boolean update = addressService.update(wrapper);

        return ResultModel.success(update);
    }

    @PostMapping("/delete/{aid}")
    public String deleteAddress(@PathVariable("aid") Integer aid) {
        boolean b = addressService.removeById(aid);
        return ResultModel.success(b);
    }
}









