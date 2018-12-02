package com.mycompany.app;

import java.util.Properties;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;

abstract public class Base {
  protected static final String TOPIC = "replicated_topic";

  static public Properties getConsumerProps() {
    Properties props = new Properties();

    props.put("bootstrap.servers", "localhost:9090,localhost:9091");
    props.put("key.deserializer", StringDeserializer.class.getName());
    props.put("value.deserializer", StringDeserializer.class.getName());
    props.put("group.id", "test");

    return props;
  }

  static public Properties getProducerProps() {
    Properties props = new Properties();

    props.put("bootstrap.servers", "localhost:9090,localhost:9091");
    props.put("key.serializer", StringSerializer.class.getName());
    props.put("value.serializer", StringSerializer.class.getName());

    return props;
  }
}
