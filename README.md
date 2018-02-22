这是用SSM（Spring+SpringMVC+MyBatis）开发的一个登录接口，maven插件对项目进行了初始化，并使用了mybatis插件对项目的pojo层与dao层进行了初始化
，主要实现了一下接口，目前可以用java实现如下等简单的功能：
后台管理员登录
/manage/user/login.do
request
String username,
String password
response
{
    "status": 0,
    "data": {
        "id": 12,
        "username": "aaa",
        "email": "aaa@163.com",
        "phone": null,
        "role": 0,
        "createTime": 1479048325000,
        "updateTime": 1479048325000
    }
}
fail

{
    "status": 1,
    "msg": "密码错误"
}
####2.用户列表

/manage/user/list.do

request

pageSize(default=10)
pageNum(default=1)
response

success

{
    "status": 0,
    "data": {
        "pageNum": 1,
        "pageSize": 3,
        "size": 3,
        "orderBy": null,
        "startRow": 1,
        "endRow": 3,
        "total": 16,
        "pages": 6,
        "list": [
            {
                "id":17,
                "username":"rosen",
                "password":"",
                "email":"rosen1@happymmall.com",
                "phone":"15011111111",
                "question":"啊哈哈",
                "answer":"服不服",
                "role":0,
                "createTime":1489719093000,
                "updateTime":1513682138000
            },
            {
                "id":17,
                "username":"rosen",
                "password":"",
                "email":"rosen1@happymmall.com",
                "phone":"15011111111",
                "question":"啊哈哈",
                "answer":"服不服",
                "role":0,
                "createTime":1489719093000,
                "updateTime":1513682138000
            }
        ],
        "firstPage": 1,
        "prePage": 0,
        "nextPage": 2,
        "lastPage": 6,
        "isFirstPage": true,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "navigatePages": 8,
        "navigatepageNums": [
          1,
          2,
          3,
          4,
          5,
          6
        ]
    }
}
fail

{
  "status": 10,
  "msg": "用户未登录,请登录"
}


或

{
  "status": 1,
  "msg": "没有权限"
}
#############################################
后台_品类接口
/manage/category/get_category.do

request

categoryId(default=0)

response

success

{
    "status": 0,
    "data": [
        {
            "id": 2,
            "parentId": 1,
            "name": "手机",
            "status": true,
            "sortOrder": 3,
            "createTime": 1479622913000,
            "updateTime": 1479622913000
        },
        {
            "id": 4,
            "parentId": 1,
            "name": "移动座机",
            "status": true,
            "sortOrder": 5,
            "createTime": 1480059936000,
            "updateTime": 1480491941000
        }
    ]
}

http://localhost:8080/manage/category/get_category.do?categoryId=19

fail

{
    "status": 10,
    "msg": "用户未登录,请登录"
}
或

{
    "status": 1,
    "msg": "未找到该品类"
}
####2.增加节点

/manage/category/add_category.do

request

parentId(default=0)
categoryName
response

success

{
    "status": 0,
    "msg": "添加品类成功"
}
fail

{
    "status":1,
    "msg": "添加品类失败"
}
