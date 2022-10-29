package com.zhangheng.houtaihouduan.service.impl;

import cn.hutool.core.util.IdUtil;
import com.zhangheng.houtaihouduan.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class FileServiceImpl implements FileService {
    @Value("${server.port}")
    private String port;
    @Value("${file.upload.dir}")
    private String realPath;
    private static final String ip="http://localhost";
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        //System.out.println(file.getOriginalFilename());
        String originalFilename = file.getOriginalFilename();
        String uuid = IdUtil.fastSimpleUUID();
        String newFileName=uuid+"_"+originalFilename;
        String fileUrl=ip+":"+port+"/"+realPath+newFileName;

        /**
         * 传到绝对路径里（为了应对jar包部署）
         */
        file.transferTo(new File(realPath,newFileName));
        String download=ip+":"+port+"/download?fileName="+newFileName;
        return download;
    }
}
