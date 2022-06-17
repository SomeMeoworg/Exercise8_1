import java.io.*;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.StringTokenizer;

public class HotelRoom {
    public static void main(String[] args) throws IOException
    {
        Formatter formatter;
        DecimalFormat df = new DecimalFormat("#0.00");
        try{
            String name, ic, roomtype;
            int days;
            double deposit, total_payment, balance, priceperday = 0;

            FileReader fr = new FileReader("HotelRoom.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("TotalPayment.txt");
            PrintWriter pw = new PrintWriter(fw);
            FileWriter fw2 = new FileWriter("FinalPayment.txt");
            PrintWriter pw2 = new PrintWriter(fw2);

            String line = br.readLine();
            formatter = new Formatter();

            pw.println(formatter.format("%-60s %n","TOTAL PAYMENT"));
            formatter = new Formatter();
            pw.println(formatter.format("%-40s %-20s %-20s %-15s %14s", "CUSTOMER NAME", "IC NUMBER", "TYPE OF ROOM", "NUMBER OF DAYS", "TOTAL (RM)"));

            formatter = new Formatter();
            pw2.println(formatter.format("%-75s %n","FINAL PAYMENT"));
            formatter = new Formatter();
            pw2.println(formatter.format("%-40s %-20s %-15s %-15s %-15s", "CUSTOMER NAME", "IC NUMBER", "DEPOSIT", "TOTAL", "BALANCE"));
            while (line != null)
            {
                StringTokenizer st = new StringTokenizer(line, ";");
                name = st.nextToken();
                ic = st.nextToken();
                roomtype = st.nextToken();
                days = Integer.parseInt(st.nextToken());
                deposit = Double.parseDouble(st.nextToken());

                if (roomtype.equalsIgnoreCase("Superior")) {
                    priceperday = 450.0;
                } else if (roomtype.equalsIgnoreCase("Deluxe")) {
                    priceperday = 550.0;
                } else if (roomtype.equalsIgnoreCase("Premium")) {
                    priceperday = 750.0;
                }
                //Calculating the total Price and balance
                total_payment = priceperday * days;
                balance = total_payment - deposit;

                //Displaying the calculated total Price
                formatter = new Formatter();
                pw.println(formatter.format("%-40s %-20s %-20s %-15s %10s", name, ic, roomtype, days, total_payment));

                formatter = new Formatter();
                pw2.println(formatter.format("%-40s %-20s %-15s %-15s %-15s", name, ic, deposit, total_payment, balance));

            line = br.readLine();
        }
            pw.close();
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
