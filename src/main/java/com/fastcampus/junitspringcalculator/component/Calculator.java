package com.fastcampus.junitspringcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {
  private final ICalculator iCalculator;

  public int plus(int x, int y) {
    this.iCalculator.init();
    return this.iCalculator.plus(x, y);
  }

  public int minus(int x, int y) {
    this.iCalculator.init();
    return this.iCalculator.minus(x, y);
  }
}
