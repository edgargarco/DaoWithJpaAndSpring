package garco.DaoPatterSpringBootAndMySQL.data.persistence.service.impl;

import garco.DaoPatterSpringBootAndMySQL.data.persistence.dao.IFooDao;
import garco.DaoPatterSpringBootAndMySQL.data.persistence.model.Foo;
import garco.DaoPatterSpringBootAndMySQL.data.persistence.service.IFooService;
import garco.DaoPatterSpringBootAndMySQL.data.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FooService extends AbstractService<Foo> implements IFooService {
    @Autowired
    private IFooDao dao;

    public FooService() {
        super();
    }
    @Override
    protected PagingAndSortingRepository<Foo, Long> getDao() {
        return dao;
    }

    @Override
    public Foo retrieveByName(String name) {
        return dao.retrieveByName(name);
    }
}
