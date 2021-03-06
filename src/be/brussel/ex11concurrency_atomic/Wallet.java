package be.brussel.ex11concurrency_atomic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Wallet {

    public static void main(String[] args) {

        ConcurrentHashMap<Coin, Integer> wallet = new ConcurrentHashMap<>();
        Thread thread1 = new Thread(()->printSum(wallet));

        wallet.put(Coin.ONE_CENT, 2);
        wallet.put(Coin.TWO_CENT, 3);
        wallet.put(Coin.FIVE_CENT, 8);
        wallet.put(Coin.TEN_CENT, 1);
        wallet.put(Coin.TWENTY_CENT, 0);
        wallet.put(Coin.FIFTY_CENT, 9);
        wallet.put(Coin.ONE_EURO, 7);
        wallet.put(Coin.TWO_EURO, 1);

        thread1.start();
    }

    private static void printSum(ConcurrentHashMap<Coin, Integer> wallet){
        AtomicInteger sum = new AtomicInteger(0);
        for(Coin coin : wallet.keySet()){
            System.out.println(coin.name() + " : " + wallet.get(coin));
            sum.addAndGet(coin.getValue() * wallet.get(coin));
        }

        System.out.println((sum.get()/100F)+" euros");
    }

    enum Coin {
        ONE_CENT(1),
        TWO_CENT(2),
        FIVE_CENT(5),
        TEN_CENT(10),
        TWENTY_CENT(20),
        FIFTY_CENT(50),
        ONE_EURO(100),
        TWO_EURO(200);

        private int value;

        Coin(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}

