package me.ayonel.github.service;

import me.ayonel.github.dao.PullPredictRepository;
import me.ayonel.github.dao.PullRecRepository;
import me.ayonel.github.entity.PullRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
public class PullRecService {
    @Autowired
    private PullRecRepository pullRecRepository;

    public PullRec findByOrgAndNumber(String org, int number) {
        return pullRecRepository.findByOrgAndNumber(org, number);
    }

    public List<PullRec> findByOrgWithPage(String org, int page) {
        Pageable request = new PageRequest(page-1, PER_PAGE, Sort.Direction.DESC, "number");
        System.out.println(request.getSort());
        //查询指定分页的内容
        return  pullRecRepository.findByOrg(org, request).getContent();
    }

    public long getTotalNums(String org) {
        return pullRecRepository.countByOrg(org);
    }
}
