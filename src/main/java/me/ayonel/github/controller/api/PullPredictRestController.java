package me.ayonel.github.controller.api;

import me.ayonel.github.entity.PullPredict;
import me.ayonel.github.service.PullPredictService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static me.ayonel.github.config.Constants.PREDICT_ORGS;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@RestController
@RequestMapping("/api/predict")
public class PullPredictRestController {
    private Logger logger = Logger.getLogger(PullPredictRestController.class);

    @Autowired
    private PullPredictService pullPredictService;

    @RequestMapping("")
    public List<PullPredict> index(){
        return getByOrgWithPage("rails", 1);
    }

    @RequestMapping("/{org}/page/{page}")
    public List<PullPredict> getByOrgWithPage(@PathVariable("org") String org, @PathVariable("page") int page) {

        logger.info("org:"+org);
        logger.info("page:"+page);
        List<PullPredict> pullList = pullPredictService.findByOrgWithPage(org, page);
        logger.info(pullList.size());
        for (PullPredict  pullPredict: pullList){
            System.out.println(pullPredict);
        }
        return pullList;
    }


    @RequestMapping("/{org}/{number}")
    public PullPredict getByOrgAndNumber(@PathVariable("org") String org, @PathVariable("number") int  number) {
        return  pullPredictService.findByOrgAndNumber(org, number);
    }

    @RequestMapping("/orgs")
    public List<String> getOrgList(){
        return PREDICT_ORGS;
    }

    @RequestMapping("/{org}/total_nums")
    public long getTotalPages(@PathVariable("org") String org) {
        return pullPredictService.getTotalNums(org);
    }

}
