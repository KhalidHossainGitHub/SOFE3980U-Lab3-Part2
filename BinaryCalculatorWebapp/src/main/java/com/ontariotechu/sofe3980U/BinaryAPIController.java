package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String addString(@RequestParam String operand1, @RequestParam String operand2) {
        return Binary.add(new Binary(operand1), new Binary(operand2)).getValue();
    }

    @GetMapping("/and")
    public String andString(@RequestParam String operand1, @RequestParam String operand2) {
        return Binary.and(new Binary(operand1), new Binary(operand2)).getValue();
    }

    @GetMapping("/or")
    public String orString(@RequestParam String operand1, @RequestParam String operand2) {
        return Binary.or(new Binary(operand1), new Binary(operand2)).getValue();
    }

    @GetMapping("/multiply")
    public String multiplyString(@RequestParam String operand1, @RequestParam String operand2) {
        return Binary.multiply(new Binary(operand1), new Binary(operand2)).getValue();
    }

    @GetMapping("/add_json")
    public BinaryAPIResult addJSON(@RequestParam String operand1, @RequestParam String operand2) {
        return new BinaryAPIResult(new Binary(operand1), "add", new Binary(operand2), Binary.add(new Binary(operand1), new Binary(operand2)));
    }
}