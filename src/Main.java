import com.sun.jna.win32.StdCallLibrary;

import com.sun.jna.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by merkurev on 09.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        //System.setProperty("jna.library.path", );

//        NativeLibrary.addSearchPath("ODK_RW_Tags", "c:\");
        ODKRWTags wincc = ODKRWTags.INSTANCE;

        Integer state = wincc.WinCC_Connect();
//        System.out.println("float " + wincc.ReadTag_Real32("NewTag"));
        wincc.WriteTag_Real("Float", 10.888);
//        wincc.WriteTag_Integer("NewTag1", 9);
        System.out.println("float " + wincc.ReadTag_Real32("Float"));

        String[] str = new String[1];
        str[0] = "";

//        wincc.ReadTag_Text("NewTag_3", str);
        wincc.ReadTag_Text("Text", str);
//        str = wincc.ReadTag_Text("NewTag_1");
        System.out.println("state " + state + "");

        System.out.println(str[0]);
        str[0] = "Тест Test";
//        wincc.WriteTag_Text("Text", str);

        wincc.WriteTag_Integer("B1", 1);
        wincc.WriteTag_Integer("B2", 0);
        System.out.println(wincc.ReadTag_Boolean("B2"));

    }
    public interface ODKRWTags extends StdCallLibrary{


        ODKRWTags INSTANCE = (ODKRWTags) Native.loadLibrary("ODK_RW_Tags",ODKRWTags.class);
        ODKRWTags SYNC_INSTANCE = (ODKRWTags) Native.synchronizedLibrary(INSTANCE);
        Integer WinCC_Connect();
        void WinCC_Disconnect();
        void ReadTag_Text(String Tagname, String value);
        void ReadTag_Text(String Tagname, String[] value);
        boolean ReadTag_Boolean(String Tagname);
        void WriteTag_Text(String Tagname, String[] value);
        double ReadTag_Real32(String Tagname);
        void WriteTag_Real(String Tagname, double real);
        void WriteTag_Integer(String Tagname, int real);
    }
}
