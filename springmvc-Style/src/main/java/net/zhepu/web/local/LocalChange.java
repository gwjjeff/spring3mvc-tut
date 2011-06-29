package net.zhepu.web.local;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class LocalChange {

	@Autowired
	private LocaleResolver localeResolver;

	@RequestMapping("/changeLocale")
	public String changeLocal(String locale, HttpServletRequest request, HttpServletResponse response) {
		Locale l = new Locale(locale);
		localeResolver.setLocale(request, response, l);
		return "redirect:helloworld";
	}
}
