package com.codedog.gitstar.wx.rest;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest extends BaseControllerTest{

    @Autowired
    private AuthController authController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    /**
     * .perform() : 执行一个MockMvcRequestBuilders的请求；MockMvcRequestBuilders有.get()、.post()、.put()、.delete()等请求。
     * .andDo() : 添加一个MockMvcResultHandlers结果处理器,可以用于打印结果输出(MockMvcResultHandlers.print())。
     * .andExpect : 添加MockMvcResultMatchers验证规则，验证执行结果是否正确。
     */
    @Test
    @Rollback(false)
    void createAuthenticationTokenByCode() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/jwt/loginByCode").content("021s7all2Qvqb64H2lnl2qyvXm3s7alg"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(content().string(containsString("Hello World")))
                .andReturn();
    }
}