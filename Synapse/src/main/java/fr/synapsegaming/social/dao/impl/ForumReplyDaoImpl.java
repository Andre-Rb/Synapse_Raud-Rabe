package fr.synapsegaming.social.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.social.entity.ForumReply;
import fr.synapsegaming.user.entity.User;

@Repository("ForumReplyDao")
public class ForumReplyDaoImpl extends AbstractDao<ForumReply, Long> implements
        ForumReplyDao {

	@Override
	public long getNbReplyByUser(User user) {
		Session session = this.getSession();
		try {
			Query query = session.createQuery("select count(*) from ForumReply f where author.id = :userId");
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
