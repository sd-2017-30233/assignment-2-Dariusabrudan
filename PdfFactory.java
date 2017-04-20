package model;

public class PdfFactory implements IReportFactory {

	@Override
	public IReport build() {
		
		Pdf p=new Pdf();
		p.build();
		return p;
	}

}
