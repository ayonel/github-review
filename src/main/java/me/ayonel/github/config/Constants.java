package me.ayonel.github.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: ayonel
 * Date: 2017/12/10
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
public interface Constants {
    // 每页返回条数
    static final int PER_PAGE = 15;

    static final List<String> PREDICT_ORGS = new ArrayList<>(
            Arrays.asList(
                    "Baystation12",
                    "bitcoin",
                    "twbs",
                    "adobe",
                    "cakephp",
                    "cdnjs",
                    "cocos2d",
                    "owncloud",
                    "dlang",
                    "caskroom",
                    "ipython",
                    "joomla",
                    "Katello",
                    "rapid7",
                    "openmicroscopy",
                    "hrydgard",
                    "puppetlabs",
                    "rails",
                    "scala",
                    "symfony",
                    "sympy",
                    "tgstation",
                    "zendframework"
            )
    );

    static final List<String> REC_ORGS = new ArrayList<>(
        Arrays.asList(
                "adobe",
                "angular",
                "Baystation12",
                "cakephp",
                "caskroom",
                "cdnjs",
                "cocos2d",
                "dimagi",
                "dlang",
                "ipython",
                "joomla",
                "Katello",
                "nodejs",
                "owncloud",
                "puppetlabs",
                "rails",
                "rapid7",
                "scala",
                "symfony",
                "sympy",
                "tgstation",
                "twbs",
                "wet-boew",
                "Wikia",
                "zendframework"
        )
    );
    static final String DEFAULT_ORG = "rails";
}
