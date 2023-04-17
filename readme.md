# Nga论坛移动端Api实现
根据安卓APK反编译和网络抓包获得接口，不保证可靠性

## 使用方法
```
String accessToken = "" // 登录接口未实现，暂时先自行获取
String accessUid = "" // 登录接口未实现，暂时先自行获取

// 创建Client实例
INgaClient ngaClient = new NgaClient(accessToken, accessUid);

// 调用接口
var result = ngaClient.homeCategoryV2();
```

## 已实现的接口
| 描述           | 接口             | 参数            |
|--------------|----------------|---------------|
| 获取板块列表       | homeCategoryV2 |               |
| 获取板块下的主题（分页） | subjectList    | 板块id, 页码      |
| 获取收藏的板块      | forumFavor2Get |               |
| 搜索主题         | subjectSearch  | 板块ID, 关键词, 页码 |
| 获取主题下回复      | postList       | 主题ID, 页码      |