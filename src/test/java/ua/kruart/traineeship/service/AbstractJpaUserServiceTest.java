package ua.kruart.traineeship.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kruart.traineeship.repository.JpaUtil;

/**Created by kruart on 21.08.2016.*/

abstract public class AbstractJpaUserServiceTest extends AbstractUserServiceTest {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JpaUtil jpaUtil;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        jpaUtil.clear2ndLevelHibernateCache();
    }
}
