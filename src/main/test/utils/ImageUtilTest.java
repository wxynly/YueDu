package utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;



public class ImageUtilTest {

    @Test
    public void generateNormalImg() {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(basePath);
        //指定文件大小
        try {
            Thumbnails.of("D:\\ideaProject\\YueDu\\src\\main\\webapp\\images\\9002820107151710.jpg").size(200, 200)
                    //加入水印 0.25f是透明度  outputQuality(0.8f)是压缩比
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("d:/img/watermark.jpg")), 0.8f)
                    .outputQuality(0.8f).toFile("D:\\ideaProject\\YueDu\\src\\main\\webapp\\images\\new.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}