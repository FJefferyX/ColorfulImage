package com.mudiren.tools;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUpload {
    //location格式为"C:\Users\Xiong\Desktop\imageTest"
    public static String imgUpload(MultipartFile image, HttpServletRequest req, String location) throws IOException {
        //接收文件数据
        System.out.println(image);
        System.out.println(image.getContentType());//  image/jpeg   获取上传文件的类型
        System.out.println(image.getName());//image  获取file标签的name属性  <input type="file" name="image" >
        System.out.println(image.getOriginalFilename());//1.jpg   获取上传文件的名称

        //获取到上传的文件数据
        String contentType = image.getContentType();

        //判断上传文件是否为图片
        if (contentType == null || !contentType.startsWith("image/")) {
            System.out.println("===不属于图片类型...===");
            return null;
        }
        //文件名
        String filename = UUID.randomUUID().toString() + ".jpg";
        File f = new File(location, filename);

        //将上传的文件存储到指定位置
        image.transferTo(f);
        String loc = location + File.separator + filename;
        return loc;
    }
}
