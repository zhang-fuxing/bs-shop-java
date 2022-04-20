package com.z.service.impl;

import com.z.model.Pimage;
import com.z.mapper.PimageMapper;
import com.z.service.PimageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@Service
public class PimageServiceImpl extends ServiceImpl<PimageMapper, Pimage> implements PimageService {

    @Override
    public String fileupload(MultipartFile[] files, String path, String prefix) {
        String status = null;
        for (MultipartFile f : files) {
            String oldName = f.getOriginalFilename();
            assert oldName != null;
            String[] suffix = oldName.split("\\.");
            String newName = prefix + "-" + System.currentTimeMillis() + "."+suffix[suffix.length-1];
            File file1 = new File(path);
            if (!file1.exists()) {
                boolean mkdir = file1.mkdir();
            }
            try {
                f.transferTo(new File(file1,newName));
                status = "success";
            } catch (IOException e) {
                e.printStackTrace();
                status = "error";
            }
        }

        return status;
    }
}
