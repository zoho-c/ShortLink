package cn.zhouhao.shortlink.project.dao.mapper;

import cn.zhouhao.shortlink.project.dao.LinkDeviceStatsDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface LinkDeviceStatsMapper extends BaseMapper<LinkDeviceStatsDO> {
    /**
     * 记录访问设备监控数据
     */
    @Insert("INSERT INTO t_link_device_stats (full_short_url, date, cnt, device, create_time, update_time, del_flag) " +
            "VALUES( #{linkDeviceStats.fullShortUrl}, #{linkDeviceStats.date}, #{linkDeviceStats.cnt}, #{linkDeviceStats.device}, NOW(), NOW(), 0) " +
            "ON DUPLICATE KEY UPDATE cnt = cnt +  #{linkDeviceStats.cnt};")
    void shortLinkDeviceState(@Param("linkDeviceStats") LinkDeviceStatsDO linkDeviceStatsDO);
}
