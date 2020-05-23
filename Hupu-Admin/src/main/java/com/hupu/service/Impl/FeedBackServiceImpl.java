package com.hupu.service.Impl;

import com.hupu.dao.FeedBackDao;
import com.hupu.pojo.FeedBack;
import com.hupu.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("feedbackService")
@Transactional
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    @Qualifier("feedBackDao")
    private FeedBackDao feedBackDao;

    @Override
    public FeedBack queryById(int feedbackId) {
        return feedBackDao.queryById(feedbackId);
    }

    @Override
    public List<FeedBack> queryAllByLimit(int offset, int limit) {
        return feedBackDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<FeedBack> queryFeedBackByUserId(int user_id) {
        return feedBackDao.queryFeedBackByUserId(user_id);
    }

    @Override
    public int insertFeedBack(FeedBack feedBack) {
        return feedBackDao.insertFeedBack(feedBack);
    }

    @Override
    public int addReply(String reply, String reply_time, int feedbackId) {
        return feedBackDao.addReply(reply, reply_time, feedbackId);
    }

    @Override
    public int deleteById(int feedbackId) {
        return feedBackDao.deleteById(feedbackId);
    }
}
