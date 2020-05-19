package com.mudiren.tools;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

public class ImgProcess {
    //获取图像高度
    public static int getHeight(String fileLocation) {
        ImageIcon imageIcon = new ImageIcon(fileLocation);
        return imageIcon.getIconHeight();
    }

    //获取图像宽度
    public static int getWidth(String fileLocation) {
        ImageIcon imageIcon = new ImageIcon(fileLocation);
        return imageIcon.getIconWidth();
    }

    //获取长宽比
    public static double getRatio(String fileLocation) {
        if (getHeight(fileLocation) > getWidth(fileLocation)) {
            return getHeight(fileLocation) / (getWidth(fileLocation) * 1.0);
        } else return getWidth(fileLocation) / (getHeight(fileLocation) * 1.0);
    }

    public static String changeSize(String s) throws IOException {
        int height = ImgProcess.getHeight(s);
        int width = ImgProcess.getWidth(s);
        double ratio = ImgProcess.getRatio(s);
        if (height > 800 || width > 800) {
            //等比例缩放
            if (height > width) {
                Thumbnails.of(s).size((int) (800 / ratio), 800).toFile(s);
            } else {
                Thumbnails.of(s).size(800, (int) (800 / ratio)).toFile(s);
            }

        }
        if (height < 64 || width < 64) {
            if (height > width) {
                Thumbnails.of(s).size(64, (int) (64 * ratio)).toFile(s);
            } else {
                Thumbnails.of(s).size((int) (64 * ratio), 64).toFile(s);
            }
        }
        return s;
    }


}
