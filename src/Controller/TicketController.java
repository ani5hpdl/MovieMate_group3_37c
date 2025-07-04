package Controller;

import Model.TicketModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import view.Ticket;
import java.io.File;

public class TicketController {

    public static void saveTicketAsPDF(Ticket ticket) {
        try {
            Document document = new Document();
            String filePath = "Ticket_" + System.currentTimeMillis() + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("Movie Ticket", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            TicketModel model = extractTicketData(ticket);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);

            addRow(table, "Movie Name", model.getMovieName());
            addRow(table, "Ticket ID", model.getTicketId());
            addRow(table, "Date", model.getDate());
            addRow(table, "Time", model.getTime());
            addRow(table, "Duration", model.getDuration());
            addRow(table, "Seat", model.getSeatNo());
            addRow(table, "Theater No", model.getTheaterNo());
            addRow(table, "VAT", model.getVat());
            addRow(table, "Total Amount", model.getTotalAmount());

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(ticket, "PDF saved at: " + filePath);
                    System.out.println("PDF saved at: " + new File(filePath).getAbsolutePath());

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ticket, "Error saving PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addRow(PdfPTable table, String key, String value) {
        table.addCell(new PdfPCell(new Phrase(key)));
        table.addCell(new PdfPCell(new Phrase(value)));
    }

    private static TicketModel extractTicketData(Ticket ticket) {
        return new TicketModel(
            ticket.getMovieNameText(),
            ticket.getDurationText(),
            ticket.getDateText(),
            ticket.getTimeText(),
            ticket.getSeatText(),
            ticket.getTicketIdText(),
            ticket.getTheaterNoText(),
            ticket.getVatText(),
            ticket.getTotalText()
        );
    }
}
