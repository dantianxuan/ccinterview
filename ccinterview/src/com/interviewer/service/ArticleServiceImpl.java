/**
 * ccinterviewer.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.interviewer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.interviewer.base.AbstractService;
import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.dao.ArticleDAO;
import com.interviewer.pojo.Article;

/**
 * 
 * @author jingyu.dan
 * @version $Id: ArticleServiceImpl.java, v 0.1 2014-6-2 下午4:26:39 jingyu.dan Exp $
 */
public class ArticleServiceImpl extends AbstractService implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    /** 
     * @see com.interviewer.service.ArticleService#saveArticle(com.interviewer.pojo.Article)
     */
    @Override
    public CcResult saveArticle(final Article article) {
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            @Override
            public void check() {
                AssertUtil.notBlank(article.getTitle(), "标题不能为空");
                AssertUtil.notBlank(article.getContent(), "文章内容空能为空");
            }

            @Override
            public CcResult executeService() {
                article.setGmtCreate(new Date());
                article.setGmtModified(new Date());
                articleDAO.save(article);
                return new CcResult(article);
            }
        });
    }

    /** 
     * @see com.interviewer.service.ArticleService#updateArticle(com.interviewer.pojo.Article)
     */
    @Override
    public CcResult updateArticle(final Article article) {
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            @Override
            public void check() {
                AssertUtil.state((article.getId() != null && article.getId() > 0), "不合法的请求，文章不存在");
                AssertUtil.notBlank(article.getTitle(), "标题不能为空");
                AssertUtil.notBlank(article.getContent(), "文章内容空能为空");
            }

            @Override
            public CcResult executeService() {
                article.setGmtModified(new Date());
                articleDAO.update(article);
                return new CcResult(article);
            }
        });
    }

}
