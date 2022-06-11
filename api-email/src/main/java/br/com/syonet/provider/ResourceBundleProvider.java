package br.com.syonet.provider;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;

public class ResourceBundleProvider {

	@Produces
	public ResourceBundle get() {
		return ResourceBundle.getBundle("Messages", Locale.forLanguageTag("pt-BR"));
	}
}
