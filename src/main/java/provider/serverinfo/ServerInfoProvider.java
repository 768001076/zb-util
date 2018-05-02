package provider.serverinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: rep信息获取
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/4/24
 */
public class ServerInfoProvider {

    private Logger logger = LoggerFactory.getLogger(ServerInfoProvider.class);

    /**
     * @Description: 获取所有订单信息
     *
     * @Return String
     */
    public String all(){
        String getAllServerInfoSQL = "SELECT wip,nip,command,sshPassword FROM ServerInfo";
        logger.info(getAllServerInfoSQL);
        return getAllServerInfoSQL;
    }

    /**
     * @Description: 根据ip获取信息
     *
     * @Param ip
     * @Return String
     */
    public String serverInfo(String ip){
        String getServerInfoBYIPSQL = "SELECT wip,nip,command,sshPassword FROM ServerInfo WHERE wip like '%" + ip +
                "%' OR nip like '%" + ip + "%'";
        logger.info(getServerInfoBYIPSQL);
        return getServerInfoBYIPSQL;
    }

}
