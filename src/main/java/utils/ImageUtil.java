package utils;


import dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ImageUtil {

    /**
     * 获取输入文件流的扩展名
     *
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {

        return fileName.substring(fileName.lastIndexOf("."));
    }

    // 获得随机UUID文件名
    public static String generateRandonFileName(String fileName) {
        // 获得扩展名
        String ext = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;
    }

    /**
     * @param thumbnail 保存图片
     * @return
     */
    public static Map saveNormalImg(ImageHolder thumbnail) {
        // 获取不重复的随机名
        String realFileName = generateRandonFileName(thumbnail.getImageName());

        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = thumbnail.getRelativePath() + realFileName;
        System.out.println("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(thumbnail.getBasePath() + relativeAddr);
        System.out.println("current complete addr is :" + thumbnail.getBasePath() + relativeAddr);

        try {
            // 完成文件上传

            IOUtils.copy(thumbnail.getImage(),
                    new FileOutputStream(dest));

        } catch (IOException e) {
            e.printStackTrace();
            return getError("上传文件失败。");
        }
        // 返回图片相对路径地址，便于图片迁移
        return getSuccess("/" + relativeAddr);
    }

    public static Map generateThumbnail(ImageHolder thumbnail) {
        // 获取不重复的随机名
        String realFileName = generateRandonFileName(thumbnail.getImageName());

        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = thumbnail.getRelativePath() + realFileName;
        System.out.println("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(thumbnail.getBasePath() + relativeAddr);
        System.out.println("current complete addr is :" + thumbnail.getBasePath() + relativeAddr);

        try {
            // 完成文件上传
            Thumbnails.of(thumbnail.getImage()).size(200, 300).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return getError("上传文件失败。");
        }
        // 返回图片相对路径地址，便于图片迁移
        return getSuccess("/" + relativeAddr);
    }

    /**
     * 加水印
     *
     * @param thumbnail
     * @return
     */
    public static Map generateNormalImg(ImageHolder thumbnail) {
        // 获取不重复的随机名
        String realFileName = generateRandonFileName(thumbnail.getImageName());
        ;

        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = thumbnail.getRelativePath() + realFileName;
        System.out.println("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(thumbnail.getBasePath() + relativeAddr);
        System.out.println("current complete addr is :" + thumbnail.getBasePath() + relativeAddr);


        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(basePath);
        try {
            /*
             * size(width,height) 若图片横比200小，高比300小，不变
             * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
             * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
             */
            Thumbnails.of(thumbnail.getImage()).size(200, 300)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.75f)
                    .outputQuality(0.9f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return getError("上传文件失败。");
        }
        // 返回图片相对路径地址，便于图片迁移
        return getSuccess("/" + relativeAddr);
    }


    public static Map saveNormal(ImageHolder thumbnail) {

        if (thumbnail.getImage() == null)
            return getError("未选择文件。");
        // 获取不重复的随机名
        String realFileName = generateRandonFileName(thumbnail.getImageName());

        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = thumbnail.getRelativePath() + realFileName;
        System.out.println("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(thumbnail.getBasePath() + relativeAddr);
        System.out.println("current complete addr is :" + thumbnail.getBasePath() + relativeAddr);

        try {
            // 完成文件上传

            IOUtils.copy(thumbnail.getImage(),
                    new FileOutputStream(dest));
        } catch (IOException e) {
            e.printStackTrace();
            return getError("上传文件失败。");
        }
        // 返回图片相对路径地址，便于图片迁移
        return getSuccess("/" + relativeAddr);
    }

    // 文件上传失败时候的回调内容
    public static Map getError(String message) {
        Map map = new HashMap();
        map.put("error", 1);
        map.put("message", message);
        return map;
    }

    // 文件上传成功时候的回调内容
    public static Map getSuccess(String url) {
        Map map = new HashMap();
        map.put("error", 0);
        map.put("url", url);
        return map;
    }
}
