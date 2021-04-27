package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.RoleDAOInt;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleServiceSpringImpl.
 */
@Service
public class RoleServiceSpringImpl implements RoleServiceInt{

	/** The dao. */
	@Autowired
    private RoleDAOInt dao;

    /** The log. */
    private static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);

    /**
     * Adds the.
     *
     * @param dto the dto
     * @return the long
     * @throws DuplicateRecordException the duplicate record exception
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(RoleDTO dto) throws DuplicateRecordException {
    	
    	log.debug("RoleServiceSpringImpl Add Started");
        RoleDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Role Name already exists");
        }
        long pk = dao.add(dto);
        log.debug("RoleServiceSpringImpl Add End");
        return pk;
	}

    /**
     * Update.
     *
     * @param dto the dto
     * @throws DuplicateRecordException the duplicate record exception
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(RoleDTO dto) throws DuplicateRecordException {
    	log.debug("RoleServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("RoleServiceSpringImpl update End");
	}

    /**
     * Delete.
     *
     * @param id the id
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
    	log.debug("RoleServiceSpringImpl delete Started");
    	 dao.delete(id);
    	log.debug("RoleServiceSpringImpl delete End");
        
	}

    /**
     * Find by name.
     *
     * @param roleName the role name
     * @return the role DTO
     */
    @Transactional(readOnly = true)
	public RoleDTO findByName(String roleName) {
    	log.debug("RoleServiceSpringImpl findByName Started");
    	RoleDTO dto = dao.findByName(roleName);
    	log.debug("RoleServiceSpringImpl findByName End");
    	return dto;
	}

    /**
     * Find by id.
     *
     * @param id the id
     * @return the role DTO
     */
    @Transactional(readOnly = true)
	public RoleDTO findById(long id) {
		log.debug("RoleServiceSpringImpl findById Started");
    	RoleDTO dto = dao.findByPK(id);
    	log.debug("RoleServiceSpringImpl findById End");
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
    @Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) {
    	return dao.search(dto, pageNo, pageSize);

	}

    /**
     * Search.
     *
     * @param dto the dto
     * @return the list
     */
    @Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto) {
    	return dao.search(dto);
	}
}
