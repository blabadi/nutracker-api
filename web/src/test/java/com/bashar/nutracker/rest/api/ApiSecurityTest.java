package com.bashar.nutracker.rest.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Bashar on 2017-11-05.
 */
@RunWith(SpringRunner.class)
@Secure
public class ApiSecurityTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testFoodUnauthorized() throws Exception {
        mvc.perform(get("/api/food/"))
            .andDo(print())
            .andExpect(status().is(401));
    }
}
