package com.mmall.service.imp;

import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    public ServerResponse addCategory(String categoryName,Integer parentId){
        if(parentId==null|| StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("添加品类错误");
        }
        Category category =new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);

        int rowCount =categoryMapper.insert(category);
        if(rowCount==0){
            return ServerResponse.createByErrorMessage("添加品类失败");
        }else{
            return ServerResponse.createBySuccessMessage("添加品类成功");
        }
    }

    public ServerResponse updateCategoryName(Integer categoryNameId,String categoryName){
        if(categoryNameId==null||StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("更新失败，ID或名字为空");
        }
        Category category=new Category();
        category.setId(categoryNameId);
        category.setName(categoryName);
        int rowwCount =categoryMapper.updateByPrimaryKeySelective(category);
        if(rowwCount>0){
            return ServerResponse.createBySuccessMessage("更新品类成功");
        }
        return ServerResponse.createByErrorMessage("更新品类失败");
    }
}
