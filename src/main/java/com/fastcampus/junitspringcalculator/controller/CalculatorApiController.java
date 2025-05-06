package com.fastcampus.junitspringcalculator.controller;

import com.fastcampus.junitspringcalculator.component.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

  private final Calculator calculator;

  @GetMapping("/plus")
  public int plus(@RequestParam int a, @RequestParam int b) {
    return calculator.plus(a, b);
  }

  @GetMapping("/minus")
  public int minus(@RequestParam int a, @RequestParam int b) {
    return calculator.minus(a, b);
  }
}
