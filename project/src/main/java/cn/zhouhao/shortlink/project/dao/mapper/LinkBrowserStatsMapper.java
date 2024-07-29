package cn.zhouhao.shortlink.project.dao.mapper;

import cn.zhouhao.shortlink.project.dao.LinkBrowserStatsDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface LinkBrowserStatsMapper extends BaseMapper<LinkBrowserStatsDO> {
    /**
     * 记录浏览器访问监控数据
     */
    @Insert("INSERT INTO t_link_browser_stats (full_short_url, date, cnt, browser, create_time, update_time, del_flag) " +
            "VALUES( #{linkBrowserStats.fullShortUrl}, #{linkBrowserStats.date}, #{linkBrowserStats.cnt}, #{linkBrowserStats.browser}, NOW(), NOW(), 0) " +
            "ON DUPLICATE KEY UPDATE cnt = cnt +  #{linkBrowserStats.cnt};")
    void shortLinkBrowserState(@Param("linkBrowserStats") LinkBrowserStatsDO linkBrowserStatsDO);
}
