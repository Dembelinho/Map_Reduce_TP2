package org.example.TotalProductSalesByCity;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ProductSalesMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split(" ");
        String date = fields[0];
        String city = fields[1];
        String product = fields[2];
        float price = Float.parseFloat(fields[3]);

        // Extrayez l'année de la date (par exemple, 2023) en fonction du format de date réel.
        String year = date.split("-")[0];

        // Émettez la clé sous la forme "Ville-Année-Produit" et la valeur est le prix.
        context.write(new Text(city + "-" + year + "-" + product), new FloatWritable(price));
    }
}
