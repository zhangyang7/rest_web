package com.pbody.rest_web.controller.manager;

import com.pbody.rest_web.controller.home.BaseController;
import com.pbody.rest_web.dao.bean.Org;
import com.pbody.rest_web.pojo.ResponseResult;
import com.pbody.rest_web.service.api.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Pbody
 * @create 2017-12-13 16:16
 * @description： 组织机构管理
 */
@Controller
@RequestMapping("org")
@Scope("prototype")
public class OrgController extends BaseController {

    @Autowired
    private OrgService orgService;

    /**

     * getTest
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/list.htm",method= RequestMethod.GET)
    public void getList(HttpServletResponse response) throws IOException {
//        ResponseResult result=new ResponseResult();
//        result.setResult("0");
//        result.setMessage("success");
        logger.info("The Lcation Of My Project is {},I call it {}'");
        List<Org> orgList=orgService.getOrgList();
        objReturn(orgList,response);
    }
    /**
     * getTest2
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/body.htm",method=RequestMethod.GET)
    @ResponseBody
    public Object getTest2() throws IOException {
        ResponseResult result=new ResponseResult();
        result.setResult("0");
        result.setMessage("success");
        return result;
    }
}