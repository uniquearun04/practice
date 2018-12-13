package tv.swoo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Created by achaudhary on 11/15/18.
 */
public class ImageBytesBase64String {


    public static void main(String ...args) throws IOException {
        ImageBytesBase64String imageBytesBase64String = new ImageBytesBase64String();
        String imageArrayData = imageBytesBase64String.convert2Base64String(
                "/Users/achaudhary/Downloads/ss_prodPub57064611534319860020101.jpg");

        String basePath = "/Users/achaudhary/Downloads/swooperstar-02/";
        String imageArrayData_01 = imageBytesBase64String.convert2Base64String(basePath +
                "_swooperstar-02-promise21.jpg.jpg");
        String imageArrayData_02 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-Ansika02.jpg");
        String imageArrayData_03 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-YashShergare.jpg.jpg");
        String imageArrayData_04 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-deekshithakotian.jpg.jpg");
        String imageArrayData_05 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-jasminesachdeva.jpg.jpg");

        String imageArrayData_06 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-mrigya11.jpg.jpg");

        String imageArrayData_07 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-pratitidutta.jpg.jpg");

        String imageArrayData_08 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-roopdhillonn.jpg.jpg");

        String imageArrayData_09 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-simransachdev15.jpg.jpg");

        String imageArrayData_10 = imageBytesBase64String.convert2Base64String(basePath +
                "swooperstar-02-vishalnirmal.jpg.jpg");

        System.out.println("imageArrayData:-\n"+imageArrayData);
    }

    String convert2Base64String(String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        byte[] data = Files.readAllBytes(path);
        return new String(Base64.getEncoder().encode(data));
    }
}
