package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class JpaTddExceptionsApplicationTests {
	
	@Autowired
	private TestRestTemplate rt;
	
//	private Logger logger = Logger.getLogger(JpaTddExceptionsApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	@Test
	public void post(){
		Stock s = new Stock("KO", new Double(42.5f));
		Stock savedStock = rt.postForObject("/stock", s, Stock.class);
		assertThat(savedStock).isNotNull();
	}
	
	@Test
	public void get(){
		Stock s = rt.getForObject("/stock?ticker=KO", Stock.class);
		assertThat(s).isNotNull();
	}
}
