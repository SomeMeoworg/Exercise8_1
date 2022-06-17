import java.io.*;
import java.util.Formatter;
import java.util.StringTokenizer;

public class KuihRaya {
    public static void main(String[] args) throws IOException {
        Formatter formatter;
        try {

            FileInputStream fip = new FileInputStream("kuihraya.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fip));

            FileWriter fw1 = new FileWriter("discount.txt");
            PrintWriter pw1 = new PrintWriter(fw1);
            FileWriter fw2 = new FileWriter("nodiscount.txt");
            PrintWriter pw2 = new PrintWriter(fw2);

            String line = br.readLine();

            pw1.println("List of cookies and the customers who get the discount rate");
            formatter = new Formatter();
            pw1.println(formatter.format("%-20s %-20s %-30s %-15s", "Cookie's Name", "Total Price", "Price after discount", "Customer Name"));
            pw1.println("------------------------------------------------------------------------------------------------------------------");

            formatter = new Formatter();
            pw2.println(formatter.format("%-20s %-15s", "Customer Name","Total Price"));
            pw2.println("-------------------------------------------------------------");
            while(line != null){
                StringTokenizer st = new StringTokenizer(line, ";");
                String cookies_name = st.nextToken();
                double price = Double.parseDouble(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                double totalprice = price * quantity;
                double total = 0;

                boolean discountstate = false;
                double discount = 0;

                if(totalprice <50){
                    discount = 0;
                    discountstate = false;
                }else if ((totalprice >50)&& (totalprice <=200)){
                    discount = 0.10;
                    discountstate = true;
                }else if ((totalprice >200)&& (totalprice <=300)){
                    discount = 0.20;
                    discountstate = true;
                }else if(totalprice>300){
                    discount = 0.30;
                    discountstate = true;
                }

                if(discountstate == true){
                    total = totalprice - (totalprice*discount);
                    formatter = new Formatter();
                    pw1.println(formatter.format("%-20s %-20s %-30s %-15s", cookies_name, price, total, name));
                }else {
                    formatter = new Formatter();
                    pw2.println(formatter.format("%-20s %-15s", name, totalprice));
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
