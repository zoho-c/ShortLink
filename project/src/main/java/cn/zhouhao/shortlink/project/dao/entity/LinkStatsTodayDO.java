package cn.zhouhao.shortlink.project.dao.entity;

import cn.zhouhao.shortlink.project.common.database.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_link_stats_today")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkStatsTodayDO extends BaseDO {
    private Long id;
    private String gid;
    private String fullShortUrl;
    private Date date;
    private Integer todayPv;  // today cnt of pv
    private Integer todayUv;  // today cnt of uv
    private Integer todayUip; // today cnt of unique ip
}
