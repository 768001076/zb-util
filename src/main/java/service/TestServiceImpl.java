package service;

import annotation.DS;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.TestInfo;
import mapper.dynamic.TestDynamicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired TestDynamicMapper mapper;

    @Override
    @DS(value = "local")
    public JSONArray getTestFromLocal() {
        List<TestInfo> testFromLocal = mapper.getTestFromLocal();
        JSONArray objects = new JSONArray();
        try {
            for (TestInfo info: testFromLocal) {
                objects.add(JSONObject.toJSON(info));
            }
        }
        catch (Exception e) {
            logger.error("TestInfo转json_Exception");
        }
        return objects;
    }
}
