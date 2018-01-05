package com.pbody.rest_web.controller.manager;

import com.github.pagehelper.PageInfo;
import com.pbody.rest_web.controller.home.BaseController;
import com.pbody.rest_web.dao.bean.Org;
import com.pbody.rest_web.pojo.RespResult;
import com.pbody.rest_web.service.api.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
     * getList
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/list.htm",method= RequestMethod.GET)
    public void getList(HttpServletResponse response) {
        Org orgForm=new Org();
        RespResult result=new RespResult();
        PageInfo<Org> pageInfo=orgService.getOrgList(orgForm);
        result.setData(pageInfo);
        objReturn(result,response);
    }
     /**
     * getTest2
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/body.htm",method=RequestMethod.GET)
    public @ResponseBody RespResult getTest2() throws IOException {
        return new RespResult();
    }
}