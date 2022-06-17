
import java.io.*;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.StringTokenizer;

public class LabTest {

    public static void main(String[] args) throws IOException {
        Formatter formatter;
        DecimalFormat priceformatter = new DecimalFormat("#0.0");
        try {
            String Business_Registration,Property_Name,House_Type;
            double developement_phase,CostPerUnit;
            int total_House;

            BufferedReader br = new BufferedReader(new FileReader("Property.txt"));

            FileWriter fw = new FileWriter("Quantity.txt");
            FileWriter fw2 = new FileWriter("Total.txt");
            PrintWriter pw = new PrintWriter(fw);
            PrintWriter pw2 = new PrintWriter(fw2);
            String line = br.readLine();

            formatter = new Formatter();

            pw2.println("The Total Cost For Each Property is :");

            int quantitySemiD = 0;
            int quantityBungalow = 0;
            int quantityTownHouse = 0;
            int quantityDoubleStorey = 0;
            int quantitySingleStorey = 0;
            int quantityTotalHouse = 0;

            double Mudra = 0;
            double Salam = 0;
            double Creative = 0;
            double Azlan = 0;
            double Nick= 0;

            while (line!= null)
            {
                StringTokenizer st = new StringTokenizer(line, ",");
                st.nextToken();
                Property_Name= st.nextToken();
                House_Type = st.nextToken();
                st.nextToken();
                total_House = Integer.parseInt(st.nextToken());
                CostPerUnit = Double.parseDouble(st.nextToken());

                if(House_Type.equalsIgnoreCase("Semi D"))
                {
                    quantitySemiD = quantitySemiD + total_House;
                }
                else if(House_Type.equalsIgnoreCase("Bungalow"))
                {
                    quantityBungalow = quantityBungalow + total_House;
                }
                else if(House_Type.equalsIgnoreCase("Town House"))
                {
                    quantityTownHouse = quantityTownHouse + total_House;
                }
                else if(House_Type.equalsIgnoreCase("Double Storey"))
                {
                    quantityDoubleStorey = quantityDoubleStorey + total_House;
                }
                else if(House_Type.equalsIgnoreCase("Single Storey"))
                {
                    quantitySingleStorey = quantitySingleStorey + total_House;
                }

                if(Property_Name.equalsIgnoreCase("Mudra Sdn Bhd"))
                {
                    Mudra = Mudra + CostPerUnit;
                }
                else if(Property_Name.equalsIgnoreCase("Salam Property"))
                {
                    Salam = Salam + CostPerUnit;
                }
                else if(Property_Name.equalsIgnoreCase("Creative Partner"))
                {
                    Creative = Creative + CostPerUnit;
                }
                else if(Property_Name.equalsIgnoreCase("Azlan Adik Beradik"))
                {
                    Azlan = Azlan + CostPerUnit;
                }
                else if(Property_Name.equalsIgnoreCase("Nick & Rakan"))
                {
                    Nick = Nick + CostPerUnit;
                }
                line = br.readLine();
            }

            pw.println("Semi D is " +quantitySemiD + " houses");
            pw.println("Bungalow is " + quantityBungalow+ " houses");
            pw.println("Semi D is " + quantityTownHouse + " houses");
            pw.println("Double Storey is " + quantityDoubleStorey + " houses");
            pw.println("Single Storey is " + quantitySingleStorey + " houses");

            pw2.println("Mudra Sdn Bhd" + ":" + priceformatter.format(Mudra));
            pw2.println("Salam Property" + ":" + priceformatter.format(Salam));
            pw2.println("Creative Partner" + ":" + priceformatter.format(Creative));
            pw2.println("Azlan Adik Beradik" + ":" + priceformatter.format(Azlan));
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