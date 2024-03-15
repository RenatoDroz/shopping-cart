package com.renato.shoppingcart.constants;

import lombok.Getter;

public final class AuthConstants {
    public static final String SECRET_KEY = "9f3ac7be32e38ba56fad73f9766468f651199670bc93f9a28dc4fd9199a6300d";
    public static final String BEARER = "Bearer ";
    public static final long EXPIRATION_TIME_IN_MILLIS = 24 * 60 * 60 * 1000;
    public static final String ISSUER = "shopping cart";
}
