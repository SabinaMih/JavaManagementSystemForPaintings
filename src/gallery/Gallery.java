package gallery;
import java.util.ArrayList;

public class Gallery {
    private ArrayList<Panting> pantings = new ArrayList();

    //default constructor
    public Gallery(){
    }
    // method to add new panting
    public void addPanting(String artist, String title, double purchase_price, double selling_price, int year){
        Panting p = new Panting(artist, title, purchase_price, selling_price, year);
        this.pantings.add(p);
    }

    // display all paintings
    public void displayList(){
        System.out.println("Paintings");
        System.out.printf("%-20s  %-30s %-20s %-18s%n", "Artist:","| Title: ", "| Purchase Price: ",  "| Selling Price: ");

        for(int i = 0; i < this.pantings.size(); ++i) {
            System.out.printf("%-20s |%-30s | €%,15.2f | €%,15.2f%n", ((Panting)this.pantings.get(i)).getArtist(),
                    ((Panting)this.pantings.get(i)).getTitle(), ((Panting)this.pantings.get(i)).getPurchase_price(), ((Panting)this.pantings.get(i)).getSelling_price());

        }
    }

    // calculate and display the government tax
    public void calcGovernmentTax(){
        final double Y_1450_1550_RATE = 0.01;
        final double Y_1551_1700_RATE = 0.05;
        final double Y_1701_1900_RATE = 0.07;
        System.out.println("Tax due on Paintings:\n");
        System.out.printf("%-30s %-20s%n", " Title:", "| Tax Due: ");
        for(int i = 0; i < this.pantings.size(); ++i) {
            double charge_tax = 0.0;
            if(((Panting)this.pantings.get(i)).getYear() >= 1450 && ((Panting)this.pantings.get(i)).getYear() <= 1550){
                charge_tax =( ((Panting)this.pantings.get(i)).getPurchase_price() * Y_1450_1550_RATE);
            }else if(((Panting)this.pantings.get(i)).getYear() >= 1551 && ((Panting)this.pantings.get(i)).getYear() <= 1700){
                charge_tax =( ((Panting)this.pantings.get(i)).getPurchase_price() * Y_1551_1700_RATE);
            }else{
                charge_tax =( ((Panting)this.pantings.get(i)).getPurchase_price() * Y_1701_1900_RATE);
            }
            System.out.printf("%-30s | €%,15.2f%n", ((Panting)this.pantings.get(i)).getTitle(), charge_tax);
        }
    }
    //calculate the tax on profit and display the total tax
    public void calcTaxOnProfit(){
        final double TAX_RATE = 0.12;
        double total_tax_paid = 0.0D;
        System.out.printf("%-30s %-30s%n", " Title:", "          | Tax on profit: ");
        for(int i = 0; i < this.pantings.size(); ++i) {
            double tax_profit = 0.0D;
            double profit = 0.0D;
            profit = ((Panting)this.pantings.get(i)).getSelling_price() - ((Panting)this.pantings.get(i)).getPurchase_price();
            if(profit >= 0.0){
                tax_profit = (profit * TAX_RATE);
                System.out.printf("%-40s | €%,15.2f%n", ((Panting)this.pantings.get(i)).getTitle(), tax_profit);
                total_tax_paid += tax_profit;
            }else{
                try {
                    throw new PaintingSoldAtLoss();
                }catch (PaintingSoldAtLoss psl){
                    System.out.println(" " + psl.getMessage());
                    System.out.printf("%-40s | €%,15.2f%n", ((Panting)this.pantings.get(i)).getTitle(), tax_profit);
                }
            }
        }
        System.out.printf("\n Total Tax Paid: €%,15.2f%n ", total_tax_paid);


    }
}
