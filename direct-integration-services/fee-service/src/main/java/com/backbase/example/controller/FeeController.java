package com.backbase.example.controller;

import com.backbase.buildingblocks.presentation.errors.BadRequestException;
import com.backbase.buildingblocks.presentation.errors.InternalServerErrorException;
import com.backbase.fee.rest.spec.serviceapi.v1.fee.FeeApi;
import com.backbase.fee.rest.spec.v1.fee.FeeGetResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/service-api/v1/fee")
@RestController
public class FeeController implements FeeApi {

    @Override
    public FeeGetResponseBody getFee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
       System.out.println("From Fee Service");
        return new FeeGetResponseBody().withFee(1.2124);
    }
}
