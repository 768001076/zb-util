package util.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 文件操作工具类
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/19
 */
@Component
public class FileUtil {

    private Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public List<String> FindContentByURL(String url){
        List<String> content = new ArrayList<>();
        File file = new File(url);
        BufferedReader bufferedReader = null;
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream(file), "GBK");
            bufferedReader = new BufferedReader(isr);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                content.add(line);
            }
        }
        catch (FileNotFoundException e) {
            logger.error("文件找不到:" + url);
        }
        catch (IOException e) {
            logger.error(url + ":IOException---" + e.getMessage());
        }
        finally {
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
                if (isr != null){
                    isr.close();
                }
            }
            catch (IOException e) {
                logger.error("关闭FileInputStream_Exception");
            }
        }
        return content;
    }

}
