package cn.zhouhao.shortlink.project.service.Impl;

import cn.zhouhao.shortlink.project.dao.entity.LinkStatsTodayDO;
import cn.zhouhao.shortlink.project.dao.mapper.LinkStatsTodayMapper;
import cn.zhouhao.shortlink.project.service.LinkStatsTodayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {
}
