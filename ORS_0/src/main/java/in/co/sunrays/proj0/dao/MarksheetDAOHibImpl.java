package in.co.sunrays.proj0.dao;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
// TODO: Auto-generated Javadoc
/**
 * The Class MarksheetDAOHibImpl.
 */
@Repository
public class MarksheetDAOHibImpl implements MarksheetDAOInt{

	/** The sessionfactory. */
	@Autowired
	private	SessionFactory sessionfactory = null;
	
	/** The student. */
	@Autowired
	private StudentDAOInt student=null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(MarksheetDAOHibImpl.class);
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(MarksheetDTO dto) {
		
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhh");
		StudentDTO studentdto = student.findByPK(dto.getStudentId());
		System.out.println("student name---> "+studentdto.getFirstName()+" "+studentdto.getLastName());
		dto.setName(studentdto.getFirstName()+" "+studentdto.getLastName());
		
		log.debug("Marksheet Dao Add Started");
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("Marksheet Dao Add End");
		return pk;
	}

	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(MarksheetDTO dto) {
		StudentDTO studentdto = student.findByPK(dto.getStudentId());
		System.out.println("student name---> "+studentdto.getFirstName()+" "+studentdto.getLastName());
		dto.setName(studentdto.getFirstName()+" "+studentdto.getLastName());
		
		log.debug("Marksheet Dao Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("Marksheet Dao Update End");
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id) {
		log.debug("Marksheet Dao Delete Started");
		MarksheetDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("Marksheet Dao Delete End");
	}

	/**
	 * Find by roll number.
	 *
	 * @param roleNumber the role number
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findByRollNumber(String roleNumber) {
		log.debug("Marksheet DAO findByRollNumber Started");
		MarksheetDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(MarksheetDTO.class).add(Restrictions.eq("rollNo", roleNumber)).list();
		if (list.size() == 1) {
			dto = (MarksheetDTO) list.get(0);
		}
		log.debug("Marksheet DAO FindByRollNumber Ended");
		return dto;
	}

	/**
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findByPK(long pk) {
		log.debug("Marksheet DAO Find by PK Started");
		MarksheetDTO dto = null;
		dto = (MarksheetDTO) sessionfactory.getCurrentSession().get(MarksheetDTO.class, pk);
		log.debug("Marksheet DAO Find by PK Ended");
		return dto;
	}

	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize) {
		log.debug("Marksheet DAO search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(MarksheetDTO.class);
		
		if(dto!=null)
		
		{
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
        if (dto.getName() != null && dto.getName().length() > 0) {
            criteria.add(Restrictions.like("name", dto.getName() + "%"));
        }
        if(dto.getStudentId()>0){
        	criteria.add(Restrictions.eq("studentId", dto.getStudentId()));
        }
        if(dto.getRollNo()!=null&&dto.getRollNo().length()>0){
        	criteria.add(Restrictions.eq("rollNo", dto.getRollNo()));
        }
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }
		List<MarksheetDTO> list = criteria.list();
		log.debug("Marksheet DAO search End");
		return list;

	}

	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}
	
	/**
	 * Gets the merit list.
	 *
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the merit list
	 */
	public List getMeritList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer hql=new StringBuffer("from MarksheetDTO order by (physics+chemistry+maths) desc");
		Query q=sessionfactory.getCurrentSession().createQuery(hql.toString());
		if(pageSize>0){
			q.setFirstResult((pageNo-1)*pageSize);
			q.setMaxResults(pageSize);
		}
		List list=q.list();
		
		return list;
	}

}
