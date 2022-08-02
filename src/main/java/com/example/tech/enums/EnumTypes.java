package com.example.tech.enums;

public class EnumTypes {
    public static Short accountTypeFrom(AccountType accountType) {
        return switch (accountType) {
            case SAVINGS -> 1;
            case CURRENT -> 2;
        };
    }
    public static AccountType accountTypeTo(Short type) {
        return switch (type) {
            case 1 -> AccountType.SAVINGS;
            default -> AccountType.CURRENT;
        };
    }
}
