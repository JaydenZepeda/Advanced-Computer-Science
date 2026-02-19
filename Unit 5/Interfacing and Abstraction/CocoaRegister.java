import java.util.ArrayList;

public class CocoaRegister {

    public static final double TAX_RATE = 0.0875;

    private ArrayList<Sellable> items;
    private ArrayList<Integer> quantities;

    public CocoaRegister() {
        items = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(Sellable item, int quantity) {
        if (item == null || quantity <= 0) {
            // nothing
        } else {
            this.items.add(item);
            this.quantities.add(quantity);
        }
    }

    public double getSubtotal() {
        double sum = 0;
        for (int i = 0; i < (this.items.size()); i++) {
            sum += items.get(i).getBasePrice() * quantities.get(i);
        }
        return ChocolateBar.round2(sum);
    }

    public double getTax() {
        return ChocolateBar.round2(getSubtotal() * TAX_RATE);
    }

    public double getTotal() {
        double total = getSubtotal() + getTax();
        return ChocolateBar.round2(total);
    }

    public void printReceipt() {
        String l1 = "== COCOA CORNER ==" + "\n";
        String l2 = "";
        for (int i = 0; i < items.size(); i++) {
            l2 += (i + 1) + ". " + items.get(i).getName() + " x" + quantities.get(i) + " @ $"
                    + ChocolateBar.money(items.get(i).getBasePrice()) + " = $"
                    + ChocolateBar.money(items.get(i).getBasePrice() * quantities.get(i)) + "\n";
        }
        String l3 = "Subtotal: $" + ChocolateBar.money(getSubtotal()) + "\n";
        String l4 = "Tax: $" + ChocolateBar.money(getTax()) + "\n";
        String l5 = "Total: $" + ChocolateBar.money(getTotal()) + "\n";
        System.out.println(l1 + l2 + l3 + l4 + l5);
    }

}
