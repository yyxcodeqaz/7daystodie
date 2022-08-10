# daysToDie Api

***

* <span style="color: #e74c3c; "> RootAuthority接口 </span>
* <span style="color: #f1c40f; "> UserAuthority接口 </span>
* <span style="color: #2ecc71; "> NoAuthority接口 </span>

***

## User Api

***
> ### <font color=#f1c40f> 获取当前用户已有的Mod </font>
>> #### 请求url：/getUserHoldMods
>>> ##### 请求参数
>>>> * SteamId id //当前用户的steamId
>>>> * UserQq qq //当前用户的Qq
>>>> * commodityKey key //当前mod的key

> ### 返回数据

|        返回参数         |  参数类型  |     参数说明      |
|:-------------------:|:------:|:-------------:|
|       userId        |  long  |  当前用户的userId  |
|       steamId       | String | 当前用户的steamId  |
|       userQq        | String |    当前用户的Qq    |
|    authorityName    | String |    当前用户的权限    |
|     commodityId     |  long  |   当前Mod的Id    |
|    commodityName    | String |   当前Mod的名称    |
|    commodityCode    | String |   当前Mod的内容    |
|  commodityVersion   | String |   当前Mod的版本    |
| commodityContentKey | String | 当前ModCode的key |
|    commodityKey     | String |   当前Mod的key   |
|  holdCommodityTime  |  long  | 此用户授权当前MOD的时间 |
>### 数据样式
```json
{
  "userId": 1,
  "steamId": "123",
  "userQq": "123",
  "authorityName": "root",
  "commodityId": 1,
  "commodityName": "asd",
  "commodityCode": "awdawdaw",
  "commodityVersion": "144",
  "holdCommodityTime": 123456,
  "commodityContentKey": "kk",
  "commodityKey": "kk"
}
```
***
***


## Mod Api

***
> ### <font color=#f1c40f> 获取全部白名单 </font>
>> #### 请求url：/getWhiteList
***
> ### 返回数据

|         返回参数         |  参数类型  |    参数说明    |
|:--------------------:|:------:|:----------:|
|     whiteListId      |  long  |  白名单ModId  |
|    whiteListName     | String |  白名单Mod名称  |
|   whiteListOnline    |  long  | 白名单Mod是否在线 |
|  whiteListNameDesc   | String | 白名单ModDesc |
| whiteListNameAuthor  | String | 白名单Mod的作者  |
| whiteListNameVersion | String | 白名单Mod的版本  |
>### 数据样式
```json
{
  "whiteListId": 1,
  "whiteListName": "asd",
  "whiteListOnline": 1,
  "whiteListNameDesc": "ad13w",
  "whiteListNameAuthor": "dawda",
  "whiteListNameVersion": "144"
}
```