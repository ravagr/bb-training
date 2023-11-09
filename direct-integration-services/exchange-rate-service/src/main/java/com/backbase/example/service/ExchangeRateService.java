package com.backbase.example.service;

import com.backbase.exchange.rest.spec.v1.exchange.CurrenciesGetResponseBody;
import com.backbase.exchange.rest.spec.v1.exchange.RatesGetResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateService {
    @Qualifier(value="customRestTemplate")
    private final RestTemplate restTemplate;
    @Value("${transferwise.url.currencies}")
    private String transferwiseCurrenciesUrl;
    @Value("${transferwise.url.rates}")
    private String transferwiseRatesUrl;

    @Value("${transferwise.url.fee}")
    private String transferwiseFeeUrl;


    public List<CurrenciesGetResponseBody> retrieveCurrencies() {
        return restTemplate.exchange(transferwiseCurrenciesUrl, HttpMethod.GET, generateHeaders(), new ParameterizedTypeReference<List<CurrenciesGetResponseBody>>() {
        }).getBody();
    }

    public List<RatesGetResponseBody> retrieveRates(String source, String target, LocalDate from, LocalDate to) {
        LocalDateTime fromFormatted = from.atStartOfDay();
        LocalDateTime toFormatted = to.atTime(LocalTime.MAX);
        return restTemplate.exchange(transferwiseRatesUrl, HttpMethod.GET, generateHeaders(), new ParameterizedTypeReference<List<RatesGetResponseBody>>() {
        }, source, target, fromFormatted, toFormatted).getBody();
    }
/*
    public FeeGetResponseBody retrieveFee() {
        return restTemplate.exchange(transferwiseFeeUrl, HttpMethod.GET, generateHeaders(), new ParameterizedTypeReference<List<FeeGetResponseBody>>() {
        }).getBody();
    }
*/

    private HttpEntity generateHeaders() {
        log.info("Creating HttpEntity");
        HttpHeaders httpHeaders = new HttpHeaders();
        return new HttpEntity(httpHeaders);
    }

}
