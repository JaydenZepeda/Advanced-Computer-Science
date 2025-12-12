public class ChocolateBarShop {

    private String[] barTypes;
    private String[] barPrices; // string labels only
    private int[] inventory;

    public ChocolateBarShop() {
        barTypes = new String[] {
                "MILK_SMALL",
                "MILK_LARGE",
                "DARK_ALMOND",
                "WHITE_COOKIE"
        };

        barPrices = new String[] {
                "1.50",
                "2.50",
                "2.00",
                "2.25"
        };

        inventory = new int[] {
                50,
                40,
                30,
                20
        };
    }

    // ---------- Public API ----------

    public void printInventory() {
        for (int i = 0; i < barTypes.length; i++) {
            System.out.println(buildInventoryLine(i));
        }
    }

    /**
     * Now processOrder is an orchestrator that calls smaller methods:
     * 1) Validate bar type and quantity.
     * 2) Check and update stock.
     * 3) Log/print confirmation.
     */
    public void processOrder(String barType, int quantity) {
        int index = findBarIndexOrThrow(barType);
        validatePositiveQuantity(quantity);
        ensureStock(index, quantity);

        deductStock(index, quantity);

        logOrder(index, quantity);
    }

    public void restock(String barType, int amount) {
        validatePositiveQuantity(amount);
        int index = findBarIndexOrThrow(barType);
        addStock(index, amount);
        logRestock(index, amount);
    }

    // ---------- Lookup & validation helpers ----------

    private int findBarIndexOrThrow(String barType) {
        int index = -1;
        for (int i = 0; i < barTypes.length; i++) {
            if (barTypes[i].equals(barType)) {
                index = i;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Unknown chocolate bar type: " + barType);
        }

        return index;
    }

    private void validatePositiveQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }

    private void ensureStock(int index, int quantity) {
        int current = inventory[index];
        if (current < quantity) {
            throw new IllegalStateException("Not enough stock. Requested: " + quantity + ", available: " + current);
        }
    }

    // ---------- Inventory mutation ----------

    private void deductStock(int index, int quantity) {
        inventory[index] = inventory[index] - quantity;
    }

    private void addStock(int index, int amount) {
        inventory[index] = inventory[index] + amount;
    }

    // ---------- Logging / formatting ----------

    private String buildInventoryLine(int index) {
        String displayName = getDisplayName(barTypes[index]);
        int stock = inventory[index];
        String priceLabel = barPrices[index];

        return "[Inventory] " + displayName
                + " | stock: " + stock
                + " | price label: $" + priceLabel;
    }

    private void logOrder(int index, int quantity) {
        String displayName = getDisplayName(barTypes[index]);
        String priceLabel = barPrices[index];
        int remaining = inventory[index];

        System.out.println("[Order] " + quantity + " x " + displayName
                + " | price label: $" + priceLabel + " | remaining stock: " + remaining);
    }

    private void logRestock(int index, int amount) {
        String displayName = getDisplayName(barTypes[index]);
        int newStock = inventory[index];

        System.out.println("[Restock] " + displayName + " | added: " + amount
                + " | new stock: " + newStock);
    }

    // One place for the "nice" names (no switch, just if/else).
    private String getDisplayName(String barType) {
        if (barType.equals("MILK_SMALL")) {
            return "Milk Chocolate (Small)";
        } else if (barType.equals("MILK_LARGE")) {
            return "Milk Chocolate (Large)";
        } else if (barType.equals("DARK_ALMOND")) {
            return "Dark Chocolate with Almonds";
        } else if (barType.equals("WHITE_COOKIE")) {
            return "White Chocolate with Cookie Bits";
        } else {
            return barType;
        }
    }
}