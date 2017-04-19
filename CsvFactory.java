package model;

public class CsvFactory implements IReportFactory {

	@Override
	public IReport build() {
		return new Csv();
	}
}
