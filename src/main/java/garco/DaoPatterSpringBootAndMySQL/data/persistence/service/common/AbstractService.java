package garco.DaoPatterSpringBootAndMySQL.data.persistence.service.common;

import garco.DaoPatterSpringBootAndMySQL.persistence.IOperations;
import org.assertj.core.util.Lists;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    @Override
    @Transactional(readOnly = true)
    public T findOne(long id) {
        return getDao().findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public T create(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);

    }
    protected abstract PagingAndSortingRepository<T, Long> getDao();
}
