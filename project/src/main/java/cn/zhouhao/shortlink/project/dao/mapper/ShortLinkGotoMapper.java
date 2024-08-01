package cn.zhouhao.shortlink.project.dao.mapper;

import cn.zhouhao.shortlink.project.dao.entity.LinkNetworkStatsDO;
import cn.zhouhao.shortlink.project.dao.entity.ShortLinkGotoDO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface ShortLinkGotoMapper extends BaseMapper<ShortLinkGotoDO> {
    /**
     * 根据短链接获取指定日期内访问网络监控数据
     */
    @Select("SELECT " +
            "    network, " +
            "    SUM(cnt) AS cnt " +
            "FROM " +
            "    t_link_network_stats " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url,network;")
    List<LinkNetworkStatsDO> listNetworkStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}
