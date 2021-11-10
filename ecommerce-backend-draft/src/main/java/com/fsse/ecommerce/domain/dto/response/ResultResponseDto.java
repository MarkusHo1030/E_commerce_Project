package com.fsse.ecommerce.domain.dto.response;

public class ResultResponseDto {
    private String result;

    private ResultResponseDto() {}

    public static ResultResponseDto success() {
        ResultResponseDto dto = new ResultResponseDto();
        dto.result = "SUCCESS";
        return dto;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ResultResponseDto{" +
                "result='" + result + '\'' +
                '}';
    }
}
