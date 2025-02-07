package com.cafenawa.user.dto;

public record JwtToken(
        String accessToken,
        String refreshToken
) {

}
