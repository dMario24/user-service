package com.example.user_service;

import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.math.BigInteger;

@RestController
public class SimpleController {

    // 🌟 시스템 환경 변수 'CPU_STRESS_NUMBER'를 읽고, 없으면 기본값 20000을 사용합니다.
    @Value("${CPU_STRESS_NUMBER:20000}")
    private int stressNumber;

    @GetMapping("/hello")
    public Map<String, Object> sayHello(){

        return Map.of(
            "message", "Hello, Jenkins!",
            "timesptamp", System.currentTimeMillis(),
            "koreatime", ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toString()
        );
    }

    /**
     * 시스템 환경 변수 (CPU_STRESS_NUMBER)를 사용하여 CPU 부하를 유발하는 엔드포인트.
     */
    @GetMapping("/hello2")
    public Map<String, Object> calculateHeavyTask() {
        long startTime = System.currentTimeMillis();

        // 설정된 stressNumber 값을 사용하여 팩토리얼 계산
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= stressNumber; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        String resultSnippet = result.toString().substring(0, Math.min(result.toString().length(), 50)) + "...";

        return Map.of(
            "message", "CPU-heavy calculation completed.",
            "input_number", stressNumber,
            "calculation_duration_ms", duration,
            "result_snippet", resultSnippet,
            "koreatime", ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toString()
        );
    }
}
