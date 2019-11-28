package dto;

import java.io.InputStream;

/**
 * 图片封装类
 */
public class ImageHolder {
    private String imageName;
    private InputStream image;
    private String basePath;//实际存放路径
    private String relativePath;//相对存放路径

    public ImageHolder(String imageName, InputStream image, String basePath, String relativePath) {
        this.imageName = imageName;
        this.image = image;
        this.basePath = basePath;
        this.relativePath = relativePath;
    }

    public ImageHolder(String imageName, InputStream image) {
        this.imageName = imageName;
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}
