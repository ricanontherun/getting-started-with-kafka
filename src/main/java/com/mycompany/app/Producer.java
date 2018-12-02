package com.mycompany.app;

import org.apache.kafka.clients.producer.*;
import com.mycompany.app.Base;

/**
 */
public class Producer extends Base
{
  public static void main( String[] args )
  {

    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(Producer.getProducerProps());

    try {
      // Send 200 messages to a Kafka broker.
      for (int i = 0; i < 200; i++) {
        producer.send(
          new ProducerRecord<String, String>("topic-0", Integer.toString(i), "My Message " + Integer.toString(i))
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Close the producer, blocks until all previously sent messages complete.
      // This is, obviously, extremely important to do.
      producer.close();
    }
  }
}
