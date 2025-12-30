package com.codegym.configemail.Controller;

import com.codegym.configemail.Entity.MailInbox;
import com.codegym.configemail.service.MailInboxService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailInboxController {
    private MailInboxService mailInboxService = new MailInboxService();

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        MailInbox currentConfig = mailInboxService.getConfigInfo();
        modelAndView.addObject("languages", currentConfig.getLanguages());
        modelAndView.addObject("pageSize", currentConfig.getPageSize());
        modelAndView.addObject("spamsFilter", currentConfig.isSpamsFilter());
        modelAndView.addObject("signature", currentConfig.getSignature());
        return modelAndView;
    }

    @GetMapping("/getSettingInfo")
    public ModelAndView getSettingInfo() {
        ModelAndView modelAndView = new ModelAndView("setting");
        modelAndView.addObject("mailInbox", mailInboxService.getConfigInfo());
        modelAndView.addObject("languagesArray", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSizeArray", new Integer[]{5, 10, 15, 25, 50, 100});
        return modelAndView;
    }

    @PostMapping("/setting")
    public String setting(@ModelAttribute("mailInbox") MailInbox mailInbox, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "setting";
        }
        mailInboxService.setConfigInfo(mailInbox);
        return "redirect:/index";
    }
}
