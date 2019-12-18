package com.heitor.qrCodeGenerator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * 
 *
 */
public class App {

	private static final String QR_CODE_IMAGE_PATH = "./EXTRAS/imgQRGerada/";

	private static void generateQRCodeImage(String text, int width, int height, String filePath)

		throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
//		JOptionPane.showMessageDialog(null, "QR CODE GERADO");
	}

	public static void main(String[] args) {
		
		
//		String filePath =JOptionPane.showInputDialog("\n\n Digite Nome QR CODE ");
//		String text =JOptionPane.showInputDialog("\n\n Digite seu Texto ");
		String text = "nome";
		String filePath = "teste";
		filePath  = QR_CODE_IMAGE_PATH+filePath.replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "")+".png";

		
		try {
			generateQRCodeImage(text, 350, 350, filePath);
		} catch (WriterException e) {			
			JOptionPane.showMessageDialog(null, "Não foi possível gerar o QR Code, WriterException :: " + e.getMessage());
			System.out.println("Não foi possível gerar o QR Code, WriterException :: " + e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível gerar o QR Code, IOException :: " + e.getMessage());
			System.out.println("Não foi possível gerar o QR Code, IOException :: " + e.getMessage());
		}
		

	}
	
}
