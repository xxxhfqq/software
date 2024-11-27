package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class uploadPicture {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    @GetMapping("/uploadPicture")
    public ModelAndView view(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("uploadPicture");
        return mv;
    }
    @PostMapping("/uploadPicture")
    public String upload(String description, MultipartFile uploadfile, HttpServletRequest req){ 
        String realPath = "/_xhf/picture";
        File file = new File(realPath);
        if(!file.isDirectory()){
            file.mkdirs();
        }
        String oldName = uploadfile.getOriginalFilename();
        if(oldName == null || oldName.trim().isEmpty()){
            return "文件名无效";
        }
        String newName = sdf.format(new Date()) + UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try{
            uploadfile.transferTo(new File(file, newName));
            return "上传成功" + "<br>" + "文件位于: " + req.getScheme() + "://" + req.getServerName() + ":" +
            req.getServerPort()+"/" + newName + "<br>" + "文件描述： " + description;

        }catch(IOException e){
            return "上传失败";
        }
    }
}
