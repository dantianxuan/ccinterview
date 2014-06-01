/**
 * 
 */
package com.interviewer.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.interviewer.base.CcConstrant;
import com.interviewer.base.CcResult;
import com.interviewer.dao.CompanyDAO;
import com.interviewer.pojo.Interviewer;
import com.interviewer.pojo.RegMail;
import com.interviewer.service.RegistService;
import com.interviewer.service.UserInfoServiceImpl;
import com.interviewer.util.LogUtil;

/**
 * @author jingyu.dan
 * 
 */
@Controller
public class RegInterviewerController {

    /**日志 */
    private static final Logger logger = Logger.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private RegistService       registService;

    @Autowired
    private CompanyDAO          companyDAO;

    //@Autowired
    // private QueryCompanyService queryCompanyService;

    /**
     * 注册面试官init页面
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewerInit.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpservletrequest, ModelMap modelMap) {
        modelMap.put("companys", companyDAO.findAll());
        ModelAndView view = new ModelAndView("regist/regInterviewerInit");
        return view;
    }

    /**
     * 使用公司邮箱进行注册
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewerMail.htm", method = RequestMethod.GET)
    public ModelAndView registMail(HttpServletRequest httpservletrequest, String email,
                                   String subPrefix, ModelMap modelMap) {
        ModelAndView view = new ModelAndView("regist/regInterviewerInit");
        RegMail regMail = new RegMail();
        regMail.setMail(email + subPrefix);
        regMail.setGmtCreate(new Date());
        regMail.setToken(UUID.randomUUID().toString());
        CcResult result = registService.regMail(regMail);
        modelMap.put("result", result);
        return view;
    }

    /**
     * 公司邮箱链接注册
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewer.htm", method = RequestMethod.GET)
    public ModelAndView initRegInterviewer(String token, ModelMap modelMap) {
        CcResult result = registService.getRegMainInfo(token);
        if (!result.isSuccess()) {
            modelMap.put("result", result);
            return new ModelAndView("redirect:regist/regInterviewerInit.htm");
        }
        modelMap.put("result", result);
        Interviewer interviewer = new Interviewer();
        interviewer.setEmail(((RegMail) result.getObject()).getMail());
        modelMap.put("interviewer", interviewer);
        modelMap.put("regMailId", ((RegMail) result.getObject()).getId());
        return new ModelAndView("regist/regInterviewer");
    }

    /**
     * 公司邮箱链接注册
     * 
     * @return
     * @throws IOException 
     * @throws Exception
     */
    @RequestMapping(value = "/regist/regInterviewer.htm", params = "action=regist")
    public ModelAndView submitRegInterviewer(HttpServletRequest request, Interviewer interviewer,
                                             String repasswd,
                                             @RequestParam MultipartFile[] localPhoto,
                                             String regMailId, ModelMap modelMap) {
        CcResult result = null;
        String fileName = "";
        try {
            for (MultipartFile myfile : localPhoto) {
                if (myfile.isEmpty()) {
                    System.out.println("文件未上传");
                } else {
                    System.out.println("文件长度: " + myfile.getSize() + "文件类型: "
                                       + myfile.getContentType() + "文件名称: " + myfile.getName()
                                       + "文件原名: " + myfile.getOriginalFilename());
                    String path = request.getSession().getServletContext().getRealPath("/")
                                  + "UPLOAD";
                    File parentFile = new File(path);
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    fileName = UUID.randomUUID().toString() + myfile.getOriginalFilename();
                    FileCopyUtils.copy(myfile.getBytes(), new File(path, fileName));
                }
            }
            interviewer.setGmtCreate(new Date());
            interviewer.setPhoto(fileName);
            interviewer.setGmtModified(new Date());
            if (StringUtils.equals(interviewer.getPasswd(), repasswd)) {
                result = registService.regInterviewer(interviewer, NumberUtils.toInt(regMailId));
            } else {
                result = new CcResult("重复密码输入不一致");
            }

        } catch (Exception e) {
            LogUtil.error(logger, e, "文件上传失败");
            result = new CcResult("文件上传失败");
        }
        if (result.isSuccess()) {
            request.getSession().setAttribute(CcConstrant.SESSION_NTERVIEWER_OBJECT,
                result.getObject());
            return new ModelAndView("redirect:/interviewer/interviewerSelf.htm");
        }

        modelMap.put("result", result);
        modelMap.put("regMailId", regMailId);
        modelMap.put("interviewer", interviewer);
        return new ModelAndView("regist/regInterviewer");
    }
}
