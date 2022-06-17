import java.io.*;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.StringTokenizer;

public class CarRental {
    public static void main(String[] args) throws IOException {
        Formatter formatter;
        DecimalFormat priceformatter = new DecimalFormat("#0.00");
        try {
            String Name, ic, Carname;
            double deposit, priceperday = 0, balance;
            int day;

            FileReader fr = new FileReader("CarRental.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw1 = new FileWriter("PaymentBalance.txt");
            PrintWriter pw1 = new PrintWriter(fw1);
            FileWriter fw2 = new FileWriter("Customer.txt");
            PrintWriter pw2 = new PrintWriter(fw2);

            String line = br.readLine();
            formatter = new Formatter();

            pw1.println(formatter.format("%-40s %-20s %-20s %-20s %-10s %-10s %-15s %n", "CUSTOMER NAME", " IC NUMBER", "TYPE OF CAR", "NUMBER OF DAYS", "DEPOSIT", "TOTAL", "BALANCE"));
            formatter = new Formatter();

            pw2.println(formatter.format("%-40s %-20s %-20s %-20s", "CUSTOMER NAME", "IC NUMBER", "TYPE OF CAR", "BALANCE"));
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                Name = st.nextToken();
                ic = st.nextToken();
                day = Integer.parseInt(st.nextToken());
                Carname = st.nextToken();
                deposit = Double.parseDouble(st.nextToken());

                if (Carname.equalsIgnoreCase("Toyota Vellfire")) {
                    priceperday = 750.0;
                } else if (Carname.equalsIgnoreCase("Honda Civic")) {
                    priceperday = 550.0;
                } else if (Carname.equalsIgnoreCase("Proton Preve")) {
                    priceperday = 300.0;
                } else if (Carname.equalsIgnoreCase("Perodua Myvi")) {
                    priceperday = 250.0;
                }

                double total_payment = day * priceperday;
                balance = total_payment - deposit;

                formatter = new Formatter();
                pw1.println(formatter.format("%-40s %-20s %-20s %-20s %-10s %-10s %-15s", Name, ic, Carname, day, deposit, priceformatter.format(total_payment), priceformatter.format(balance)));

                if (balance > 1000) {
                    formatter = new Formatter();
                    pw2.println(formatter.format("%-40s %-20s %-20s %-20s", Name, ic, Carname, priceformatter.format(balance)));
                }
                line = br.readLine();
            }
            pw1.close();
            pw2.close();
            br.close();

        } catch (FileNotFoundException fnf) {
            System.out.print(fnf.getMessage());
        } catch (EOFException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException io) {
            System.out.print(io.getMessage());
        } catch (Exception nf) {
            System.out.print(nf);
        } finally {
            System.out.println("System ends here... Bye Bye");
        }
    }
}
