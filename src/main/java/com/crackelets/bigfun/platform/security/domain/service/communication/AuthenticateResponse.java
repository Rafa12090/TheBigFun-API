package com.crackelets.bigfun.platform.security.domain.service.communication;

import com.crackelets.bigfun.platform.shared.domain.service.communication.BaseResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthenticateResponse extends BaseResponse<AuthenticateResponse> {

    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResponse resource) {
        super(resource);
    }
}
