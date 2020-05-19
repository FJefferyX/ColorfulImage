package com.mudiren.controller;

import com.baidu.aip.imageprocess.AipImageProcess;
import com.baidu.aip.util.Base64Util;
import com.mudiren.pojo.Message;
import com.mudiren.service.ImgService;
import com.mudiren.tools.FileUpload;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/img")
public class ImgController {
    @Autowired
    private ImgService imgService;

    @RequestMapping(method = RequestMethod.POST, value = "/gray2rgb.do")
    @ResponseBody
    public Message fun(MultipartFile image, @RequestParam(name = "name") String name, HttpServletRequest req) throws IOException {
        String address = "/tools/apache-tomcat-8.5.53/webapps/img";
        System.out.println(image);
        System.out.println(name);
        Message message = imgService.imgColor(image, req, address);
        return message;
    }
}
