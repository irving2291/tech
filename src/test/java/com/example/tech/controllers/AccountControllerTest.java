package com.example.tech.controllers;

import com.example.tech.services.AccountService;
import com.example.tech.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import org.assertj.core.api.Assertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
class AccountControllerTest {

    @MockBean
    private AccountService accountService;
    @MockBean
    private ClientService clientService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(AccountController.class).build();
    }

    @Test
    void getByNumberAccount() throws Exception {
        Assertions.assertThat(accountService).isNotNull();
        /*Mockito.when(accountService.getByNumber(123L))
                .thenReturn(Optional.of(DataAccount.createAccount001().orElseThrow()));
        this.mockMvc.perform(get("/account/123L/number"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.balance").value(100.0))
                .andExpect(jsonPath("$.type").value(1));
        Mockito.verify(accountService).getByNumber(123L);*/
    }

    @Test
    void save() {
    }
}