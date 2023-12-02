package com.example.boot.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GenericErrorCode {
    NOT_FOUND(404);
    private final int status;
}
