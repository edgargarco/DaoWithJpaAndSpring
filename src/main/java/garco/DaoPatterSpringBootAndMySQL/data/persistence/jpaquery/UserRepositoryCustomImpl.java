package garco.DaoPatterSpringBootAndMySQL.data.persistence.jpaquery;

import garco.DaoPatterSpringBootAndMySQL.data.persistence.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.criteria.Predicate;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findUserByEmails(Set<String> emails) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        Path<String> emailPath = userRoot.get("email");
        List<Predicate> predicates = new ArrayList<>();
        for (String email : emails){
            predicates.add(criteriaBuilder.like(emailPath,email));
        }
        userCriteriaQuery.select(userRoot).where(criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])));
        return entityManager.createQuery(userCriteriaQuery).getResultList();
    }

    @Override
    public List<User> findAllUsersByPredicates(Collection<java.util.function.Predicate<User>> predicates) {
        List<User> allUsers = entityManager.createQuery("select u from User u", User.class).getResultList();
        Stream<User> allUsersStream = allUsers.stream();
        for (java.util.function.Predicate<User> predicate : predicates) {
            allUsersStream = allUsersStream.filter(predicate);
        }

        return allUsersStream.collect(Collectors.toList());
    }
}
