import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class HouseData {
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("#0.0");
        try {
            String Business_registration, property_name, house_type;
            double development_phase, costperunit;
            int total_house;

            FileReader fr = new FileReader("Property.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw1 = new FileWriter("Quantity.txt");
            FileWriter fw2 = new FileWriter("total.txt");
            PrintWriter pw1 = new PrintWriter(fw1);
            PrintWriter pw2 = new PrintWriter(fw2);

            String line = br.readLine();

            int SemiDQuantity = 0, BungalowQuantity = 0, TownHouseQuantity = 0, DoubleStoreyQuantity = 0, SingleStoreyQuantity = 0;

            double mudra = 0, salam = 0, creative = 0, azlan = 0, nick = 0;
            pw2.println("The total cost for each Property is : ");
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                st.nextToken();
                property_name = st.nextToken();
                house_type = st.nextToken();
                st.nextToken();
                total_house = Integer.parseInt(st.nextToken());
                costperunit = Double.parseDouble(st.nextToken());

                //get the house type
                if (house_type.equals("Semi D")) {
                    SemiDQuantity = SemiDQuantity + total_house;
                } else if (house_type.equals("Bungalow")) {
                    BungalowQuantity = BungalowQuantity + total_house;
                } else if (house_type.equals("Town House")) {
                    TownHouseQuantity = TownHouseQuantity + total_house;
                } else if (house_type.equals("Double Storey")) {
                    DoubleStoreyQuantity = DoubleStoreyQuantity + total_house;
                } else if (house_type.equals("Single Storey")) {
                    SingleStoreyQuantity = SingleStoreyQuantity + total_house;
                }


                if (property_name.equals("Mudra Sdn Bhd")) {
                    mudra = mudra + costperunit;
                } else if (property_name.equals("Salam Property")) {
                    salam = salam + costperunit;
                } else if (property_name.equals("Creative Partner")) {
                    creative = creative + costperunit;
                } else if (property_name.equals("Azlan Adik Beradik")) {
                    azlan = azlan + costperunit;
                } else if (property_name.equals("Nick & Rakan")) {
                    nick = nick + costperunit;
                }
                line = br.readLine();
            }

            //get the house type
            pw1.println("Semi D is " + SemiDQuantity +" houses");
            pw1.println("Bungalow is " + BungalowQuantity +" houses");
            pw1.println("Town House is " + TownHouseQuantity +" houses");
            pw1.println("Double Storey is " + DoubleStoreyQuantity +" houses");
            pw1.println("Single Storey is " + SingleStoreyQuantity +" houses");

            pw2.println("Mudra Sdn. Bhd : " + df.format(mudra));
            pw2.println("salam Property : " + df.format(salam));
            pw2.println("Creative Partner : " + df.format(creative));
            pw2.println("Azlan Adik Beradik : " + df.format(azlan));
            pw2.println("Nick & Rakan : " + df.format(nick));

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
            System.out.println("System ends here... Bubbye!!");
        }
    }
}