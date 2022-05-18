package com.z.controller;


import com.z.common.util.ResultModel;
import com.z.model.Carousel;
import com.z.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z
 * @since 2022-05-09
 */
@RestController
@CrossOrigin
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @GetMapping("/list")
    public String getCarouselList() {
        List<Carousel> list = carouselService.list();
        return ResultModel.success(list);
    }

    @PostMapping("/append")

    public String setCarouselImage(@RequestParam("file")MultipartFile[] files) {
        for (MultipartFile file : files) {
           if (!saveFile(file)) {
               return  ResultModel.error("批插入失败");
           }
        }
        return ResultModel.success("添加成功");
    }


    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id) {
        Carousel carousel = carouselService.getById(id);
        String[] split = carousel.getUrl().split("/");
        String fileName = split[split.length-1];
        File file = new File("D:\\project-resources\\carousel\\"+fileName);
        boolean delete = file.delete();
        boolean remove = carouselService.removeById(id);
        return delete==remove ? ResultModel.success("删除成功"):ResultModel.error("删除失败");
    }

    private boolean saveFile(MultipartFile file){
        String name = file.getOriginalFilename();
        System.out.println(name);
        String[] split = name.split("\\.");
        String newName = UUID.randomUUID().toString().replace("-","") + "."+split[split.length-1];
        boolean save = false;
        try {
            file.transferTo(new File("D:\\project-resources\\carousel\\", newName));
            String url = "http://localhost:9000/static/carousel/"+newName;
            save = carouselService.save(new Carousel(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return save ;
    }
}
