/**
 * 
 */
package com.interviewer.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interviewer.base.AssertUtil;
import com.interviewer.base.BlankServiceCallBack;
import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;
import com.interviewer.dao.InterviewDAO;
import com.interviewer.dao.MessageDAO;
import com.interviewer.enums.MessageRelTypeEnum;
import com.interviewer.enums.UserRoleEnum;
import com.interviewer.pojo.Interview;
import com.interviewer.pojo.Jobseeker;
import com.interviewer.pojo.Message;
import com.interviewer.view.InterviewerVO;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class MessageController extends BaseController {

    @Autowired
    private InterviewDAO interviewDAO;
    @Autowired
    private MessageDAO   messageDAO;

    @RequestMapping(value = "/sendInterviewShotMessage.json", method = RequestMethod.POST)
    public @ResponseBody
    ModelMap sendMessage(final HttpServletRequest request, final Message message, ModelMap modelMap) {
        CcResult result = serviceTemplate.executeWithTx(CcResult.class, new BlankServiceCallBack() {
            @Override
            public CcResult executeService() {
                if (message.getCreatorRole() == UserRoleEnum.JOBSEEKER.getValue()) {
                    Jobseeker jobseeker = getJobseekerInSession(request.getSession());
                    AssertUtil.notNull(jobseeker, "用户不存在的非法消息，请重新登录");
                } else {
                    InterviewerVO interviewVO = getInterviewerInSession(request.getSession());
                    AssertUtil.notNull(interviewVO, "用户不存在的非法消息，请重新登录");
                }
                Interview interview = interviewDAO.findById(message.getRelId());
                AssertUtil.notNull(interview, "面试咨询信息不存在的非法消息，请重新登录");
                message.setGmtCreate(new Date());
                message.setRelType(MessageRelTypeEnum.INTERVIEW.getValue());
                AssertUtil.notNull(message, "非法请求");
                AssertUtil.notBlank(message.getMessage(), "消息内容不能为空");
                AssertUtil.state(message.getMessage().length() <= CcConstrant.SHOT_MESSAGE_LENGTH,
                    "消息长度太长");
                messageDAO.save(message);
                return new CcResult(message);
            }
        });
        modelMap.put("result", result);
        return modelMap;
    }
}
