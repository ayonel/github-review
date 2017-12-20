package me.ayonel.github.service;

import me.ayonel.github.dao.PullPredictRepository;
import me.ayonel.github.entity.PullPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static me.ayonel.github.config.Constants.PER_PAGE;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@Service
public class PullPredictService {
    @Autowired
    private PullPredictRepository pullPredictRepository;

    public PullPredict findByOrgAndNumber(String org, int number) {
        return pullPredictRepository.findByOrgAndNumber(org, number);
    }

    public List<PullPredict> findByOrgWithPage(String org, int page) {
        Pageable request = new PageRequest(page-1, PER_PAGE, Sort.Direction.DESC, "number");
        //查询指定分页的内容
         return  pullPredictRepository.findByOrg(org, request).getContent();
    }

    public long getTotalNums(String org) {
        return pullPredictRepository.countByOrg(org);
    }


}
