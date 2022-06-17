import java.io.BufferedReader;
import java.io.*;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.StringTokenizer;

public class Property
{
    public static void main(String[] args) throws IOException
    {
        DecimalFormat priceformatter = new DecimalFormat("#0.00");
        try
        {
            FileInputStream fip = new FileInputStream("Property.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fip));
            FileWriter fw = new FileWriter("Quantity.txt");
            FileWriter fw2 = new FileWriter("total.txt");
            PrintWriter pw = new PrintWriter(fw);
            PrintWriter pw2 = new PrintWriter(fw2);
            String line = br.readLine();

            pw2.println("The total cost for each Property is :");

            int quantitySemiD = 0;
            int quantityBungalow = 0;
            int quantityTownHouse= 0;
            int quantityDoubleStorey = 0;
            int quantitySingleStorey = 0;
            int totalHouse = 0;

            double Mudra = 0;
            double Salam = 0;
            double Creative = 0;
            double Azlan = 0;
            double Nick= 0;


            while (line != null)
            {
                StringTokenizer st = new StringTokenizer(line, ",");
                st.nextToken();
                st.nextToken();
                String category = st.nextToken();
                st.nextToken();
                int totalOfHouse = Integer.parseInt(st.nextToken());
                st.nextToken();

                if(category.equalsIgnoreCase("Semi D"))
                {
                    quantitySemiD = quantitySemiD + totalOfHouse;
                }
                else if(category.equalsIgnoreCase("Bungalow"))
                {
                    quantityBungalow = quantityBungalow + totalOfHouse;
                }
                else if(category.equalsIgnoreCase("Town House"))
                {
                    quantityTownHouse = quantityTownHouse + totalOfHouse;
                }
                else if(category.equalsIgnoreCase("Double Storey"))
                {
                    quantityDoubleStorey = quantityDoubleStorey + totalOfHouse;
                }
                else if(category.equalsIgnoreCase("Single Storey"))
                {
                    quantitySingleStorey = quantitySingleStorey + totalOfHouse;
                }

                line = br.readLine();

            }

            pw.println("Semi D is " +quantitySemiD + " houses");
            pw.println("Bungalow is " + quantityBungalow+ " houses");
            pw.println("Semi D is " + quantityTownHouse + " houses");
            pw.println("Double Storey is " + quantityDoubleStorey + " houses");
            pw.println("Single Storey is " + quantitySingleStorey + " houses");

            fip.getChannel().position(0);
            br = new BufferedReader(new InputStreamReader(fip));
            line = br.readLine();

            while(line != null)
            {

                StringTokenizer st = new StringTokenizer(line, ",");
                st.nextToken();
                String company = st.nextToken();
                st.nextToken();
                st.nextToken();
                st.nextToken();
                double totalCost = Double.parseDouble(st.nextToken());

                if(company.equalsIgnoreCase("Mudra Sdn Bhd"))
                {
                    Mudra = Mudra + totalCost;
                }
                else if(company.equalsIgnoreCase("Salam Property"))
                {
                    Salam = Salam + totalCost;
                }
                else if(company.equalsIgnoreCase("Creative Partner"))
                {
                    Creative = Creative + totalCost;
                }
                else if(company.equalsIgnoreCase("Azlan Adik Beradik"))
                {
                    Azlan = Azlan + totalCost;
                }
                else if(company.equalsIgnoreCase("Nick & Rakan"))
                {
                    Nick = Nick + totalCost;
                }

                line = br.readLine();
            }

            pw2.println("Mudra Sdn Bhd" + " : "  + priceformatter.format(Mudra));
            pw2.println("Salam Property" + " : " + priceformatter.format(Salam));
            pw2.println("Creative Partner" + " : " + priceformatter.format(Creative));
            pw2.println("Azlan Adik Beradik" + " : " + priceformatter.format(Azlan));
            pw2.println("Nick & Rakan" + ":" + priceformatter.format(Nick));

            pw.close();
            pw2.close();
            br.close();
        } catch (EOFException ex) {
            System.out.println("End of file error");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Wrong input!!!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        finally
        {
            System.out.println("System end here! Bye...");
        }

    }

}