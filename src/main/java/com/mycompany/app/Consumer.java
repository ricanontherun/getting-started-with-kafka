package com.mycompany.app;

import com.mycompany.app.Base;
import org.apache.kafka.clients.consumer.*;
import java.util.ArrayList;

public class Consumer extends Base {
  public static void main(String[] args) {
    ArrayList<String> topics = new ArrayList<String>() {{
      add("topic-0");
      add("topic-1");
    }};

    KafkaConsumer consumer = new KafkaConsumer(Consumer.getConsumerProps());

    consumer.subscribe(topics);

    try {
      while (true) {
        // Poll for batches of messages, 100ms poll time.
        ConsumerRecords<String, String> records = consumer.poll(100);

        if (records.count() > 0) {
          System.out.println(records.count());
        }
      }
    } catch (Exception e) {

    } finally {
      consumer.close();
    }
  }
}
