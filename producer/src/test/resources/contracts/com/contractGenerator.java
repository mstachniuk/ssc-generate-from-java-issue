package com;

import java.util.function.Supplier;
import org.springframework.cloud.contract.spec.Contract;

public class contractGenerator implements Supplier<Contract>  {
	@Override
	public Contract get() {
		System.out.println("AAAAAAAA java");
		return Contract.make(c -> {
			c.name("Gen from java");
			c.request(r -> {
				r.url("/aaa");
				r.method("GET");
			});
			c.response(r -> {
				r.status(200);
			});
		});
	}
}
