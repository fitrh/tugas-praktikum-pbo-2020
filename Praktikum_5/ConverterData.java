public class ConverterData extends Converter implements Data{


    @Override
    public long teraToGiga(long teraTG) {
        double tera = Math.pow(1024, 1);
        long gigaByteConvert = teraTG * (long) tera;
        return gigaByteConvert;
    }

    @Override
    public long teraToMega(long teraTM) {
        double tera = Math.pow(1024, 2);
        long megaByteConvert = teraTM * (long)tera;
        return megaByteConvert;
    }

    @Override
    public long teraToKilo(long teraTK) {
        double tera = Math.pow(1024, 3);
        long kiloByteConvert = teraTK * (long) tera;
        return kiloByteConvert;
    }

    @Override
    public void start() {
        
        System.out.println("Data Converter is Started");

    }

    @Override
    public void stop() {
        System.out.println("Data Converter is Terminated");

    }

}