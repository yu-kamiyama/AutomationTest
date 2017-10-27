package jp.co.atp.echo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("echo")
public class EchoController {

	@ModelAttribute
	public EchoForm setUpEchoForm() {
		// このアノテーションがついたメソッドの返り値は、自動でModelに追加される。
		EchoForm form = new EchoForm();
		return form;
	}

	@RequestMapping
	public String index(Model model) {
		// メソッドに付加した @RequestMapping アノテーションの value 属性にマッピング

		// View名で”echo/index”を返すので、ViewResolverにより、
		//“WEB-INF/views/echo/index.jsp”がレンダリングされる。
		return "echo/index";
	}

	@RequestMapping("hello") //
	public String hello(EchoForm form, Model model) {
		// メソッドに付加した @RequestMapping アノテーションに”hello”を指定しているので、
		// この場合、”<contextPath>/echo/hello”にアクセスすると hello メソッドが呼ばれる。
		// 引数に、EchoFormには(1)によりModelに追加されたEchoFormオブジェクトが渡される。

		// フォームで入力された name を、Viewにそのまま渡す。
		model.addAttribute("name", form.getName()); // (6)
		return "echo/hello";
	}
}