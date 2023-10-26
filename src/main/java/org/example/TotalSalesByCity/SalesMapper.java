package org.example.TotalSalesByCity;


import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class SalesMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split(" ");
        String city = fields[1];
        float amount = Float.parseFloat(fields[3]);
        context.write(new Text(city), new FloatWritable(amount));
    }
}
