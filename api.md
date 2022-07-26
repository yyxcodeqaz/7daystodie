# daysToDie Api
***
* <font color=#e74c3c> RootAuthority接口 </font>
* <font color=#f1c40f> UserAuthority接口 </font>
* <font color=#2ecc71> NoAuthority接口 </font>
***
## User Api 
***
>### <font color=#f1c40f> 获取当前用户已有的Mod </font>
>> #### 请求url：/getUserHoldMods
>>> ##### 请求参数
>>>> * SteamId id  //当前用户的steamId
>>>> * UserQq qq   //当前用户的Qq
***
>### 返回数据
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

***
## Mod Api
***
>### <font color=#f1c40f> 获取全部白名单 </font>
>> #### 请求url：/getWhiteList
***
>### 返回数据
|         返回参数         |  参数类型  |    参数说明    |
|:--------------------:|:------:|:----------:|
|     whiteListId      |  long  |  白名单ModId  |
|    whiteListName     | String |  白名单Mod名称  |
|   whiteListOnline    |  long  | 白名单Mod是否在线 |
|  whiteListNameDesc   | String | 白名单ModDesc |
| whiteListNameAuthor  | String | 白名单Mod的作者  |
| whiteListNameVersion | String | 白名单Mod的版本  |
