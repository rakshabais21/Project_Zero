package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.CourseDAOInt;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class CourseServiceSpringImpl.
 */
@Service
public class CourseServiceSpringImpl implements CourseServiceInt {
	
	/** The dao. */
	@Autowired
	CourseDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(CourseDTO dto) throws DuplicateRecordException {

    	log.debug("CourseServiceSpringImpl Add Started");
    	CourseDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Course Name already exists");
        }
        long pk = dao.add(dto);
        log.debug("CourseServiceSpringImpl Add End");
        return pk;
	}
	
	/**
	 * Update.
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("CourseServiceSpringImpl update End");
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		log.debug("CourseServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("CourseServiceSpringImpl delete End");
		
	}
	
	/**
	 * Find by name.
	 *
	 * @param courseName the course name
	 * @return the course DTO
	 */
	@Transactional(readOnly = false)
	public CourseDTO findByName(String courseName) {
		log.debug("CourseServiceSpringImpl findByName Started");
		CourseDTO dto = dao.findByName(courseName);
    	log.debug("CourseServiceSpringImpl findByName End");
    	return dto;
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the course DTO
	 */
	@Transactional(readOnly = false)
	public CourseDTO findById(long id) {
		log.debug("CourseServiceSpringImpl findById Started");
		CourseDTO dto = dao.findByPK(id);
    	log.debug("CourseServiceSpringImpl findById End");
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
	@Transactional( readOnly = false)
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	@Transactional(readOnly = false)
	public List<CourseDTO> search(CourseDTO dto) {
		return dao.search(dto);
	}

}
