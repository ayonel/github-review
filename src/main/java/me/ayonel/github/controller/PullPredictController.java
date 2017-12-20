package me.ayonel.github.controller;

import me.ayonel.github.entity.PullPredict;
import me.ayonel.github.service.PullPredictService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static me.ayonel.github.config.Constants.DEFAULT_ORG;
import static me.ayonel.github.config.Constants.PREDICT_ORGS;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@Controller
@RequestMapping("/predict")
public class PullPredictController {
    private Logger logger = Logger.getLogger(PullPredictController.class);

    @Autowired
    private PullPredictService pullPredictService;

    @RequestMapping("")
    public ModelAndView index(){
        return getByOrgWithPage(DEFAULT_ORG, 1);
    }

    @RequestMapping("/{org}/page/{page}")
    public ModelAndView getByOrgWithPage(@PathVariable("org") String org, @PathVariable("page") int page) {

        logger.info("org:"+org);
        logger.info("page:"+page);
        List<PullPredict> pullList = pullPredictService.findByOrgWithPage(org, page);
        logger.info(pullList.size());
        for (PullPredict  pullPredict: pullList){
            System.out.println(pullPredict);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("predict_index");
        mv.addObject("org", org);
        mv.addObject("pullList", pullList);
        mv.addObject("orgList", PREDICT_ORGS);
        return mv;
    }

    @RequestMapping("/{org}/{number}")
    public ModelAndView getByOrgAndNumber(@PathVariable("org") String org, @PathVariable("number") int  number) {
        PullPredict pullPredict = pullPredictService.findByOrgAndNumber(org, number);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("predict_info");
        mv.addObject("pullpredict", pullPredict);
        mv.addObject("orgList", PREDICT_ORGS);
        return mv;
    }


}
