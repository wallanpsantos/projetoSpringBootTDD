package com.br.projetoSpringBootTDD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetoSpringBootTddApplicationTests {

	@Test
	void contextLoads() {
		// cenario
		Integer x = 10, y = 20;

		// execução
		Integer res = x + y;

		// validação
		Assertions.assertThat(res).isGreaterThan(5);
	}

}
