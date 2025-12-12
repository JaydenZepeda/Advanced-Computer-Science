public class OrderProcessor {

    public static OrderSummary processCustomerOrder(Item[] items, double taxRate) {

        System.out.println("Subtotal: $" + OrderProcessor.calculateSubtotal(items));
        System.out.println("Tax: $" + OrderProcessor.calculateTaxTotal(items, taxRate)[0]);
        System.out.println("Total: $" + OrderProcessor.calculateTaxTotal(items, taxRate)[1]);
        System.out.println("Number of premium items: " + OrderProcessor.premiumCount(items));

        return new OrderSummary(OrderProcessor.calculateTaxTotal(items, taxRate)[1],
                OrderProcessor.calculateSubtotal(items), OrderProcessor.calculateTaxTotal(items, taxRate)[0],
                OrderProcessor.getExpensiveItems(items));
    }

    public static double calculateSubtotal(Item[] items) {
        double subtotal = 0;
        for (Item item : items) {
            double itemTotal = item.getPrice() * item.getQuantity();
            subtotal += itemTotal;
        }
        return subtotal;
    }

    public static int premiumCount(Item[] items) {
        int premiumCount = 0;
        for (Item item : items) {
            if (item.getPrice() > 50.0) {
                premiumCount += 1;
                System.out.println(item.getName() + " is a premium item at $" + item.getPrice());
            } else {
                System.out.println(item.getName() + " is a regular item at $" + item.getPrice());
            }
        }
        return premiumCount;
    }

    public static String[] getExpensiveItems(Item[] items) {
        int x = 0;
        String[] expensiveItems = new String[OrderProcessor.premiumCount(items)];
        for (int i = 0; i < items.length; i++) {
            if (items[i].getPrice() > 50.0) {
                expensiveItems[x] = items[i].getName();
                x++;
            }
        }
        return expensiveItems;
    }

    public static double[] calculateTaxTotal(Item[] items, double taxRate) {
        double[] taxTotal = new double[2];
        double tax = 0;
        double total = 0;
        if (OrderProcessor.calculateSubtotal(items) > 0) {
            tax = OrderProcessor.calculateSubtotal(items) * taxRate;
            total = OrderProcessor.calculateSubtotal(items) + tax;
        } else {
            tax = 0;
            total = 0;
        }
        taxTotal[0] = tax;
        taxTotal[1] = total;
        return taxTotal;
    }
}
