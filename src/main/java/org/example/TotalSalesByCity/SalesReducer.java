package org.example.TotalSalesByCity;


import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;


import java.io.IOException;

public class SalesReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    public void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {
        float totalSales = 0.0f;
        for (FloatWritable value : values) {
            totalSales += value.get();
        }
        context.write(key, new FloatWritable(totalSales));
    }
}
