package com.jk.pustakalaya.f.country;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jk.pustakalaya.PustakalayaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PustakalayaApplication.class)
public class CountryRepositoryTest {
	Logger log = LoggerFactory.getLogger(CountryRepositoryTest.class);
	
	@Autowired
	private CountryRepository cr;
	
	@Test
	public void getCountries() {
		assertNotEquals(0, cr.getCountries().size());
	}
	
	@Test
	public void getCountryById() {
		Country c = cr.getCountry(1L);
		
		assertEquals("India", c.getName());
	}

}
