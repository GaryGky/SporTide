package com.hupu.service.Impl;


    import com.hupu.dao.RecapDao;
    import com.hupu.pojo.Recap;
    import com.hupu.service.RecapService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Qualifier;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.List;

/**
 * (Recap)表服务实现类
 *
 * @author makejava
 * @since 2020-04-26 19:41:25
 */
@Service("recapService")
@Transactional
public class RecapServiceImpl implements RecapService {

@Autowired
@Qualifier("recapDao")
private RecapDao recapDao;
    
    @Override
    public Recap queryById(int gameid) {
        return recapDao.queryById(gameid);
    }
    
    @Override
    public List<Recap> queryAllByLimit(int offset, int limit) {
        return recapDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Recap> queryAll(Recap recap) {
        return recapDao.queryAll(recap);
    }
    
    @Override
    public int insert(Recap recap) {
        return recapDao.insert(recap);
    }
    
    @Override
    public int update(Recap recap) {
        return recapDao.update(recap);
    }
    
    @Override
    public int deleteById(String gameid) {
        return recapDao.deleteById(gameid);
    }
}