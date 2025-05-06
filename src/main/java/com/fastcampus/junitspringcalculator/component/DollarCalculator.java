package com.fastcampus.junitspringcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {

  private int price = 1;

  private final MarketApi marketApi;

  @Override
  public void init() {
    this.price = marketApi.connect();
  }

  @Override
  public int plus(int a, int b) {
    a *= price;
    b *= price;
    return a + b;
  }

  @Override
  public int minus(int a, int b) {
    a *= price;
    b *= price;
    return a - b;
  }
}
