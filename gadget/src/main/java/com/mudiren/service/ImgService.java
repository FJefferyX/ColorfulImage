package com.mudiren.service;

import com.baidu.aip.imageprocess.AipImageProcess;
import com.baidu.aip.util.Base64Util;
import com.mudiren.pojo.Message;
import com.mudiren.tools.FileUpload;
import com.mudiren.tools.ImgProcess;
import net.coobird.thumbnailator.Thumbnails;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ImgService {
    //图像增强
    @Autowired
    private AipImageProcess imageProcessClient;

    //黑白图上色
    public Message imgColor(MultipartFile image, HttpServletRequest req, String address) throws IOException {
        String s = FileUpload.imgUpload(image, req, address);
        System.out.println(s);
        //未上传成功
        if (s == null) {
            return new Message("216201", "上传的图片格式错误，现阶段我们支持的图片格式为：PNG、JPG、BMP，请进行转码或更换图片");
        }
        File file = new File(s);
        System.out.println(file.length());


        //如果长宽比大于3，则不适合上色，返回错误码
        double ratio = ImgProcess.getRatio(s);
        if (ratio > 3) {
            return new Message("216201", "请确认图片长宽比<3");
        }
        //判断是否要压缩
        s = ImgProcess.changeSize(s);

        HashMap<String, String> options = new HashMap<String, String>();
        JSONObject res = imageProcessClient.colourize(s, options);
        if (res.has("image")) {
            String imageBase64 = res.getString("image");
            String log_id = res.getBigInteger("log_id").toString();
            byte[] decode = Base64Util.decode(imageBase64);
            String colorPath = address + File.separator + "color" + File.separator + log_id + ".jpg";
            OutputStream out = new FileOutputStream(colorPath);
            String url = "http://39.100.31.86:8080/img/color/" + log_id + ".jpg";
            out.write(decode);
            /*return new Message("0", null, colorPath);*/
            return new Message("0", null, url);
        } else {
            Integer error_code = res.getInt("error_code");
            return new Message(error_code.toString(), res.getString("error_msg"));
        }
    }
}
