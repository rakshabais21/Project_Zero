package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.SubjectDAOInt;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Class SubjectServiceSpringImpl.
 */
@Service
public class SubjectServiceSpringImpl implements SubjectServiceInt {

	/** The dao. */
	@Autowired
	SubjectDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

    /**
     * Adds the.
     *
     * @param dto the dto
     * @return the long
     * @throws DuplicateRecordException the duplicate record exception
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {
    	log.debug("SubjectServiceSpringImpl Add Started");
        SubjectDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Subject Name is already exists");
        }
        long pk = dao.add(dto);
        log.debug("SubjectServiceSpringImpl Add End");
        return pk;
	}
    
    /**
     * Update.
     *
     * @param dto the dto
     * @throws DuplicateRecordException the duplicate record exception
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
    	log.debug("SubjectServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("SubjectServiceSpringImpl update End");
	}
    
    /**
     * Delete.
     *
     * @param id the id
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("SubjectServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("SubjectServiceSpringImpl delete End");
		
	}
    
    /**
     * Find by name.
     *
     * @param subjectName the subject name
     * @return the subject DTO
     */
    @Transactional( readOnly = false)
	public SubjectDTO findByName(String subjectName) {
		log.debug("SubjectServiceSpringImpl findByName Started");
    	SubjectDTO dto = dao.findByName(subjectName);
    	log.debug("SubjectServiceSpringImpl findByName End");
    	return dto;
	}
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the subject DTO
     */
    @Transactional( readOnly = false)
	public SubjectDTO findById(long id) {
		log.debug("SubjectServiceSpringImpl findById Started");
    	SubjectDTO dto = dao.findByPK(id);
    	log.debug("SubjectServiceSpringImpl findById End");
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
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
    
    /**
     * Search.
     *
     * @param dto the dto
     * @return the list
     */
    @Transactional( readOnly = false)
	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		 return dao.search(dto);
	}

}
