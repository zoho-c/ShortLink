package cn.zhouhao.shortlink.project.dao.mapper;

import cn.zhouhao.shortlink.project.dao.LinkNetworkStatsDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface LinkNetworkStatsMapper extends BaseMapper<LinkNetworkStatsDO> {
    /**
     * 记录访问设备监控数据
     */
    @Insert("INSERT INTO t_link_network_stats (full_short_url, date, cnt, network, create_time, update_time, del_flag) " +
            "VALUES( #{linkNetworkStats.fullShortUrl}, #{linkNetworkStats.date}, #{linkNetworkStats.cnt}, #{linkNetworkStats.network}, NOW(), NOW(), 0) " +
            "ON DUPLICATE KEY UPDATE cnt = cnt +  #{linkNetworkStats.cnt};")
    void shortLinkNetworkState(@Param("linkNetworkStats") LinkNetworkStatsDO linkNetworkStatsDO);
}
