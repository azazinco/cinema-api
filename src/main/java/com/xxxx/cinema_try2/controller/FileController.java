package com.xxxx.cinema_try2.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.xxxx.cinema_try2.annotation.PassToken;
import com.xxxx.cinema_try2.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;
    @Value("${file.ip}")
    private String ip;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") + "/src/main/resources/files/" + flag + "_" + originalFilename;
        FileUtil.writeBytes(file.getBytes(), rootFilePath);
        return Result.success("http://" + ip + ":" + port +  "/files/" + flag);
    }

    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) throws IOException {
        OutputStream os;
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/"; //定义文件上传的更路径
        List<String> fileNames = FileUtil.listFileNames(basePath); //获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse(""); //找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;fiename=" + URLEncoder.encode(fileName, "UTF-8"));
                byte[] bytes = FileUtil.readBytes(basePath + fileName); //
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }

    }
}


