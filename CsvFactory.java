package model;

public class CsvFactory implements IReportFactory {

	@Override
	public IReport build() {
		Csv c= new Csv();
		c.build();
		return c;
	}
}
