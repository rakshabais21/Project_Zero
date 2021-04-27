package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.TimeTableDAOInt;
import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class TimeTableServiceSpringImpl.
 */
@Service
public class TimeTableServiceSpringImpl implements TimeTableServiceInt{
    
    /** The dao. */
    @Autowired
	TimeTableDAOInt dao;

/** The log. */
private static Logger log = Logger.getLogger(TimeTableServiceSpringImpl.class);
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public long add(TimeTableDTO dto) throws DuplicateRecordException {

    	log.debug("CourseServiceSpringImpl Add Started");
    	TimeTableDTO dtoExist1 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSubjectId(), dto.getExamDate());
    	TimeTableDTO dtoExist2 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getExamDate());
    	TimeTableDTO dtoExist3 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getSubjectId());
    	if (dtoExist1 != null||dtoExist2!=null||dtoExist3!=null) {
            throw new DuplicateRecordException("TimeTable already exists");
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
	public void update(TimeTableDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update Started");
		TimeTableDTO dtoExist1 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSubjectId(), dto.getExamDate());
    	TimeTableDTO dtoExist2 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getExamDate());
    	TimeTableDTO dtoExist3 = dao.findTimeTableDuplicacy(dto.getCourseId(), dto.getSemester(), dto.getSubjectId());
    	
    	if (dtoExist1 != null&&dtoExist1.getId()!=dto.getId()) {
            throw new DuplicateRecordException("TimeTable already exists");
        }if (dtoExist2!=null&&dtoExist2.getId()!=dto.getId()) {
            throw new DuplicateRecordException("TimeTable already exists");
        }if (dtoExist3!=null&&dtoExist3.getId()!=dto.getId()) {
            throw new DuplicateRecordException("TimeTable already exists");
        }
		
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
	 * Find by pk.
	 *
	 * @param id the id
	 * @return the time table DTO
	 */
	@Transactional( readOnly = false)
	public TimeTableDTO findByPk(long id) {
		log.debug("CourseServiceSpringImpl findById Started");
		TimeTableDTO dto = dao.findByPK(id);
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
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	@Transactional( readOnly = false)
	public List<TimeTableDTO> search(TimeTableDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

}
