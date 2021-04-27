package in.co.sunrays.proj0.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

// TODO: Auto-generated Javadoc
/**
 * The Class JasperCtl.
 */
@Transactional
@Controller
@RequestMapping(value="/ctl/Jasper")
public class JasperCtl {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory=null;
	
	/** The context. */
	@Autowired
	ServletContext context;
	
	
	
	/**
	 * Display.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws JRException the JR exception
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void display(HttpServletRequest request, HttpServletResponse response) throws JRException, SQLException, IOException {
		
		String path = context.getRealPath("/WEB-INF/MarksheetReport.jrxml");
		
		Connection con = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(path);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		con = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
		System.out.println("1");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);
		System.out.println("2");
		byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
		response.setContentType("application/pdf");
		response.getOutputStream().write(pdf);
		response.getOutputStream().flush();
	}


	
}