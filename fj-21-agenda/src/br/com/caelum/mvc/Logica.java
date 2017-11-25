package br.com.caelum.mvc;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface Logica {

	public String executa(final ServletRequest req, final ServletResponse res) throws Exception;
}
