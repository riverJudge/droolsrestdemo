package com.sinosoft.drools.droolsrestdemo.Controller;

import com.sinosoft.drools.droolsrestdemo.fact.Message;
import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @KSession("ksession")
    private KieSession kieSession;

    @KSession("ksessionStateless")
    private StatelessKieSession statelessKieSession;

    /**
     * 访问welcome.jsp页面
     *
     * @return
     */
    @RequestMapping("welcomeIndex")
    public ModelAndView welcomeIndex() {
        ModelAndView mv = new ModelAndView();

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();

        if(kieSession==null) {
            System.out.println("kieSession"  + "为空");
            kieSession = kContainer.newKieSession("ksession-rules");
        }else{
            System.out.println("kieSession"  + "不为空");
            kieSession = kContainer.newKieSession("ksession-rules");
        }
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");
//
//kieSession.destroy();



        mv.setViewName("welcome");
        mv.addObject("name", "张三"+ruleFiredCount);kieSession.dispose();

        return mv;
    }



    /**
     * 访问welcome.jsp页面
     *
     * @return
     */
    @RequestMapping("welcomeIndex2")
    public ModelAndView welcomeIndex2() {
        ModelAndView mv = new ModelAndView();


        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        statelessKieSession.execute(message);
//        int ruleFiredCount = kieSession.fireAllRules();
//        System.out.println("触发了" + ruleFiredCount + "条规则");
//
//kieSession.destroy();



        mv.setViewName("welcome");
        mv.addObject("name", "张三");

        return mv;
    }

}
