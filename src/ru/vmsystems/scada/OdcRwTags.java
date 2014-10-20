package ru.vmsystems.scada;


import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Created by Minikh Vladimir on 11.10.2014.
 */
public interface OdcRwTags extends StdCallLibrary {

    OdcRwTags INSTANCE = (OdcRwTags) Native.loadLibrary("ODK_RW_Tags", OdcRwTags.class);
    OdcRwTags SYNC_INSTANCE = (OdcRwTags) Native.synchronizedLibrary(INSTANCE);

    Integer WinCC_Connect();
    void WinCC_Disconnect();

    void ReadTag_Text(String Tagname, String[] value);
//    void WriteTag_Text(String Tagname, String[] value);

    boolean ReadTag_Boolean(String Tagname);

    double ReadTag_Real32(String Tagname);
    void WriteTag_Real(String Tagname, double value);

    int ReadeTag_Integer(String Tagname);
    void WriteTag_Integer(String Tagname, int value);

    int ProjectStatus();
}


