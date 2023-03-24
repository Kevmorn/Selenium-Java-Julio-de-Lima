package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class generator {
    public static String dataHoraParaArquivo() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return  new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
