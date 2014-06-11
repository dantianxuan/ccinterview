/**
 * 
 */
package com.interviewer.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;
import com.interviewer.dao.ArticleDAO;
import com.interviewer.dao.CompanyDAO;
import com.interviewer.enums.InterviewStateEnum;
import com.interviewer.pojo.Article;
import com.interviewer.pojo.Company;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.pojo.Message;
import com.interviewer.view.InterviewerVO;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class MessageController extends BaseController {

    @RequestMapping(value = "/sendShotMessage.json", method = RequestMethod.GET)
    public ModelMap sendMessage(HttpServletRequest request, final Message message, ModelMap modelMap) {
        CcResult result = serviceTemplate.execute(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                AssertUtil.notNull(message, "非法请求");
                AssertUtil.notBlank(message.getMessage(), "消息内容不能为空");
                AssertUtil.state(message.getMessage().length() > CcConstrant.SHOT_MESSAGE_LENGTH,
                    "消息长度太长");
                return new CcResult(null);
            }
        });
        return modelMap;
    }

}
