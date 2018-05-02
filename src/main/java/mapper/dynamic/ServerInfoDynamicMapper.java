package mapper.dynamic;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import provider.serverinfo.ServerInfoProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ServerInfoDynamicMapper {

    @SelectProvider(type = ServerInfoProvider.class,method = "all")
    @ResultType(HashMap.class)
    List<Map<String,String>> getAllServerInfo();

    @SelectProvider(type = ServerInfoProvider.class,method = "serverInfo")
    @ResultType(HashMap.class)
    List<Map<String,String>> getServerInfo(String ip);
}
