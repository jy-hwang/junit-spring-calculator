package com.fastcampus.junitspringcalculator.controller;

import com.fastcampus.junitspringcalculator.component.Calculator;
import com.fastcampus.junitspringcalculator.dto.Req;
import com.fastcampus.junitspringcalculator.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

  private final Calculator calculator;

  @GetMapping("/plus")
  public int plus(@RequestParam int a, @RequestParam int b) {
    return calculator.plus(a, b);
  }

  @PostMapping("/minus")
  public Res minus(@RequestBody Req req) {
    int result = calculator.minus(req.getX(), req.getY());

    Res res = new Res();
    res.setResult(result);
    res.setResponse(new Res.Body());
    return res;
  }
}
