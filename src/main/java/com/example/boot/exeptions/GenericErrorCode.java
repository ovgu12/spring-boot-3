package com.example.boot.exeptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GenericErrorCode {
    NOT_FOUND(404),
    BAD_REQUEST(400);

    private final int status;
}
