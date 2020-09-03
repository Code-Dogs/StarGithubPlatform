1. 认证机制
    1.1 token认证：  
        每个http协议如下：  
            header:  
            token: 认证token  
                     timestamp: 当前请求的时间戳
                     sign: 接口认证加密
            

            
/auth/login
header: 