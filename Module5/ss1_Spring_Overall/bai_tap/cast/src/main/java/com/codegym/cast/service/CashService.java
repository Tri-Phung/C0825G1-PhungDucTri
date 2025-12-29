package com.codegym.cast.service;

import org.springframework.stereotype.Service;

@Service
public class CashService {
    public double convert(double usd) {
        return usd * 26290.95;
    }
}
