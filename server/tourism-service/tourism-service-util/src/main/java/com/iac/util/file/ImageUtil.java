package com.iac.util.file;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class ImageUtil {

	public static BufferedImage cut(final BufferedImage src, ImageCropParam param) {
		BufferedImage result = src;
		if(param.getRotate() % 360 != 0) {
			result = rotateImage(src, param.getRotate());
		}
		System.out.println("img width:" + src.getWidth() + " height:" + src.getHeight());
		System.out.println("X + width:" + (param.getX() + param.getWidth()));
		System.out.println("Y + height:" + (param.getY() + param.getHeight()));
		
		int x = Math.max(0, param.getX());
		int y = Math.max(0, param.getY());
		int width = Math.min(result.getWidth() - x, param.getWidth());
		int height = Math.min(result.getHeight() - y, param.getHeight());
		System.out.println(String.format("x [%s] y [%s] width [%s] height [%s]", x, y, width, height));
//		return result.getSubimage(param.getX(), param.getY(), param.getWidth(), param.getHeight());
		return result.getSubimage(x, y, width, height);
	}
	
	/**
     * 旋转图片为指定角度
     * 
     * @param bufferedimage
     *            目标图像
     * @param degree
     *            旋转角度
     * @return
     */
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        
        System.out.println("arfter rotate image's width :" + img.getWidth() + " height: " + img.getHeight());
        return img;
    }

    /**
     * 变更图像为指定大小
     * 
     * @return
     */
    public static BufferedImage resizeImage(final BufferedImage bufferedimage,
            final int w, final int h) {
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.drawImage(bufferedimage, 0, 0, w, h, 0, 0, bufferedimage
                .getWidth(), bufferedimage.getHeight(), null);
        graphics2d.dispose();
        return img;
    }

    /**
     * 水平翻转图像
     * 
     * @param bufferedimage 目标图像
     * @return
     */
    public static BufferedImage flipImage(final BufferedImage bufferedimage) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, bufferedimage
                .getColorModel().getTransparency())).createGraphics())
                .drawImage(bufferedimage, 0, 0, w, h, w, 0, 0, h, null);
        graphics2d.dispose();
        return img;
    }
    
   
    public static void imageMisro(File file, int FX) {
        try {
            BufferedImage bufferedimage = ImageIO.read(file);
            int w = bufferedimage.getWidth();
            int h = bufferedimage.getHeight();
            int[][] datas = new int[w][h];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    datas[j][i] = bufferedimage.getRGB(j, i);
                }
            }
            int[][] tmps = new int[w][h];
            if (FX == 0) {
                for (int i = 0, a = h - 1; i < h; i++, a--) {
                    for (int j = 0; j < w; j++) {
                        tmps[j][a] = datas[j][i];
                    }
                }
            } else if (FX == 1) {
                for (int i = 0; i < h; i++) {
                    for (int j = 0, b = w - 1; j < w; j++, b--) {
                        tmps[b][i] = datas[j][i];
                    }
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    bufferedimage.setRGB(j, i, tmps[j][i]);
                }
            }
            ImageIO.write(bufferedimage, "jpg", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public static boolean isImage(File file) {
        boolean flag = false;
        try {
            ImageInputStream is = ImageIO.createImageInputStream(file);
            if (null == is) {
                return flag;
            }
            is.close();
            flag = true;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return flag;
    }

   
    public static int[] getPhotoWidthAndHeightByTargetInfo(Integer originWidth, Integer originHeight, Integer targetWidth, Integer targetHeight) {
        double originRatio = (double) originWidth / originHeight,
                targetRatio = (double) targetWidth / targetHeight;
        int width, height;
        if (originRatio > targetRatio) {
            width = targetWidth > originWidth ? originWidth : targetWidth;
            height = new Double(width / originRatio).intValue();
        } else if (originRatio < targetRatio) {
            height = targetHeight > originHeight ? originHeight : targetHeight;
            width = new Double(height * originRatio).intValue();
        } else {
            width = targetWidth;
            height = targetHeight;
        }

        return new int[]{width, height};
    }

    public static File processScale(File imgFile, Integer targetWidth, Integer targetHeight, String targetFormat, File directory) throws IOException {
        BufferedImage src = ImageIO.read(imgFile);
        int originWidth = src.getWidth();
        int originHeight = src.getHeight();
        int[] widthAndHeight = ImageUtil.getPhotoWidthAndHeightByTargetInfo(originWidth, originHeight, targetWidth, targetHeight);
        int width = widthAndHeight[0];
        int height = widthAndHeight[1];

        Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        File targetFile = File.createTempFile("temp", "." + targetFormat, directory);
        ImageIO.write(tag, targetFormat, targetFile);
        return targetFile;
    }

    public static int[] getImageWidthAndHeight(String filePath) throws IOException {
        File picFile = new File(filePath);
        BufferedImage image = ImageIO.read(picFile);
        int width = image.getWidth();
        int height = image.getHeight();
        return new int[]{width, height};
    }

}
