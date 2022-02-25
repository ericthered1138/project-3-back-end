package com.project3.revtech.controller;

import com.project3.revtech.dao.PurchasedItemRepository;
import com.project3.revtech.entity.PurchasedItem;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.PurchasedItemPojo;
import com.project3.revtech.service.PurchasedItemService;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchasedItemsControllerTest {

    @Autowired
    private PurchasedItemsController purchasedItemsController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(purchasedItemsController).isNotNull();
    }


    @Test
    public void addManyItemsUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/many/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void getItemsByTransactionIdUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/transaction/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void getItemsByUserIdUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/user/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }
}
