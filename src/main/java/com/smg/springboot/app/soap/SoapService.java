package com.smg.springboot.app.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import soap.numberconversion.NumberConversion;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.math.BigInteger;

@WebService
public class SoapService {
    private static  final Logger log = LoggerFactory.getLogger(SoapService.class);

    public static void main(String[] args) {
      try {
         NumberConversion numberConversion = new NumberConversion();
          BigInteger num1 = BigInteger.valueOf(500);
          BigDecimal num2 = BigDecimal.valueOf(50.20);
          String resultado = numberConversion.getNumberConversionSoap().numberToDollars(num2);
          log.debug(resultado);


      }catch (Exception ex){
          log.debug(ex.toString());

      }
        

        
    }
}
