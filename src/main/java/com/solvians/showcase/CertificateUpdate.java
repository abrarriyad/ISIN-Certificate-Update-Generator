package com.solvians.showcase;

import java.util.concurrent.Callable;

public class CertificateUpdate implements Callable<String> {

    private static final IsinGenerator ISIN_GENERATOR = new IsinGenerator();

    private static final double MIN_PRICE = 100.00;
    private static final double MAX_PRICE = 200.00;

    private static final int MIN_BID_SIZE = 1000;
    private static final int MAX_BID_SIZE = 5000;

    private static final int MIN_ASK_SIZE = 1000;
    private static final int MAX_ASK_SIZE = 10000;
    @Override
    public String call() throws Exception {

        long timestamp = System.currentTimeMillis();
        String isin = ISIN_GENERATOR.generate();

        double bidPrice = generatePrice();
        int bidSize = generateBidSize();

        double askPrice = generatePrice();
        int askSize = generateAskSize();


        return String.format("%d,%s,%.2f,%d,%.2f,%d", timestamp, isin, bidPrice,bidSize, askPrice, askSize);
    }

    private double generatePrice(){
        double randomPrice = Utils.getRandomValue().nextDouble(MIN_PRICE, MAX_PRICE);

        return Utils.roundToTwoDecimals(randomPrice);
    }

    private int generateBidSize(){
        return Utils.getRandomValue().nextInt(MIN_BID_SIZE, MAX_BID_SIZE+1);
    }

    private int generateAskSize(){
        return Utils.getRandomValue().nextInt(MIN_ASK_SIZE, MAX_ASK_SIZE+1);
    }
}
