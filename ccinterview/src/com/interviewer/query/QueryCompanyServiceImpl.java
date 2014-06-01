/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.interviewer.query;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcResult;
import com.interviewer.base.ServiceTemplate;
import com.interviewer.dao.CompanyDAO;
import com.interviewer.pojo.Company;
import com.interviewer.util.LogUtil;

/**
 * 公司查询服务
 * @author jinsaichen
 * @version $Id: QueryCompanyServiceImpl.java, v 0.1 2014-5-31 上午11:33:45 jinsaichen Exp $
 */

public class QueryCompanyServiceImpl implements QueryCompanyService {

    /**日志 */
    private static final Logger logger = Logger.getLogger(QueryCompanyServiceImpl.class);

    /**公司数据库操作类 */
    @Autowired
    private CompanyDAO          companyDAO;

    /**事物模板类 */
    @Autowired
    private ServiceTemplate     serviceTemplate;

    /** 
     * @see com.interviewer.query.QueryCompanyService#queryAllCompany()
     */
    @Override
    public CcResult queryAllCompany() {
        LogUtil.info(logger, "开始查询所有公司信息");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            @Override
            public CcResult executeService() {
                List<Company> companys = companyDAO.findAll();
                return new CcResult(companys);
            }
        });
    }

    /** 
     * @see com.interviewer.query.QueryCompanyService#searchFuzzyByName(java.lang.String)
     */
    @Override
    public CcResult searchFuzzyByName(final String name) {
        LogUtil.info(logger, "通过公司名开始查询公司信息");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            public void check() {
                if (StringUtils.isBlank(name)) {
                    LogUtil.warn(logger, "通过公司名查询公司信息入参为空name=" + name);
                }
            }

            @Override
            public CcResult executeService() {
                List<Company> companys = companyDAO.findByName(name);
                return new CcResult(companys);
            }
        });

    }

    @Override
    public CcResult queryCompanyByCatagoryId(final int categoryId) {
        LogUtil.info(logger, "通过公司类目开始查询公司信息");
        return serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {

            public void check() {
                if (categoryId == 0) {
                    LogUtil.warn(logger, "通过类目查询公司categoryId =" + categoryId);
                }
            }

            @Override
            public CcResult executeService() {
                List<Company> companys = companyDAO.findByCategoryId(categoryId);
                return new CcResult(companys);
            }
        });
    }

}
