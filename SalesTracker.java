package YSixthPack;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SalesTracker {
    private ConcurrentHashMap<String, Integer> salesMap;

    public SalesTracker() {
        this.salesMap = new ConcurrentHashMap<>();
    }

    public void addSale(String product, int quantity, int cost) {
        salesMap.put(product, salesMap.getOrDefault(product, 0) + quantity * cost);
    }

    public void printSales() {
        System.out.println("Список проданных товаров:");
        salesMap.forEach((product, total) -> {
            System.out.println(product + " - " + total + " руб.");
        });
    }

    public double getTotalSales() {
        double totalSales = 0.0;
        for (int total : salesMap.values()) {
            totalSales += total ;
        }
        return totalSales;
    }

    public String getMostPopularProduct() {
        int maxSales = 0;
        String mostPopularProduct = "";
        for (String product : salesMap.keySet()) {
            int sales = salesMap.get(product);
            if (sales > maxSales) {
                maxSales = sales;
                mostPopularProduct = product;
            }
        }
        return mostPopularProduct;
    }

    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();

        salesTracker.addSale("Молоко", 10, 100);
        salesTracker.addSale("Хлеб", 20, 30);
        salesTracker.addSale("Сахар", 5, 777);
        salesTracker.addSale("Звезда Смерти", 2, 2500000);
        salesTracker.addSale("Световые мечи", 4, 1000000);
        salesTracker.addSale("Лимоны", 3, 100);
        salesTracker.addSale("Сахар", 20, 700); //скидка

        salesTracker.printSales();
        System.out.println("Общая сумма продаж: " + salesTracker.getTotalSales() + " руб.");
        System.out.println("Товар с наибольшей прибылью: " + salesTracker.getMostPopularProduct());
    }
}