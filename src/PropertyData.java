import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class PropertyData {
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("#0.0");
        try {
            String Business_registration, Property_name, House_Type;
            double development_phase, costperunit;
            int total_house;

            BufferedReader br = new BufferedReader(new FileReader("Property.txt"));

            FileWriter fw1 = new FileWriter("Quantity.txt");
            PrintWriter pw1 = new PrintWriter(fw1);
            FileWriter fw2 = new FileWriter("total.txt");
            PrintWriter pw2 = new PrintWriter(fw2);

            String line = br.readLine();
            //Looping to get Quantity of the houses
        int SemiD_Quantity = 0, Bungalow_Quantity = 0,TownHouse_Quantity = 0, DoubleStorey_Quantity = 0, SingleStorey_Quantity = 0;
            //Looping to get the total cost of the houses
            double mudra = 0, salam = 0, creative = 0, azlan = 0, nick = 0;
            pw2.println("The total cost for each Property is : ");
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                st.nextToken(); //Skip Business Registration
                Property_name = st.nextToken();
                House_Type = st.nextToken();
                st.nextToken(); //Skip Development Phase
                total_house = Integer.parseInt(st.nextToken());
                costperunit = Double.parseDouble(st.nextToken());

                //IF else to differentiate and detect the house type, and calculate the quantity of said house type.
                if (House_Type.equals("Semi D")) {
                    SemiD_Quantity = SemiD_Quantity + total_house;
                } else if (House_Type.equals("Bungalow")) {
                    Bungalow_Quantity = Bungalow_Quantity + total_house;
                } else if (House_Type.equals("Town House")) {
                    TownHouse_Quantity = TownHouse_Quantity + total_house;
                } else if (House_Type.equals("Double Storey")) {
                    DoubleStorey_Quantity = DoubleStorey_Quantity + total_house;
                } else if (House_Type.equals("Single Storey")) {
                    SingleStorey_Quantity = SingleStorey_Quantity + total_house;
                }

                //if else to detect different property name and calculate the total cost for the property type
                if (Property_name.equals("Mudra Sdn Bhd")) {
                    mudra = mudra + costperunit;
                } else if (Property_name.equals("Salam Property")) {
                    salam = salam + costperunit;
                } else if (Property_name.equals("Creative Partner")) {
                    creative = creative + costperunit;
                } else if (Property_name.equals("Azlan Adik Beradik")) {
                    azlan = azlan + costperunit;
                } else if (Property_name.equals("Nick & Rakan")) {
                    nick = nick + costperunit;
                }
                line = br.readLine();
            }
            //Displaying the variables for Quantity.txt
            pw1.println("Semi D is " + SemiD_Quantity +" houses");
            pw1.println("Bungalow is " + Bungalow_Quantity +" houses");
            pw1.println("Town House is " + TownHouse_Quantity +" houses");
            pw1.println("Double Storey is " + DoubleStorey_Quantity +" houses");
            pw1.println("Single Storey is " + SingleStorey_Quantity +" houses");
            //Displaying the variables for total.txt
            pw2.println("Mudra Sdn. Bhd : " + df.format(mudra));
            pw2.println("salam Property : " + df.format(salam));
            pw2.println("Creative Partner : " + df.format(creative));
            pw2.println("Azlan Adik Beradik : " + df.format(azlan));
            pw2.println("Nick & Rakan : " + df.format(nick));

            pw1.close();
            pw2.close();
            br.close();
            //Error handling for possible file errors
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
