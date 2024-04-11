package com.ddd.activityservice;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class ActivityServiceApplicationTests {

	@Resource
	private KafkaTemplate<Object, Object> template;

	@Test
	void testKafka() {
		template.send("activity-event", "test msg");
	}

}
