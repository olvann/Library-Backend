package com.ximple.library.enums;

public enum BookStatus {
    AVAILABLE,
    UNAVAILABLE,
    DELETED;

    public static boolean isAvailable(BookStatus status) {
        return status == AVAILABLE;
    }
}
