package me.ayonel.github.dao;

import me.ayonel.github.entity.PullRec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@Component
public interface PullRecRepository extends MongoRepository<PullRec, String> {
    /**
     * 根据org以及number查询
     * @param org
     * @param number
     * @return
     */
    @Query("{ 'org' : ?0, 'number' : ?1 }")
    PullRec findByOrgAndNumber(@Param("org") String org, @Param("number")int number);

    Page<PullRec> findByOrg(@Param("org")String org, Pageable pageable);

    Long countByOrg(@Param("org")String org);

}
