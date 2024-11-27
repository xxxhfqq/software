package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class FileUpload {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss"); 
    @GetMapping("/file")
    public ModelAndView text(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("file");
        return mv;
    }
    @PostMapping("/file")
    public String text(MultipartFile uploadfile, HttpServletRequest req){
        String realPath = "D:\\_xhf\\java\\software\\demo\\src\\main\\resources\\file";
        String format = sdf.format(new Date());
        File folder = new File(realPath);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName = uploadfile.getOriginalFilename();
        if (oldName == null || oldName.trim().isEmpty()) {
            return "文件名无效";
        }
        String newName = format + UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try{
            uploadfile.transferTo(new File(folder, newName));
            String filePath = req.getScheme() + "://" + req.getServerName() 
            + ":" + req.getServerPort() +"/"+newName;
            return filePath;
        }catch (IOException e){
            e.printStackTrace();
        }
        return new String("上传失败" + "<br>" + "realPath:" + realPath + "<br>" +"folder:" + folder.getPath());
    }
}
