package mapper.dynamic;

import entity.TestInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import provider.test.TestProvider;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface TestDynamicMapper {

    @SelectProvider(type = TestProvider.class,method = "findTest")
    @Results(id = "test" , value = {
            @Result(column = "PKId", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "type", property = "type"),
            @Result(column = "lastupdate", property = "updateTime")
    })
    List<TestInfo> getTestFromLocal();

}
