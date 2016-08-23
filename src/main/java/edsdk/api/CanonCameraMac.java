package edsdk.api;

import org.bridj.Platform;

import com.sun.jna.Function;
import com.sun.jna.Library;
import com.sun.jna.Native;

import edsdk.bindings.EdSdkLibrary;

/**
 * this class is a EDSDK Version 2.15 implementation that should work on MacOSX
 * @author wf
 *
 */
public class CanonCameraMac extends BaseCanonCamera {
 // This gives you direct access to the EDSDK
    public static EdSdkLibrary EDSDK = null;

    static {
        initLibrary();
        options.put(Library.OPTION_CALLING_CONVENTION, Function.ALT_CONVENTION);
        // options.put(Library.OPTION_CALLING_CONVENTION, Function.C_CONVENTION);
        EDSDK = (EdSdkLibrary) Native.loadLibrary( edsdkDllLoc, EdSdkLibrary.class, options );
        if (Platform.isMacOSX()) {
        	String javalibpath = System.getProperty("java.library.path");
        	System.out.println(javalibpath);
        }
    }

}
