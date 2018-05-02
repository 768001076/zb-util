package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.file.FileUtil;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    FileUtil fileUtil;

    @Override
    public List<String> getLogContent(String filePath) {
        return fileUtil.FindContentByURL(filePath);
    }
}
