package estate.controller;

import estate.common.util.LogUtil;
import estate.entity.json.BasicJson;
import estate.entity.json.TableData;
import estate.entity.json.TableFilter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kangbiao on 15-9-3.
 *
 */
@RestController
@RequestMapping("/user")
public class UserController
{
    @RequestMapping(value = "/{userID}" ,method = RequestMethod.GET)
    public BasicJson login(@PathVariable String userID)
    {
        BasicJson temp=new BasicJson();
        temp.setStatus(true);
        temp.setJsonString("jsonstring");
        System.out.println(userID);
        LogUtil.E("Fgfdgf");
        return temp;
    }


    /**
     * 获取业主列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/ownerList")
    public TableData getOwnerList(TableFilter tableFilter,HttpServletRequest request)
    {
        if(request.getParameter("search[value]")!=null)
            tableFilter.setSearchValue(request.getParameter("search[value]"));
        else
            tableFilter.setSearchValue("");

        return null;
    }

    /**
     * 获取租客列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/authenticatedUserList")
    public TableData getTenantList(HttpServletRequest request)
    {
        return null;
    }

    /**
     * 获取认证用户的列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/tenantList")
    public TableData getAuthList(HttpServletRequest request)
    {
        return null;
    }



}
