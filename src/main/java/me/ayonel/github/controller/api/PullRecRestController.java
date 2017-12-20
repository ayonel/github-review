package me.ayonel.github.controller.api;

import me.ayonel.github.entity.PullRec;
import me.ayonel.github.service.PullRecService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static me.ayonel.github.config.Constants.DEFAULT_ORG;
import static me.ayonel.github.config.Constants.REC_ORGS;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@RestController
@RequestMapping("/api/rec")
public class PullRecRestController {

    private Logger logger = Logger.getLogger(PullRecRestController.class);


    @Autowired
    private PullRecService pullRecService;


    @RequestMapping("")
    public List<PullRec> index(){
        return getByOrgWithPage(DEFAULT_ORG, 1);
    }

    @RequestMapping("/{org}/page/{page}")
    public List<PullRec> getByOrgWithPage(@PathVariable("org") String org, @PathVariable("page") int page) {
        logger.info("org:"+org);
        logger.info("page:"+page);
        List<PullRec> pullList = pullRecService.findByOrgWithPage(org, page);
        logger.info(pullList.size());
        for (PullRec  pullRec: pullList){
            System.out.println(pullRec);
        }
        return pullList;
    }


    @RequestMapping("/{org}/{number}")
    public PullRec getByOrgAndNumber(@PathVariable("org") String org, @PathVariable("number") int  number) {
        return pullRecService.findByOrgAndNumber(org, number);
    }

    @RequestMapping("/orgs")
    public List<String> getOrgList(){
        return REC_ORGS;
    }

    @RequestMapping("/{org}/total_nums")
    public long getTotalPages(@PathVariable("org") String org) {
        return pullRecService.getTotalNums(org);
    }
}
