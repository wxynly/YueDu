package utils;

import dto.ImageHolder;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

public class UploadUtil {
    private static List<FileItem> items;

    public UploadUtil(HttpServletRequest request) {
        // 创建一个工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            // Parse the request
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理普通文本域
     *
     * @param fieldname 文件名
     * @return 返回字段域fieldname的值
     */
    public String getFormField(String fieldname) {
        String value = "";
        // 这里采用了枚举类型
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (item.isFormField()) {
                String name = item.getFieldName();
                if (name.equalsIgnoreCase(fieldname)) {
                    try {
                        value = item.getString("utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return value;
                }
            }
        }
        return value;
    }

    /**
     * 处理文件域
     *
     * @param fieldname 文件名
     * @return 返回文件域fieldname的数据流
     */
    public ImageHolder getUploadedFile(String fieldname) throws Exception {
        Iterator<FileItem> iter = items.iterator();
        ImageHolder imageHolder = null;

        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (!item.isFormField()) {
                String fieldName = item.getFieldName();
                if (fieldName.equalsIgnoreCase(fieldname)) {
                    String filename = item.getName();       //获取文件名
                    InputStream stream = item.getInputStream(); //获取文件流
                    return new ImageHolder(filename, stream);
                }
            }
        }
        return null;
    }


}
