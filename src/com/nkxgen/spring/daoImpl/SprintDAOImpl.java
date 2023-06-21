// package com.nkxgen.spring.daoImpl;
//
// import java.util.List;
//
// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
// import javax.persistence.Query;
//
// import org.springframework.stereotype.Component;
// import org.springframework.transaction.annotation.Transactional;
//
// import com.nkxgen.spring.orm.dao.SprintDAO;
// import com.nkxgen.spring.orm.model.Sprint;
// import com.nkxgen.spring.orm.model.SprintDto;
//
// @Component
// public class SprintDAOImpl implements SprintDAO {
// @PersistenceContext
// private EntityManager entityManager;
//
// @Override
// public Sprint getSprintById(int sprintId) {
// return entityManager.find(Sprint.class, sprintId);
// }
//
// @Override
// public List<Sprint> getAllSprints() {
// String jpql = "SELECT s FROM Sprint s";
// Query query = entityManager.createQuery(jpql);
// return query.getResultList();
// }
//
// @Override
// @Transactional
// public void createSprint(Sprint sprint) {
// entityManager.persist(sprint);
// }
//
// @Override
// @Transactional
// public void updateSprint(Sprint sprint) {
// entityManager.merge(sprint);
// }
//
// @Override
// @Transactional
// public void deleteSprint(int sprintId) {
// Sprint sprint = entityManager.find(Sprint.class, sprintId);
// if (sprint != null) {
// entityManager.remove(sprint);
// }
// }
//
// @Override
// public List<SprintDto> getSprintbyprojectId(Integer projectId) {
// // TODO Auto-generated method stub
// return null;
// }
// }
