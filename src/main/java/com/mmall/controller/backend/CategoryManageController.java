package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("manage/category")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId",defaultValue = "0") int parentId){
        User user =(User)session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请重新登录");
        }
        //校验是否为管理员
        if(iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            return iCategoryService.addCategory(categoryName,parentId);

        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("set_category_name.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session,Integer categoryNameId,String categoryName){
        User user =(User)session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请重新登录");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            return iCategoryService.updateCategoryName(categoryNameId,categoryName);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session,Integer categoryNameId){
        User user =(User)session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请重新登录");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            return iCategoryService.getChildrenParallelCategory(categoryNameId);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }
}
