package jp.mufg.it.concurrent.lambda.sales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

public class SalesListHolder {
    private static List<Sales> salesList =
            new CopyOnWriteArrayList<Sales>();

    public static List<Sales> getSalesList() {
        return salesList;
    }

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("SALES.csv");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                Sales salesDetail = createsalesLineFromLine(line);
                salesList.add(salesDetail);
            }
        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch(IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }
    }

    private static Sales createsalesLineFromLine(String line) {
        StringTokenizer st = new StringTokenizer(line, ",");
        Integer salesId = Integer.parseInt(st.nextToken());
        String productId = st.nextToken();
        Integer salesCount = Integer.parseInt(st.nextToken());
        Sales salesLine = new Sales(salesId, productId, salesCount);
        return salesLine;
    }
}
