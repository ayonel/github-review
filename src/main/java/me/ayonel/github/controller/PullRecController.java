package me.ayonel.github.controller;

import me.ayonel.github.dao.PullRecRepository;
import me.ayonel.github.entity.PullPredict;
import me.ayonel.github.entity.PullRec;
import me.ayonel.github.service.PullRecService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static me.ayonel.github.config.Constants.REC_ORGS;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@Controller
@RequestMapping("/rec")
public class PullRecController {

    private Logger logger = Logger.getLogger(PullRecController.class);

    @Autowired
    private PullRecService pullRecService;


    @RequestMapping("")
    public ModelAndView index(){
        return getByOrgWithPage("rails", 1);
    }

    @RequestMapping("/{org}/page/{page}}")
    public ModelAndView getByOrgWithPage(@PathVariable("org") String org, @PathVariable("page") int page) {

        logger.info("org:"+org);
        logger.info("page:"+page);
        List<PullRec> pullList = pullRecService.findByOrgWithPage(org, page);
        logger.info(pullList.size());
        for (PullRec  pullRec: pullList){
            System.out.println(pullRec);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("rec_index");
        mv.addObject("org", org);
        mv.addObject("pullList", pullList);
        mv.addObject("orgList", REC_ORGS);

        return mv;
    }


    @RequestMapping("/{org}/{number}")
    public ModelAndView getByOrgAndNumber(@PathVariable("org") String org, @PathVariable("number") int  number) {
        PullRec pullRec = pullRecService.findByOrgAndNumber(org, number);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("rec_info");
        mv.addObject("pullrec", pullRec);
        mv.addObject("orgList", REC_ORGS);
        return mv;
    }


}
