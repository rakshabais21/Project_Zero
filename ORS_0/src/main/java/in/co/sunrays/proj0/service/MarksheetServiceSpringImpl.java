package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.MarksheetDAOInt;
import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class MarksheetServiceSpringImpl.
 */
@Service
public class MarksheetServiceSpringImpl implements MarksheetServiceInt{

	/** The dao. */
	@Autowired
	MarksheetDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(MarksheetServiceSpringImpl.class);
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl Add Started");
		
		System.out.println("inside service--------------->");
		MarksheetDTO dtoExist = dao.findByRollNumber(dto.getRollNo());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Role Number already exists");
        }
        long pk = dao.add(dto);
        log.debug("MarksheetServiceSpringImpl Add End");
        return pk;
	}
	
	/**
	 * Update.
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("MarksheetServiceSpringImpl update End");
		
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("MarksheetServiceSpringImpl delete Start");
   	 dao.delete(id);
   	log.debug("MarksheetServiceSpringImpl delete End");
		
	}
	
	/**
	 * Find by roll number.
	 *
	 * @param roleNumber the role number
	 * @return the marksheet DTO
	 */
	@Transactional(readOnly = false)
	public MarksheetDTO findByRollNumber(String roleNumber) {
		log.debug("MarksheetServiceSpringImpl findByRollNumber Started");
		MarksheetDTO dto = dao.findByRollNumber(roleNumber);
    	log.debug("MarksheetServiceSpringImpl findByRollNumber End");
    	return dto;
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the marksheet DTO
	 */
	@Transactional(readOnly = false)
	public MarksheetDTO findById(long id) {
		log.debug("MarksheetServiceSpringImpl findById Started");
		MarksheetDTO dto = dao.findByPK(id);
    	log.debug("MarksheetServiceSpringImpl findById End");
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
	@Transactional(readOnly = false)
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	@Transactional(readOnly = false)
	public List<MarksheetDTO> search(MarksheetDTO dto) {
		
		return dao.search(dto);
	}
	
	/**
	 * Gets the merit list.
	 *
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the merit list
	 */
	@Transactional(readOnly = false)
	public List<MarksheetDTO> getMeritList( int pageNo, int pageSize) {
		
		return dao.getMeritList(pageNo, pageSize);
	}

}
