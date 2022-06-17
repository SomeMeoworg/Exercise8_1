import java.io.*;
import java.util.Formatter;
import java.util.StringTokenizer;

public class TestData {
    public static void main(String[] args) throws IOException {
        Formatter formatter;
        try {
            String book_code, book_title, author_name, publisher_name, book_category;
            int year_published, book_quantity,book_total = 0;

            FileReader fr = new FileReader("testdata.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("totalBook.txt");
            PrintWriter pw = new PrintWriter(fw);
            FileWriter fw2 = new FileWriter("BookYear.txt");
            PrintWriter pw2 = new PrintWriter(fw2);

            String line = br.readLine();
            formatter = new Formatter();

            pw.println(formatter.format("%-30s %-20s %n", "CATEGORY", "TOTAL"));

            int mathbookquantity = 0;
            int economybookquantity = 0;
            int sciencebookquantity = 0;
            int total = 0;

            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                book_code = st.nextToken(); //Skip Book Code
                book_title = st.nextToken();
                author_name = st.nextToken();
                year_published = Integer.parseInt(st.nextToken());
                publisher_name = st.nextToken();
                book_category = st.nextToken(); //ni je tak skip
                book_quantity = Integer.parseInt(st.nextToken());

                if (book_category.equals("Mathematic")) {
                    mathbookquantity = mathbookquantity + book_quantity;
                } else if (book_category.equals("Economy")) {
                    economybookquantity = economybookquantity + book_quantity;
                } else if (book_category.equals("Science")) {
                    sciencebookquantity = sciencebookquantity + book_quantity;
                }
                book_total = mathbookquantity + economybookquantity + sciencebookquantity;
                if (year_published == 2000 && publisher_name.equalsIgnoreCase("McGraw Hill")) {
                    pw2.println(publisher_name + " Book in year " + year_published);
                    pw2.println("\n" + "1.Name: " + book_title);
                    pw2.println("  Author: " + author_name);
                    pw2.println("  Total available: " + book_quantity);
                }
                line = br.readLine();


            }
            formatter = new Formatter();
            pw.println(formatter.format("%-30s %-20s", "Mathematic", mathbookquantity));
            formatter = new Formatter();
            pw.println(formatter.format("%-30s %-20s", "Economy", economybookquantity));
            formatter = new Formatter();
            pw.println(formatter.format("%-30s %-20s", "Science", sciencebookquantity));

            pw.println("Total books available = "+ book_total);

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
