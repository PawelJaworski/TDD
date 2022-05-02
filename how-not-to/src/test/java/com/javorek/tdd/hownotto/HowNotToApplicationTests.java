package com.javorek.tdd.hownotto;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class HowNotToApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	@SneakyThrows
	void calculationOK() {
		var json = "{\"first\":1,\"operation\":\"additamentum\",\"second\":2}";
		this.mockMvc.perform(post("/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json)
				.characterEncoding("utf-8"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("3"))
				.andReturn();
	}

	@Test
	@SneakyThrows
	void validate() {
		var json = "{\"first\":-1,\"operation\":\"additamentum\",\"second\":0}";
		this.mockMvc.perform(post("/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json)
						.characterEncoding("utf-8"))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andReturn();
	}

//	@ExceptionHandler(ValidationException.class)
//	public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
//
//		return ResponseEntity.badRequest().build();
//	}
}
