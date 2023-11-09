package com.backbase.example;

import com.backbase.buildingblocks.presentation.errors.BadRequestException;
import com.backbase.buildingblocks.presentation.errors.InternalServerErrorException;

import com.backbase.exchange.rest.spec.v1.exchange.CurrenciesGetResponseBody;
import com.backbase.exchange.rest.spec.v1.exchange.ExchangeApi;
import com.backbase.exchange.rest.spec.v1.exchange.FeeGetResponseBody;
import com.backbase.exchange.rest.spec.v1.exchange.RatesGetResponseBody;
import com.backbase.example.service.ExchangeRateService;
import com.backbase.fee.listener.client.v1.fee.FeeFeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@RequestMapping({"/client-api/v1/exchange"})
@RestController
@RequiredArgsConstructor
public class ExchangeRateController implements ExchangeApi {

    @Autowired
    private ExchangeRateService exchangeRateService;

    private final FeeFeeClient feeClient;

    @Override
    public List<CurrenciesGetResponseBody> getCurrencies(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
        System.out.println("Inside ExchangeRate");
        return exchangeRateService.retrieveCurrencies();
    }

    @Override
    public List<RatesGetResponseBody> getRates(String source, String target, LocalDate from, LocalDate to, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
        return exchangeRateService.retrieveRates(source, target, from, to);
    }

    @Override
    public FeeGetResponseBody getFee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
        System.out.println("Inside ExchangeRate - fee");

        com.backbase.fee.rest.spec.v1.fee.FeeGetResponseBody feeGetResponseBody = feeClient.getFee().getBody();
        return new FeeGetResponseBody().withFee(feeGetResponseBody.getFee());
        //return null;
    }
}
