package model;

public class PdfFactory implements IReportFactory {

	@Override
	public IReport build() {
		
		return new Pdf();
	}

}
