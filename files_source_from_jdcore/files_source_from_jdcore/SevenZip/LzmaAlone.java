package SevenZip;

import java.io.File;

public class LzmaAlone { public LzmaAlone() {}
  public static void decompress(File in, File out) throws Exception { File inFile = in;
    File outFile = out;
    
    java.io.BufferedInputStream inStream = new java.io.BufferedInputStream(new java.io.FileInputStream(inFile));
    java.io.BufferedOutputStream outStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(outFile));
    
    int propertiesSize = 5;
    byte[] properties = new byte[propertiesSize];
    if (inStream.read(properties, 0, propertiesSize) != propertiesSize) {
      throw new Exception("input .lzma file is too short");
    }
    SevenZip.Compression.LZMA.Decoder decoder = new SevenZip.Compression.LZMA.Decoder();
    if (!decoder.SetDecoderProperties(properties)) {
      throw new Exception("Incorrect stream properties");
    }
    long outSize = 0L;
    for (int i = 0; i < 8; i++) {
      int v = inStream.read();
      if (v < 0) {
        throw new Exception("Can't read stream size");
      }
      outSize |= v << 8 * i;
    }
    if (!decoder.Code(inStream, outStream, outSize)) {
      throw new Exception("Error in data stream");
    }
    
    outStream.flush();
    outStream.close();
    inStream.close();
  }
}
