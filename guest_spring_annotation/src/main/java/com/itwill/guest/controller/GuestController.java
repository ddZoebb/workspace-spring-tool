package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/*
<<요청 url(command)>> 
	 /guest_main				---forward--->/WEB-INF/views/guest_main.jsp 
	 /guest_list				---forward--->/WEB-INF/views/guest_list.jsp 
	 /guest_view				---forward--->/WEB-INF/views/guest_view.jsp 
	 /guest_write_form			---forward--->/WEB-INF/views/guest_write_form.jsp 
	 /guest_write_actio			---forward--->/WEB-INF/views/guest_write_action.jsp 
	 /guest_modify_form			---forward--->/WEB-INF/views/guest_modify_form.jsp 
	 /guest_modify_action		---forward--->/WEB-INF/views/guest_modify_action.jsp 
	 /guest_remove_action		---forward--->/WEB-INF/views/guest_remove_action.jsp 
*/
/*
 * @Controller
   - Controller class에사용
   - Controller객체를 생성(기본생성자)하고 Handler객체에 등록한다.
   - Controller객체의 메쏘드와 @RequestMapping에 기술된 URL과의 매핑이설정
   	    @RequestMapping(value="/guest_main")
			public String guest_main() {
				return "forward:/WEB-INF/views/guest_main.jsp";
	     }
 */
@Controller
public class GuestController {
	/*
	@Autowired 
	 GuestService 타입의 객체를 BeanFactory에서 찾아서 주입한다.
	 */
	@Autowired
	private GuestService guestService;

	@RequestMapping(value = "/guest_main")
	public String guest_main() {
		/*
		 * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		 * 		<property name="prefix" value="/WEB-INF/views/"/> 
		 *  	<property name="suffix" value=".jsp"/> 
		 * </bean>
		 * 
		 * << Controller반환 String >> 
		 * 		1.forward:/WEB-INF/views/guest_main.jsp ==>prefix,suffix설정적용안됨 
		 * 		2.guest_main ==> prefix,suffix설정적용됨
		 * 		3.redirect:guest_main ==> prefix,suffix설정적용안됨
		 */
		return "forward:/WEB-INF/views/guest_main.jsp";
	}

	@RequestMapping(value = "/guest_list")
	public String guest_list(Model model/*,HttpServletRequest request*/) throws Exception {
		String forwardPath = "";

		List<Guest> guestList = guestService.selectAll();
		model.addAttribute("guestList", guestList);
		forwardPath = "forward:/WEB-INF/views/guest_list.jsp";

		return forwardPath;
	}

	/*
	 * parameter 중에 guest_no가존재하지않으면실행
	 */
	@RequestMapping(value = "/guest_view", params = "!guest_no")
	public String guest_view() {
		return "redirect:guest_main";
	}

	/*
	 * parameter 중에 guest_no가존재하면실행
	 */
	@RequestMapping(value = "/guest_view", params = "guest_no")
	public String guest_view(@RequestParam int guest_no, Model model) throws Exception {

		Guest guest = guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		return "forward:/WEB-INF/views/guest_view.jsp";

	}

	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}

	@RequestMapping(value = "/guest_write_action", method = RequestMethod.GET)
	public String guest_write_action_get() {
		return "redirect:guest_main";
	}

	@RequestMapping(value = "/guest_write_action", method = RequestMethod.POST)
	public String guest_write_action_post(@ModelAttribute Guest guest) throws Exception {

		int insertRowCount = guestService.insertGuest(guest);
		return "redirect:guest_list";

	}

	@GetMapping(value = "/guest_remove_action")
	public String guest_remove_action_get() {
		return "redirect:guest_main";
	}

	@PostMapping(value = "/guest_remove_action")
	public String guest_remove_action_post(@RequestParam int guest_no) throws Exception {
		int removeRowCount = guestService.deleteGuest(guest_no);
		return "redirect:guest_list";

	}

	@RequestMapping(value = "/guest_modify_form")
	public String guest_modify_form(@RequestParam int guest_no, Model model) throws Exception {

		Guest guest = guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		return "forward:/WEB-INF/views/guest_modify_form.jsp";

	}

	@GetMapping(value = "/guest_modify_action")
	public String guest_modify_action_get() {
		return "redirect:guest_modify_form";
	}

	@PostMapping(value = "/guest_modify_action")
	public String guest_modify_action_post(@ModelAttribute Guest guest) throws Exception {

		int updateUpdateCount = guestService.updateGuest(guest);
		return "redirect:guest_view?guest_no=" + guest.getGuest_no();

	}
	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "forward:/WEB-INF/views/guest_error.jsp";
	}
}