package com.javorek.tdd.howto;

import com.javorek.tdd.hownotto.HowNotToApplication;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HowNotToApplication.class)
class MathCalculationRestApiIntegrationTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	@SneakyThrows
	void shouldReturnHttp400WhenIncorrectInput() {
		var json = "{\"first\":-1,\"operation\":\"additamentum\",\"second\":-1}";
		this.mockMvc.perform(post("/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json)
				.characterEncoding("utf-8"))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andReturn();
	}
}
