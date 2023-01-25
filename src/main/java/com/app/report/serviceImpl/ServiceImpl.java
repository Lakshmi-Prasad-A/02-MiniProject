package com.app.report.serviceImpl;

import java.awt.Color;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.report.entity.Plans;
import com.app.report.entity.SearchRequest;
import com.app.report.entity.UserReports;
import com.app.report.repo.PlansRepo;
import com.app.report.repo.UserRepo;
import com.app.report.serviceInter.ServiceInterface;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private PlansRepo prepo;



	@Override
	public List<String> findByPlanName() {
		return prepo.findByPlanName();
	}
 
	public List<String> findByPlanStatus() { 
		return urepo.findByPlanStatus(); 
		}
	
	public List<UserReports> getUserReportsPlans (SearchRequest request){
		UserReports entity = new UserReports();
		
		if(request.getPlanName()!=null && !request.getPlanName().equals("")) {
			entity.setPlan(new Plans(request.getPlanId(),request.getPlanName()));
		}
		if(request.getPlanStatus()!=null && !request.getPlanStatus().equals("")) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		Example<UserReports> example = Example.of(entity);
		  
		List<UserReports> records = urepo.findAll();
		
		return records;
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws Exception {
		List<UserReports> reports = urepo.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("UserReports Info");
		HSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("userId");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Email");
		headerRow.createCell(3).setCellValue("Mobilenum");
		headerRow.createCell(4).setCellValue("Gender");
		headerRow.createCell(5).setCellValue("SSN");
		headerRow.createCell(6).setCellValue("PlanStatus");
		
		List<UserReports> records = urepo.findAll();
		
		int dataRowIndex = 1;
		for(UserReports record : records) {
			
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			
			dataRow.createCell(0).setCellValue(record.getUserId());
			dataRow.createCell(1).setCellValue(record.getName());
			dataRow.createCell(2).setCellValue(record.getEmail());
			dataRow.createCell(3).setCellValue(record.getMobilenum());
			dataRow.createCell(4).setCellValue(record.getGender());
			dataRow.createCell(5).setCellValue(record.getSsn());
			dataRow.createCell(6).setCellValue(record.getPlanStatus());
			
			
			dataRowIndex++;	
		}
		ServletOutputStream outputStream = response.getOutputStream();
		
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	@Override
	public void exportPdf(HttpServletResponse response) throws Exception {
		List<UserReports> records = urepo.findAll();
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
		
		Paragraph p = new Paragraph("UserReports Info", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		
		PdfPTable table =  new PdfPTable(6);
		
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 1.5f});
		table.setSpacingBefore(10);
		
		// Set Table Header data
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		Font f = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("User Id", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("MobileNum", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Gender", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("SSN", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("PlanStatus", font));
        table.addCell(cell); 
		
		// set Table data 
        List<UserReports> reports = urepo.findAll();
        for(UserReports report : reports) {
        	table.addCell(String.valueOf(report));
        	table.addCell(String.valueOf(report.getUserId()));
            table.addCell(report.getEmail());
            table.addCell(String.valueOf(report.getMobilenum()));
            table.addCell(report.getGender());
            table.addCell(String.valueOf(report.getSsn()));
            table.addCell(String.valueOf(report.getPlanStatus()));
        	
        }
		
		document.add(table);
		document.close();
		
		
	}

}
