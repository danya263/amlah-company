/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amlahproject;

import static amlahproject.pdfmaker.f;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */

public class HeaderFooterPageEvent extends PdfPageEventHelper {
      public static Font  f=FontFactory.getFont("c:/windows/fonts/simpo.ttf", BaseFont.IDENTITY_H,16);
       public static Font  fh=FontFactory.getFont("c:/windows/fonts/simpo.ttf",  BaseFont.IDENTITY_H,16,1,BaseColor.GRAY);
         public static Font  ff=FontFactory.getFont("c:/windows/fonts/simpo.ttf",  BaseFont.IDENTITY_H,12,1,BaseColor.GRAY);
    public void onStartPage(PdfWriter writer,Document document) {
//    	Rectangle rect = writer.getBoxSize("art");
//        Phrase p=new Phrase("DDDDDDDDDd");
////        p.setFont(f);
//        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, p, rect.getLeft(), rect.getTop(),0);
//        
//       Paragraph p1=new Paragraph(" DD", f);

      PdfPTable table1 = new PdfPTable(1);
        table1.setWidthPercentage(100);
        PdfPTable table2 = new PdfPTable(6);
        table2.setWidthPercentage(100);
         
        //table.setWidths(new int[]{1, 2,});
        //table heading
        PdfPCell cell_head = new PdfPCell();
              cell_head.setRunDirection(writer.RUN_DIRECTION_RTL);
              Paragraph h1=new Paragraph("مكتبة ومعرض طيور الجنة للالعاب "+"\n"+"    ", fh);
              h1.setAlignment(PdfPCell.ALIGN_CENTER);
              cell_head.addElement(h1);
              cell_head.setBorder(0);
              table1.addCell(cell_head);
         String[] top={"ID"," أسم الصنف","وصف الصنف ","الصورة ","أبعاد الصنف ","السعر"};

         
          //لاضافة العناوين
          for(int i=0;i<6;i++){
               PdfPCell cell = new PdfPCell();
              cell.setRunDirection(writer.RUN_DIRECTION_RTL);
              Paragraph h=new Paragraph(top[i], f);
              h.setAlignment(PdfPCell.ALIGN_CENTER);
              cell.addElement(h);
              cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
              table2.addCell(cell);
          }
          try {
               document.add(table1);
              document.add(table2);
          } catch (DocumentException ex) {
              Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
          }
//              p1.setAlignment(PdfPCell.ALIGN_CENTER);
//        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, p1, rect.getRight(), rect.getTop(), 0);
    }
    public void onEndPage(PdfWriter writer,Document document) {
        PdfPTable table3 = new PdfPTable(1);
        table3.setWidthPercentage(100);
    	PdfPCell cell_head = new PdfPCell();
              cell_head.setRunDirection(writer.RUN_DIRECTION_RTL);
              Paragraph h1=new Paragraph(
                   "نابلس -شارع فيصل -مقابل محطة المصري للمحروقات :                                         للتواصل:0599389495"
                           , ff);
              h1.setAlignment(PdfPCell.ALIGN_LEFT);
              cell_head.addElement(h1);
              cell_head.setBorder(0);
              table3.addCell(cell_head);
          try {
              document.add(table3);
          } catch (DocumentException ex) {
              Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
 
}