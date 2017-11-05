package com.bashar.nutracker.rest.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by Bashar on 2017-11-05.
 */

/**
 * see: https://spring.io/guides/gs/testing-web/ - integration web tests for spring mvc with spring boot
 */
@Insecure
@RunWith(SpringRunner.class)
public class TestFoodApi {
    @Autowired
    MockMvc mvc;

    @Test
    public void testGetAllFoodEmpty() throws Exception {
        mvc.perform(get("/food/"))
            .andDo(print())
            .andExpect(content().string("[]"));
    }
}
