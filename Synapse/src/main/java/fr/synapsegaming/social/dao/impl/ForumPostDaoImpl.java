package fr.synapsegaming.social.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumPostDao;
import fr.synapsegaming.social.entity.ForumPost;
import fr.synapsegaming.user.entity.User;

@Repository("ForumPostDao")
public class ForumPostDaoImpl extends AbstractDao<ForumPost, Long> implements
        ForumPostDao {

	@Override
	public long getNbPostByUser(User user) {
		Session session = this.getSession();
		try {
			Query query = session.createQuery("select count(*) from ForumPost f where author.id = :userId");
			query.setParameter("userId", user.getId());
			return (long) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		} finally {
            session.close();
        }
	}

}
