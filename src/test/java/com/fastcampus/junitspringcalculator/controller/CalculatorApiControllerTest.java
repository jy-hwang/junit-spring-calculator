package com.fastcampus.junitspringcalculator.controller;

import com.fastcampus.junitspringcalculator.component.Calculator;
import com.fastcampus.junitspringcalculator.component.DollarCalculator;
import com.fastcampus.junitspringcalculator.component.MarketApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorApiController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
public class CalculatorApiControllerTest {

  @MockBean
  private MarketApi marketApi;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void init() {
    Mockito.when(marketApi.connect()).thenReturn(3000);
  }

  @Test
  public void sumTest() throws Exception {
    //http://localhost:80800/api/sum
    mockMvc.perform(
            MockMvcRequestBuilders.get("http://localhost:8080/api/plus")
                    .queryParam("a", "10")
                    .queryParam("b", "10")
    ).andExpect(MockMvcResultMatchers.status().isOk()
    ).andExpect(MockMvcResultMatchers.content().string("60000")
    ).andDo(MockMvcResultHandlers.print());
  }

}
