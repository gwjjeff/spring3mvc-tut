package net.zhepu.web.theme;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ThemeResolver;

@Controller
public class ThemeChange {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ThemeResolver themeResolver;

	@RequestMapping("/changeTheme")
	public void changeTheme(String themeName, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("current theme is " + themeResolver.resolveThemeName(request));
		themeResolver.setThemeName(request, response, themeName);
		logger.info("current theme change to " + themeResolver.resolveThemeName(request));
		//return "redirect:helloworld";
	}
}
